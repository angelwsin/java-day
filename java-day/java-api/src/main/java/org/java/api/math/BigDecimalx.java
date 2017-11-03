package org.java.api.math;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;

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
		//BigDecimal类为其用户提供了对舍入行为的完全控制。 如果没有指定四舍五入模式，并且不能确定结果，则抛出异常; 否则，可以通过向操作提供适当的MathContext对象来执行计算，以达到选定的精度和舍入模式。
		//精度和舍入模式
		
		/*一般来说，舍入模式和精度设置决定了当精确的结果有更多数字（在除法的情况下可能无限多）比返回的位数还多的情况下，操作返回结果的位数是有限的。 首先
		 * ，返回的数字总数由MathContext的精度设置指定; 这决定了结果的精确度。 数字计数从精确结果的最左边的非零数字开始。 舍入模式决定了丢弃的数字如何影响返回的结果。

		对于所有的算术运算符，首先计算精确的中间结果，然后使用选定的舍入模式将其舍入到由精度设置（如有必要）指定的位数。 如果没有返回确切的结果，则丢弃精确结果的一些数字位置。
		Operation	Preferred Scale of Result
            Add	        max(addend.scale(), augend.scale())
            Subtract	max(minuend.scale(), subtrahend.scale())
            Multiply	multiplier.scale() + multiplicand.scale()
            Divide	   dividend.scale() - divisor.scale()
		 *
		 *
		 *
		 *unscaledValue × 10^(-scale)
		 *
		 *精度 和舍入模式（rounding）
		 */
		BigInteger in  = new BigInteger("4");
		//BigDecimal类为其用户提供了对舍入行为的完全控制。 如果没有指定四舍五入模式，并且不能确定结果，则抛出异常;
		new BigDecimal("1").divide(new BigDecimal("3"));
		
		//指定精确度和舍入模式
		new BigDecimal("1").divide(new BigDecimal("3"),2,RoundingMode.HALF_UP);
		// 伪代码表达式（i j）是“一个BigDecimal的简写，它的值是BigDecimal的值
		//[{@code BigInteger}, {@code scale}]
		/*19/100 = 0.19 // integer=19, scale=2 
		but
		21/110 = 0.190 // integer=190, scale=3 
*/		
		
		
		
	}

}
