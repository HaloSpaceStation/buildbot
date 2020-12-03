grammar ChangeLog;

// Parser Rules

changelog   : anything BEGINCL whitespace author? NEWLINE entries ENDCL anything;

author
    : STRING;
entries : entry NEWLINE entry_tail;
entry   : TAG whitespace COLON whitespace (STRING | WHITESPACE | COLON)+;
entry_tail
    : entries
    |/* nothing */;
whitespace
    : WHITESPACE
    | ;
anything : (STRING | WHITESPACE | NEWLINE | ERRORTOKEN)* ;


// Lexer Rules

NEWLINE : '\r\n' | '\n' | '\r';

BEGINCL : ':cl:' | '\uD83C\uDD91' | '\u1F191';
ENDCL   : '/'BEGINCL ;
fragment DIGITS   : [0-9]+;
fragment PUNCTUATION : [.,-];
COLON : ':';

TAG
    : 'bugfix'
    | 'wip'
    | 'tweak'
    | 'soundadd'
    | 'sounddel'
    | 'rscadd'
    | 'rscdel'
    | 'imageadd'
    | 'imagedel'
    | 'maptweak'
    | 'spellcheck'
    | 'experiment' ;

fragment TEXT    : [a-zA-Z]+ ;

STRING: (TEXT | DIGITS | PUNCTUATION)+ ;

WHITESPACE : ' ';

ERRORTOKEN: . ;