package org.java.api.character;

public class Characterx {

	
	public static void main(String[] args) {
		
		//http://www.unicode.org/
		//Unicode标准的版本由核心规范版本的Unicode标准以及代码图表，Unicode标准附件和Unicode字符数据库定义
		//java 规范中指出是 Unicode specification
		
		Character c  = 'c';
		//radix  是指进制    下面 a在16进制下标示的数字
		
		// If the radix is not in the range MIN_RADIX(2) ≤ radix ≤ MAX_RADIX(36) or 
		//if the value of ch is not a valid digit in the specified radix, -1 is returned
		
		/*The character is one of the uppercase Latin letters 'A' through 'Z' and its code is less than radix + 'A' - 10. In this case, ch - 'A' + 10 is returned.
		The character is one of the lowercase Latin letters 'a' through 'z' and its code is less than radix + 'a' - 10. In this case, ch - 'a' + 10 is returned.
		The character is one of the fullwidth uppercase Latin letters A ('\uFF21') through Z ('\uFF3A') and its code is less than radix + '\uFF21' - 10. In this case, ch - '\uFF21' + 10 is returned.
		The character is one of the fullwidth lowercase Latin letters a ('\uFF41') through z ('\uFF5A') and its code is less than radix + '\uFF41' - 10. In this case, ch - '\uFF41' + 10 is returned
		*/
		System.out.println(Character.digit('a', 16));
		
	   //一切从字符说起
		//java Unicode字符  Character 用来标示
		
	}
}
