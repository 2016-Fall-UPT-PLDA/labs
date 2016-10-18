module Exprs where

data Val = IntV Integer
     | FloatV Float
     | CharV Char
     | StringV String
     | BooleanV Bool
     -- since we are implementing a Functional language, functions are
     -- first class citizens.
     | LambdaV [String] Expr Env
 deriving (Show, Eq)

-----------------------------------------------------------
data Expr = 
            Const Val
          
          -- represents a variable
          | Var String
          
          -- integer multiplication
          | Expr :*: Expr 

          -- integer addition and string concatenation
          | Expr :+: Expr 
          
          -- equality test. Defined for all Val except FunVal
          | Expr :==: Expr 
         
          -- semantically equivalent to a Haskell `if`
          | If Expr Expr Expr
         
          -- binds a Var (the first `Expr`) to a value (the second `Expr`), 
          -- and makes that binding available in the third expression
          | Let String Expr Expr
         
          -- similar to Let but allows for recursive definitions. You can also make
          -- the above Let support this, and simply remove this expression. But since
          -- implementing a recursive definition of Let is a bit trickier, you will want
          -- at least implement a non-recursive Let.
          | Letrec String Expr Expr
         
          -- creates an anonymous function with an arbitrary number of parameters
          | Lambda [String] Expr 
         
          -- calls a function with an arbitrary number values for parameters
          | Apply Expr [Expr]
     deriving (Show, Eq)

data Env = EmptyEnv
         | ExtendEnv String Val Env
     deriving (Show, Eq)