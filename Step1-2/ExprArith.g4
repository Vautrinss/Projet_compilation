// ExprArith.g4

grammar ExprArith;

// This will be the entry point of our parser.
expr : additionExpr ;

// Addition and subtraction have the lowest precedence.
additionExpr : multiplyExpr ('+' multiplyExpr | '-' multiplyExpr)* ;

// Multiplication and division have a higher precedence.
multiplyExpr : atomExpr ('*' atomExpr | '/' atomExpr)* ;

/* An expression atom is the smallest part of an expression: a number. Or 
   when we encounter parenthesis, we're making a recursive call back to the
   rule 'additionExpr'. As you can see, an 'atomExpr' has the highest
   precedence. */
atomExpr : Number | '(' additionExpr ')' | '-' atomExpr ;

//operateur binaire
bop : atomExpr | ('<' atomExpr | '<=' atomExpr | '>' atomExpr | '>=' atomExpr | '!=' atomExpr | '=' atomExpr) ;

appelExpr : ('read' | 'write' | 'f') ('(' expr ')') * ; 

arrayExpr : 'new' Array '[' expr ']' ;

combinatedBinarExpr : bop ('and' bop | 'or' bop ) * ;

boolExpr : Boolean | '(' combinatedBinarExpr ')' | bop | 'not' boolExpr ;







// A number is an integer value
Number : ('0'..'9')+ ;

// Boolean true ou false
Boolean : ('true' | 'false') ;

//
Array : 'array' 'of' Type;

// Type demande
Type : (Number | Boolean | Array) ;

// Constante
k : (Number | Boolean) ;

// operateur unaire
uop : ('0 -' Number) ;




// We're going to ignore all white space characters
WS : [ \t\r\n]+ -> skip ;
