package org.java.api.math;

import java.math.BigDecimal;
import java.math.BigInteger;

public class BigDecimalx {
	
	
	
	public static void main(String[] args) {
		
		//BigDecimal  保证准确性
		/*不变的，任意精确的带符号的十进制数字。  BigDecimal由任意精度整数未缩放值和32位整数值组成。
		如果为零或正数，则刻度是小数点右侧的位数。 如果是负数，则数字的非标尺值乘以10，而不是比例的否定的幂。 因此，由BigDecimal表示的数字值（非标度值×10级）。
		
		*BigDecimal类提供了算术，缩放操作，舍入，比较，散列和格式转换的操作。  toString（）方法提供了BigDecimal的规范表示
		*/
		
		BigDecimal big = new BigDecimal("2");
		
		
		/*不变的任意精度整数。 所有操作的行为就好像BigIntegers以二进制补码表示（如Java的原始整数类型）表示。 
        BigInteger提供了所有Java的原始整数运算符以及java.lang.Math中的所有相关方法的类比。 此外，BigInteger还提供了模块运算，GCD计算，原始测试，主要生成，位操作以及其他一些其他操作的操作。
                        算术运算的语义完全模仿Java的整数运算符，如Java语言规范中定义的那样。 例如，除以零，抛出一个ArithmeticException，并将负数除以正数，得到一个负数（或零）余数。 关于溢出的Spec中的所有细节都被忽略，因为BigInteger被做得足够大以适应操作的结果。
        */
		BigInteger in  = new BigInteger("4");
		
		
		
		
	}

}
