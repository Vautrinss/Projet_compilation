// ExprArith.g4

grammar ExprArith;

// This will be the entry point of our parser.
expr : additionExpr | multiplyExpr | k | var | Boolean ;

// Addition and subtraction have the lowest precedence.
additionExpr : multiplyExpr ('+' multiplyExpr | '-' multiplyExpr)* ;

// Multiplication and division have a higher precedence.
multiplyExpr : atomExpr ('*' atomExpr | '/' atomExpr)* ;

/* An expression atom is the smallest part of an expression: a number. Or 
   when we encounter parenthesis, we're making a recursive call back to the
   rule 'additionExpr'. As you can see, an 'atomExpr' has the highest
   precedence. */
//atomExpr : Number | '(' additionExpr ')' | '-' atomExpr ;
atomExpr : Number | '(' additionExpr ')' | uop ;

BoolExpr : Boolean | boolExpre 'and' boolExpr | boolExpr 'or' boolExpr ;

arrayExpr = 'new' array '(' expr ')' ;

//operateur binaire
bop : atomExpr | ('<' atomExpr | '<=' atomExpr | '>' atomExpr | '>=' atomExpr | '=' atomExpr) ; 

appelExpr = ('read' | 'write' | 'f') ('(' expr ')') * ;

// A number is an integer value
Number : ('0'..'9')+ ;

// Boolean true ou false
Boolean : ('true' | 'false') ;

// Type demande
TYPE : (Number | Boolean | array) ;

// Constante
k = (Number | Boolean) ;

// Variable
var = ('a' .. 'z')+ ;

// operateur unaire
uop = ('0 -' Number) ;




// We're going to ignore all white space characters
WS : [ \t\r\n]+ -> skip ;
