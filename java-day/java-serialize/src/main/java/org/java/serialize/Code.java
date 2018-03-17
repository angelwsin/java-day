package org.java.serialize;

import java.util.concurrent.FutureTask;

import sun.misc.Unsafe;

//编码
/**
 * https://www.cnblogs.com/kingstarspe/p/ASCII.html
 * java使用的字符编码unicode
 * @author wu.qiang
 * 
 * 编码	         大小	      支持语言
 *ASCII	   1个字节	英文
 *Unicode2个字节（生僻字4个）	所有语言
 *UTF-8	   1-6个字节，英文字母1个字节，汉字3个字节，生僻字4-6个字节	所有语言
 *UTF-8是Unicode的实现方式之一
 *
 */

/*
 * UTF-8最大的一个特点，就是它是一种变长的编码方式。它可以使用1~4个字节表示一个符号，根据不同的符号而变化字节长度。
 * 
 * UTF-8的编码规则很简单，只有二条：
 * 
 * 1）对于单字节的符号，字节的第一位设为0，后面7位为这个符号的unicode码。因此对于英语字母，UTF-8编码和ASCII码是相同的。
 * 
 * 2）对于n字节的符号（n>1），第一个字节的前n位都设为1，第n+1位设为0，后面字节的前两位一律设为10。剩下的没有提及的二进制位，
 * 全部为这个符号的unicode码。
 */
public class Code {

	
	public static void main(String[] args) throws Exception{
		System.out.println((char)00);
		System.out.println(Integer.toHexString('a'));//十六进制
		System.out.println('\u0061');//unicode
		String uft_8 = new String("a".getBytes(),"utf-8");
		System.out.println(Integer.toHexString(uft_8.toCharArray()[0]));
		
		Obj obj = new Obj();
		Unsafe unsafe = Unsafe.getUnsafe();
		unsafe.getBoolean(obj, Obj.stateOffset);
		
	}
	
	
	static class Obj {
		
		// Unsafe mechanics
	    private static final sun.misc.Unsafe UNSAFE;
	    public static final long stateOffset;
	    static {
	        try {
	            UNSAFE = sun.misc.Unsafe.getUnsafe();
	            Class<?> k = Obj.class;
	            stateOffset = UNSAFE.objectFieldOffset
	                (k.getDeclaredField("is"));
	            
	        } catch (Exception e) {
	            throw new Error(e);
	        }
	    }
		boolean is;
		
		
	}
}

