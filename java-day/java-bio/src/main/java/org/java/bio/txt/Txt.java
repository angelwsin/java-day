package org.java.bio.txt;

import java.io.File;
import java.io.FileInputStream;

//http://blog.csdn.net/wangzhi291/article/details/41485403
//java读取UTF-8的txt文件发现开头的一个字符问题
//http://blog.csdn.net/clementad/article/details/47168573
public class Txt {
	
	
	public static void main(String[] args) throws Exception{
		FileInputStream is = new FileInputStream(new File("C:\\Users\\Administrator\\Desktop\\V02_CDK_INST_DETAILL_WD_20171115.txt"));
		//UnicodeReader
		byte[] by = new byte[1024];
		is.read(by);
		for(byte b :by){
			System.out.println(Integer.toHexString(b));
			
			
			
		}
	}

}
