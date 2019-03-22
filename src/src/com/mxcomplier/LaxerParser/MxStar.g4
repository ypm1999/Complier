
grammar MxStar;

program
    :   (   functionDefinition
        |   classDefinition
        |   declarationStatement
        )*  EOF
    ;

functionDefinition
    :   (typeOrVoid)? Identifier '(' declarationList? ')' compoundStatement
    ;

classDefinition
    :   'class' Identifier '{' classStatement '}'
    ;

classStatement
    :   (functionDefinition | declarationStatement)*
    ;

declarationList
    :   declaration (',' declaration)*
    ;

declarationStatement
    :   declaration ';'
    ;

declaration
    :   type Identifier ('=' expression)?
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
    |   expression op = ('++' | '--')                                   # suffixIncDec
    |   <assoc = right> op = ('++' | '--') expression                   # prefixExpr
    |   <assoc = right> op = ('+' | '-' | '!' | '~') expression         # prefixExpr
    |   newExpression                                                   # newExpr
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
    :   New baseType ('[' expression ']')+ ('[' ']')*
    |   New baseType ( '('  ')' )?
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
    :   '{' compoundStatementItem* '}'
    ;

compoundStatementItem
    :   statement
    |   declarationStatement
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

baseType
    :   Int
    |   Bool 
    |   String 
    |   Identifier
    ;

type
    :   baseType
    |   type '[' ']'
    ;

typeOrVoid
    :   Void
    |   type
    ;

Bool                : 'bool';
Int                 : 'int';
String              : 'string';
Null                : 'null';
Void                : 'void';
True                : 'true';
False               : 'false';
If                  : 'if';
Else                : 'else';
For                 : 'for';
While               : 'while';
Break               : 'break';
Continue            : 'continue';
Return              : 'return';
New                 : 'new';
Class               : 'class';
This                : 'this';


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
    :   True
    |   False
    |   Null
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