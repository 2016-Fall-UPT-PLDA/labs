import Parsers

ifP = literal "if" `context` "ifP"

test s = runParser ifP s