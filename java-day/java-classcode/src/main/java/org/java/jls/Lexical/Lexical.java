package org.java.jls.Lexical;

public class Lexical {
    
    
    /**
     * 
     * The Unicode characters resulting from the lexical translations are reduced to a sequence of input elements , which are white space , comments , and
     * tokens. The tokens are the identifiers , keywords, literals , separators , and operators of the syntactic grammar.
     * 
     * 词法
     * 
     * Programs are written using the Unicode character set. 程序使用 Unicode编码
     * 
     * 一.Unicode
     * 
     * Lexical Translations A raw Unicode character stream is translated into a sequence of tokens，翻译三步走 1.Unicode字符的原始流中的Unicode转义的翻译到相应的Unicode字符
     * 2.将由步骤1产生的Unicode流的翻译成输入流字符和行终止符 3.步骤2产生的Unicode流当丢弃空格和注释,构成的tokens成为一系列输入元素
     * 
     * 二. Unicode Escapes
     * 
     * 
     * 
     * 三.Line Terminators 行终结符 Lines are terminated by the ASCII characters CR, or LF, or CR LF windows采用回车+换行CR/LF表示下一行 UNIX/Linux采用换行符LF表示下一行 MAC
     * OS则采用回车符CR表示下一行
     * 
     * 四.Input Elements and Tokens
     *
     * InputElement: WhiteSpace Comment Token
     * 
     * 
     * Token: Identifier Keyword Literal Separator Operator
     * 
     * 五.White Space
     * 
     * 
     * 六.Comments 注释 \/* text *\/ // text
     * 
     * 七.Identifiers
     * 
     * Identifier:
     *     IdentifierChars but not a Keyword or BooleanLiteral(true,false) or NullLiteral
     * 
     * An identifier is an unlimited-length sequence of Java letters and Java digits, the first of which must be a Java letter. Java letters :A-Z, a-z,_,$ "Java
     * digits :0-9
     * 
     * 八.Keywords
     *
     *
     * abstract continue for new switch assert default if package synchronized boolean 
     * do goto private this break double implements protected throw
     * byte else import public throws case enum instanceof return transient 
     * catch extends int short try char final interface static void class finally long
     * strictfp volatile const float native super while
     * 
     * 虽然true和false可能似乎是关键字，但它们在技术上是布尔文字。 类似地，尽管null可能看起来是一个关键字，但它在技术上是null文字
     * 
     * 九.Literals  字面量; 常量; 字面值; 直接量; 文字;
     * 
     *  A literal is the source code representation of a value of a primitive type , the
     *   String type , or the null type 
     *   
     *   Literal:
     *     IntegerLiteral
     *     FloatingPointLiteral
     *     BooleanLiteral
     *     CharacterLiteral
     *     StringLiteral
     *     NullLiteral
     *  
     * 十.Separators
     *  ( ) { } [ ] ; , . ... @ ::
     *  
     * 十一.Operators
     * 
     * = > < ! ~ ? : ->(java8)
     *  == >= <= != && || ++ --
     *  + - * / & | ^ % << >> >>>
     *  += -= *= /= &= |= ^= %= <<= >>= >>>=
     * 
     */
    
    
    
    

}
