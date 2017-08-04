package org.java.jvm.datatypes;


/**
 * IEEE 754
 * http://blog.csdn.net/richerg85/article/details/20456969
 * http://blog.csdn.net/zcczcw/article/details/7362473
 * @author angel
 *
 */
public class PrimitiveTypes {
	
	
	/**
	 * jvm规范
	 * data types
	 * 1.Primitive Types 
	 *  numeric types, the boolean type , and the returnAddress type .
	 * 2.Reference Types 
	 *  class types, array types, and interface types
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		
		//1.Primitive Types
		
		//numeric types
		  //The integral types are
		   byte  b = 1; //一个字节 -128 to 127   默认值      0
		   short s = 2; //两个字节  -32768 to 32767    0
		   char  c  = 2;//两个字节  m 0 to 65535   \u0000
		   int   i = 4; //四个字节 -2147483648 to 2147483647      0
		   long  l =8 ;//八个字节 9223372036854775808 to 9223372036854775807      0
		   
		  //Floating-Point Types   IEEE 754 standard
		   
		   
		   
		   
		   System.out.println(0.05+0.01);
		   //0.060000000000000005
		   System.out.println(0.01);
		   //float和double只能用来做科学计算或者是工程计算，在商业计算中我们要用 java.math.BigDecimal
		   System.out.println(Float.toHexString(0.1f));
		
		   
		/**
		 * 解释 浮点数 不正确的原因 十进制小数如何转化为二进制数 算法是乘以2直到没有了小数为止。举个例子，0.9表示成二进制数
		 * 0.9*2=1.8 取整数部分 1 
		 * 0.8(1.8的小数部分)*2=1.6 取整数部分 1
		 *  0.6*2=1.2 取整数部分 1
		 * 0.2*2=0.4 取整数部分 0
		 *  0.4*2=0.8 取整数部分 0 
		 *  0.8*2=1.6 取整数部分 1 
		 *  0.6*2=1.2 取整数部分 0
		 *  ......... 0.9二进制表示为(从上往下): 1100100100100......
		 * 注意：上面的计算过程循环了，也就是说*2永远不可能消灭小数部分，这样算法将无限下去。很显然，小数的二进制表示有时是不可能精确的
		 * 。其实道理很简单，十进制系统中能不能准确表示出1/3呢？同样二进制系统也无法准确表示1/10。
		 * 这也就解释了为什么浮点型减法出现了"减不尽"的精度丢失问题。
		 */
		   
		   
		   //The returnAddress
		/**
		 * The returnAddress type is used by the Java Virtual Machine's jsr,
		 * ret, and jsr_w instructions (§jsr, §ret, §jsr_w). The values of the
		 * returnAddress type are pointers to the opcodes of Java Virtual
		 * Machine instructions. Unlike the numeric primitive types, the
		 * returnAddress type does not correspond to any Java programming
		 * language type and cannot be modified by the running program.
		 */
		   
		   // boolean Type
		   
		/**
		 * Although the Java Virtual Machine defines a boolean type, it only
		 * provides very limited support for it. There are no Java Virtual
		 * Machine instructions solely dedicated to operations on boolean
		 * values. Instead, expressions in the Java programming language that
		 * operate on boolean values are compiled to use values of the Java
		 * Virtual Machine int data type.
		 */
		   
	}

}
