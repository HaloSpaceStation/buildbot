grammar ChangeLog;

// Parser Rules

changelog   : .*? BEGINCL whitespace author NEWLINE entries ENDCL whitespace .*?;

author
    : (TEXT | DIGITS | PUNCTUATION)+;
entries : entry NEWLINE entry_tail;
entry   : TAG whitespace ':' whitespace (TEXT | DIGITS | PUNCTUATION | WHITESPACE)+;
entry_tail
    : entries
    |/* nothing */;
whitespace
    : WHITESPACE
    | ;


// Lexer Rules

NEWLINE : '\r\n' | '\n' | '\r';

BEGINCL : ':cl:' | '\uD83C\uDD91' | '\u1F191';
ENDCL   : '/'BEGINCL ;
DIGITS   : [0-9]+;
PUNCTUATION : [.,-];

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

TEXT    : [a-zA-Z]+;

WHITESPACE : ' ';