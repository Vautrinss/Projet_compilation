// GrammarJB.g4

grammar GrammarJB;

// This will be the entry point of our parser.
expr : (Type | X | boolExpr | atomExpr | additionExpr | multiplyExpr) ;

// Addition and subtraction have the lowest precedence.
additionExpr : multiplyExpr ('+' multiplyExpr | '-' multiplyExpr ) * ;

// Multiplication and division have a higher precedence.
multiplyExpr : atomExpr ('*' atomExpr | '/' atomExpr ) * ;

/* An expression atom is the smallest part of an expression: a number. Or 
   when we encounter parenthesis, we're making a recursive call back to the
   rule 'additionExpr'. As you can see, an 'atomExpr' has the highest
   precedence. */
atomExpr : X | Number | '(' additionExpr ')' | '-' atomExpr | X ;

// relations binaires avec && et ||
combinBinarExpr : bop ('and' bop | 'or' bop ) * ;

//uop deja pris en compte dans atomExpr et boolExpr

boolExpr : Boolean |  combinBinarExpr | bop | 'not' boolExpr ;

i:(cond | expr);
cond : ('if' expr 'then' expr 'else' expr | 'while' expr 'do' i);

// fonction
d: 'f('( X':' Type)* ')' 'var'(X':'Type)* i;

//programme
p : 'var'(X':'Type)* d* i;

//
arrayExpr : 'new' Array '[' expr ']' ;


//operateur binaire
bop : atomExpr ('<' atomExpr | '<=' atomExpr | '>' atomExpr | '>=' atomExpr | '!=' atomExpr | '=' atomExpr) ; 

appelExpr : ('read' | 'write' | 'f') ('(' expr ')') * ;

// A number is an integer value
Number : ('0'..'9')+ ;

// Boolean true ou false
Boolean : ('true' | 'false') ;

// Type demande
Type : (Number | Boolean | 'array' 'of' Type) ;

// Constante
k : (Number | Boolean) ;


// operateur unaire
uop : ('0 -' Number) ;

//
Array : 'array' 'of' Type;

// Variable (impossible de savoir pourquoi ya que grand X qui marche)
X: [a-z]+ ;





// We're going to ignore all white space characters
WS : [ \t\r\n]+ -> skip ;
