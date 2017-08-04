package org.java.jls.Grammars;

public class Grammars {
    
    
    /**
     * 
     * 此处定义了 java 的语法 编译原理相关
     * 
     * 
     * 
     * Context-Free Grammars --上下文无关语法 
     * 
     * 产生式 ： 非终端标识符=  非终端标识符|终结标识符
     * production：nonterminal=nonterminal|terminal 
     * 
     * 终结标识符 指定的字母表描绘
     * terminal symbols are drawn from a specified alphabet
     * 
     * 
     * 
     * The Lexical Grammar  -- 词法
     * 
     *  终结标识符 是Unicode的字符集，产生式的集合开始于目标符号输入
     *   sequences of Unicode characters -- translated-- sequence of input elements
     *   input elements：丢弃空格和注释,形成Java编程语法的终端符号语言被称为令牌 tokens
     *   tokens：identifiers ,keywords,literals,separators,operators
     * 
     * 
     * Syntactic Grammar --句法
     * This grammar has tokens defined by the lexical grammar as its terminal symbols
     * 
     * sequences of tokens can form syntactically correct programs.
     * 
     * 
     * Grammar Notation--语法符号
     *   Nonterminal:使用斜体加冒号 
     *    {x}：  zero or more
     *    [x]: zero or one

     *   
     *   
     * 
     * 
     * 
     */

}
