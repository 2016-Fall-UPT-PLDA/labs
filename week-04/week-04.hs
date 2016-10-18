import Parsers
import Exprs as E

import Data.Char
import Control.Monad
import Control.Applicative

















































number :: Parser Integer
number = 
    do
        ds <- some digit
        return (read ds :: Integer)

constInt :: Parser E.Expr
constInt = 
    do
        n <- token number
        return $ E.Const (E.IntV n)

addExprP :: Parser E.Expr
addExprP = 
    do
        lhs <- constInt
        token $ literal "+"
        rhs <- constInt
        return $ lhs E.:+: rhs

lambdaExprP :: Parser E.Expr
lambdaExprP = 
    do
        token $ literal "/"
        vars <- many
        rhs <- constInt
        return $ lhs E.:+: rhs

expr :: Parser E.Expr
expr = addExprP <|> constInt


ifP = do
        spaces
        literal "if" `context` "ifP"

test s = runParser expr s