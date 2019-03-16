
grammar MxStar;

file
    :   (   functionDefinition
        |   classDefinition
        |   declarationStatement
        )*  EOF
    ;

functionDefinition
    :   typeName ('[' ']')* functionDeclarator compoundStatement
    ;

functionDeclarator
    :   Identifier '(' declarationList? ')'
    ;

classDefinition
    :   'class' Identifier '{' classStatement '}'
    ;

classStatement
    :   classBlockItem* 
    ;

classBlockItem
    :   functionDefinition
    |   constructFunctionDefine
    |   declarationStatement
    ;

constructFunctionDefine
    :   functionDeclarator compoundStatement
    ;

declarationList
    :   declaration (',' declaration)*
    ;

declarationStatement
    :   declaration ';'
    ;

declaration
    :   typeName ('[' ']')* initDeclarator
    ;

initDeclarator
    :   Identifier (('=' expression) | ( '(' declarationList? ')' ))?
    ;

// Expression build
primaryExpression
    :   Identifier                                                      # identifier
    |   Constant                                                        # constant
    |   '(' expression ')'                                              # subExperssion
    |   primaryExpression '[' expression ']'                            # arrayCall
    |   primaryExpression '(' argumentExpressionList? ')'               # functionCall
    |   primaryExpression '.' bracketIdentifier                         # memberCall
    ;

argumentExpressionList
    :   expression (',' expression)*
    ;

expression
    :   primaryExpression                                               # primaryExpr
    |   expression op = ('++' | '--')                                   # postfixIncDec
    |   <assoc = right> op = ('++' | '--') expression                   # prefixExpr
    |   <assoc = right> op = ('+' | '-' | '!' | '~') expression         # prefixExpr
    |   newExpression                                                   # new
    |   expression op = ('*' | '/' | '%') expression                    # binaryExpr
    |   expression op = ('+' | '-') expression                          # binaryExpr
    |   expression op = ('<<' | '>>') expression                        # binaryExpr
    |   expression op = ('<' | '>' | '<=' | '>=') expression            # binaryExpr
    |   expression op = ('==' | '!=') expression                        # binaryExpr
    |   expression op = '&' expression                                  # binaryExpr
    |   expression op = '^' expression                                  # binaryExpr
    |   expression op = '|' expression                                  # binaryExpr
    |   expression op = '&&' expression                                 # binaryExpr
    |   expression op = '||' expression                                 # binaryExpr
    |   <assoc=right> primaryExpression op = '=' expression             # assignExpr
    ;

newExpression
    :   New typeName ('[' expression ']')* ('[' ']')* ( '(' argumentExpressionList? ')' )?
    ;

// Expression build finished


statement
    :   compoundStatement
    |   expressionStatement
    |   selectionStatement
    |   iterationStatement
    |   jumpStatement
    |   declarationStatement
    ;

compoundStatement
    :   '{' (statement | declaration)* '}'
    ;

expressionStatement
    :   expression? ';'
    ;

selectionStatement
    :   If '(' expression ')' statement (Else statement)?
    ;

iterationStatement
    :   While '(' expression ')' statement
    |   For '(' forCondition ')' statement
    ;

forCondition
	:   expression? ';' expression? ';' expression?
	;

jumpStatement
    :   Continue ';'
    |   Break ';'
    |   Return expression? ';'
    ;

typeName
    :   Void 
    |   Int 
    |   Bool 
    |   String 
    |   Identifier
    ;


Break : 'break';
String : 'string';
Continue : 'continue';
Else : 'else';
For : 'for';
If : 'if';
Int : 'int';
Bool : 'bool';
Return : 'return';
Void : 'void';
While : 'while';
New : 'new';


LeftParen : '(';
RightParen : ')';
LeftBracket : '[';
RightBracket : ']';
LeftBrace : '{';
RightBrace : '}';

Less : '<';
LessEqual : '<=';
Greater : '>';
GreaterEqual : '>=';
LeftShift : '<<';
RightShift : '>>';

Plus : '+';
PlusPlus : '++';
Minus : '-';
MinusMinus : '--';
Star : '*';
Div : '/';
Mod : '%';

And : '&';
Or : '|';
AndAnd : '&&';
OrOr : '||';
Caret : '^';
Not : '!';
Tilde : '~';

Question : '?';
Colon : ':';
Semi : ';';
Comma : ',';

Assign : '=';

Equal : '==';
NotEqual : '!=';

Dot : '.';

bracketIdentifier
    :   Identifier
    |   '(' bracketIdentifier ')'
    ;
Identifier
    :   Nondigit
        (   Nondigit
        |   Digit
        |   '_'
        )*
    ;

fragment Nondigit
    :   [a-zA-Z]
    ;

fragment Digit
    :   [0-9]
    ;

Constant
    :   'true'
    |   'false'
    |   'null'
    |   IntegerConstant
    |   CharacterConstant
    ;

fragment IntegerConstant
    :   DecimalConstant 
    |   '0'
    ;

fragment DecimalConstant
    :   NonzeroDigit Digit*
    ;

fragment NonzeroDigit
    :   [1-9]
    ;

DigitSequence
    :   Digit+
    ;

fragment CharacterConstant
    :   '"' CCharSequence? '"'
    ;

fragment CCharSequence
    :   CChar+
    ;

fragment CChar
    :   ~[\\\r\n]
    |   EscapeSequence
    ;

fragment EscapeSequence
    :   '\\' ["nrt\\]
    ;	                     

Whitespace
    :   [ \t]+ -> skip
    ;

Newline
    :   (   '\r' '\n'?
        |   '\n'
        ) -> skip
    ;

BlockComment
    :   '/*' .*? '*/' -> skip
    ;

LineComment
    :   '//' ~[\r\n]* -> skip
    ;