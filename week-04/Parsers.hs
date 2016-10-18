--http://dev.stephendiehl.com/fun/002_parsers.html
--{-# OPTIONS_GHC -fno-warn-unused-do-bind #-}
{-# LANGUAGE ScopedTypeVariables #-}

module Parsers where

import Data.Char
import Control.Monad
import Control.Applicative

data Try a = 
    Success a |
    Failure String
    deriving (Show, Eq)

newtype Parser a = Parser { parse :: String -> Try (a, String) }

runParser :: Parser a -> String -> a
runParser parser input =
  case parse parser input of
    Success (res, []) -> res
    Success (_, rs)   -> error $ "Parser did not consume entire input, what remained: " ++ rs
    Failure msg       -> error $ "Parser error: " ++ msg

--------------------------------------------------------------------------
----------------------------- Monad Instances ----------------------------
--------------------------------------------------------------------------

tupleNext :: (a -> b) -> (a, String) -> (b, String)
tupleNext f tuple = (f $ fst tuple, snd tuple)

instance Functor Try where
    fmap f (Success v) = Success $ f v
    fmap f (Failure msg) = Failure msg

instance Applicative Try where
    pure v = Success v
    (<*>) (Success f) (Success v) = Success $ f v
    (<*>) (Success v) (Failure msg) = Failure msg
    (<*>) (Failure msg) (Success v) = Failure msg
    (<*>) (Failure msg1) (Failure msg2) = Failure msg1

instance Monad Try where
    return = pure
    (>>=) (Success v) f = f v
    (>>=) (Failure msg) f = Failure msg
    (>>) (Success v) t2 = t2
    (>>) (Failure msg) t2 = Failure msg
    fail msg = Failure msg

instance Functor Parser where
    fmap = morphParserResult

morphParserResult :: (a -> b) -> Parser a -> Parser b 
morphParserResult f p = 
    Parser $ \input -> 
        let fun = tupleNext f
            newResult = (parse p $ input) in fmap fun newResult

instance Applicative Parser where
    pure v = Parser $ \input -> Success $ (v, input)
    p1 <*> p2 = applyImpl p1 p2

applyImpl :: Parser (a -> b) -> Parser a -> Parser b
applyImpl p1 p2 = Parser $ \input -> 
    let r1 = parse p1 $ input in
        case r1 of
            Success (f, next) -> fmap (tupleNext f) (parse p2 $ next)
            Failure msg -> Failure msg

instance Monad Parser where
    return = pure
    (>>=) p f = 
        Parser $ \input ->
            let r1 = parse p $ input in
                case r1 of
                    Success (v, next) -> parse (f v) next
                    Failure msg -> Failure msg
    (>>) p1 p2 = 
        do
            _ <- p1
            r1 <- p2
            return r1
    fail msg = Parser $ \s -> Failure msg

instance MonadPlus Parser where
  mzero = Parser (\input -> Failure "parser failed")
  mplus p q = undefined -- how to combine two parsers?

instance Alternative Parser where
  empty = mzero
  (<|>) = option

option :: Parser a -> Parser a -> Parser a
option  p q = Parser $ \s ->
  case parse p s of
    Failure msg -> parse q s
    res -> res



--------------------------------------------------------------------------
------------------------------ Basic Parsers -----------------------------
--------------------------------------------------------------------------
context :: Parser a -> String -> Parser a
context p newMsg = 
    Parser $ \input ->
            let r1 = parse p $ input in
                case r1 of
                    Failure msg -> Failure $msg ++ " ====> " ++ newMsg
                    s -> s

item :: Parser Char
item = Parser $ \input ->
  case input of
   []     -> Failure "expected character but got []"
   (c:cs) -> Success (c,cs)

literalChar :: Char -> Parser Char
literalChar c = 
    do
        r1 <- item
        if(r1 == c) 
            then return r1 
            else fail $ "expected: " ++ (show c) ++ ", but received: " ++ (show r1)  

digit :: Parser Char
digit = 
    do
        r1 <- item
        if(isDigit r1) 
            then return r1 
            else fail $ "expected a digit" ++ ", but received: " ++ (show r1)  


literal :: String -> Parser String
literal s = traverse literalChar s


spaces :: Parser String
spaces = many $ literalChar ' '

token :: Parser a -> Parser a
token p = do 
    spaces
    a <- p 
    spaces  
    return a
--TODO:
-- implement MultiFailure
