# YASPL-3

It is a programming language created for Compiler course from University of Salerno (Italy).
In this project we started from Yaspl and developed intermediate code in C.

## Lexical Specification

|Token | Lexeme|
|----- |-----|
|HEAD|head|
|START|start|
|SEMI|;|
|INT|int|
|BOOL|bool|
|DOUBLE|double|
|STRING|string|
|CHAR|char|
|ID|jletter(jletter \| jdigit)*|
|COMMA|,|
|DEF|def|
|LPAR|(|
|RPAR|)|
|LGPAR|{|
|RGPAR|}|
|READ|<-|
|WRITE|->|
|PLUS|+|
|MINUS|-|
|TIMES|*|
|DIV|/|
|MOD|%|
|INT_CONST|0 \| [1-9][0-9]*|
|DOUBLE_CONST| (0 \| [1-9][0-9]*)\.[0-9]+ |
|STRING_CONST| [^\r\n\"\\] |
|CHAR_CONST| '({any})?'|
|TRUE| true|
|FALSE| false|
|ASSIGN | =|
|IF| if|
|THEN| then|
|WHILE| while|
|DO| do|
|ELSE| else|
|GT| >|
|GE|>=|
|LT|<|
|LE|<=|
|EQ|==|
|NOT| not|
|AND| and|
|OR| or|
|UMINUS|-|
|IN| in|
|OUT| out|
|INOUT| intout|

## Grammar
```jflex
Programma: HEAD Decls START Statements

Decls : Var_decl Decls 
| Def_decl Decls
| ε

Statements : Stat Statements
| ε

Var_decl : Type Var_decls_init SEMI 

Type : INT | BOOL | DOUBLE | STRING | CHAR 

Var_decls_init : ID Var_init_value COMMA Var_decls_init 
 | ID Var_init_value

Var_init_value : ASSIGN Expr
 | ε

Vars : ID COMMA Vars
 | ID

Def_decl : DEF ID LPAR Par_decls RPAR Body
  |DEF ID LPAR RPAR Body

Var_decls : Var_decl Var_decls
 | ε
 
Par_decls : Par_type Type ID COMMA Par_decls
| Par_type Type ID

Par_type : IN | OUT | INOUT 

Body : LGPAR Var_decls Statements RGPAR 

Stat : Vars READ SEMI
 | Args WRITE SEMI
 | ID ASSIGN Expr SEMI
 | ID LPAR Args RPAR SEMI 
 | ID LPAR RPAR SEMI 
 | IF LPAR Expr RPAR THEN Comp_stat ELSE Comp_stat 
 | IF LPAR Expr RPAR THEN Comp_stat 
 | WHILE LPAR Expr RPAR DO Comp_stat 

Args : Expr COMMA Args 
| Expr

Comp_stat : LGPAR Statements RGPAR 

Expr : Expr PLUS Expr
 | Expr TIMES Expr
 | Expr MINUS Expr
 | Expr DIV Expr
 | Expr AND Expr
 | Expr OR Expr
 | Expr LE Expr
 | Expr LT Expr
 | Expr GE Expr
 | Expr GT Expr
 | Expr EQ Expr
 | MINUS Expr
 | NOT Expr
 | LPAR Expr RPAR
 | TRUE
 | FALSE
 | ID
 | INT_CONST
 | DOUBLE_CONST
 | CHAR_CONST
 | STRING_CONST
```
## Technologies
1. Java
2. JFlex
3. Java Cup

## How to install
