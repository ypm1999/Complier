
grammar MxStar;

program
    :   (   functionDefinition
        |   classDefinition
        |   declarationStatement
        )*  EOF
    ;

functionDefinition
    :   (typeOrVoid)? identifier '(' declarationList? ')' compoundStatement
    ;

classDefinition
    :   Class identifier '{' classStatement '}'
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
    :   type identifier ('=' expression)?
    ;


// Expression build
primaryExpression
    :   This                                                            # thisExpr
    |   identifier                                                      # identifierExpr
    |   constant                                                        # constantExpr
    |   '(' expression ')'                                              # subExpr
    |   primaryExpression '[' expression ']'                            # arrayCallExpr
    |   primaryExpression '(' argumentExpressionList? ')'               # functionCallExpr
    |   primaryExpression '.' bracketIdentifier                         # memberCallExpr
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
    |   exp1=expression op = ('*' | '/' | '%') exp2=expression          # binaryExpr
    |   exp1=expression op = ('+' | '-') exp2=expression                # binaryExpr
    |   exp1=expression op = ('<<' | '>>') exp2=expression              # binaryExpr
    |   exp1=expression op = ('<' | '>' | '<=' | '>=') exp2=expression  # binaryExpr
    |   exp1=expression op = ('==' | '!=') exp2=expression              # binaryExpr
    |   exp1=expression op = '&' exp2=expression                        # binaryExpr
    |   exp1=expression op = '^' exp2=expression                        # binaryExpr
    |   exp1=expression op = '|' exp2=expression                        # binaryExpr
    |   exp1=expression op = '&&' exp2=expression                       # binaryExpr
    |   exp1=expression op = '||' exp2=expression                       # binaryExpr
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
    :   If '(' expression ')' thenStmt = statement (Else elseStmt = statement)?
    ;

iterationStatement
    :   While '(' expression ')' statement                  #whileStatement
    |   For '(' forCondition ')' statement                  #forStatement
    ;

forCondition
	:   exp1 = expression? ';' exp2 = expression? ';' exp3 = expression?
	;

jumpStatement
    :   Continue ';'                        #continueStmt
    |   Break ';'                           #breakStmt
    |   Return expression? ';'              #reutrnStmt
    ;

baseType
    :   Int
    |   Bool 
    |   String 
    |   identifier
    ;

type
    :   baseType
    |   type '[' ']'
    ;

typeOrVoid
    :   Void
    |   type
    ;


bracketIdentifier
    :   identifier
    |   '(' bracketIdentifier ')'
    ;

identifier
    :   Nondigit
        (   Nondigit
        |   Digit
        |   '_'
        )*
    ;


constant
    :   True                        #boolConst
    |   False                       #boolConst
    |   Null                        #nullConst
    |   IntegerConstant             #intConst
    |   CharacterConstant           #stringConst
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


IntegerConstant
    :   NonzeroDigit Digit*
    |   '0'
    ;

fragment Nondigit
    :   [a-zA-Z]
    ;

fragment Digit
    :   [0-9]
    ;

fragment NonzeroDigit
    :   [1-9]
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