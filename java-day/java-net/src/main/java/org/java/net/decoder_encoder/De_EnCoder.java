package org.java.net.decoder_encoder;

import java.net.URLDecoder;
import java.net.URLEncoder;

public class De_EnCoder {
	
	
	//java.net 对编码，解码的支持
	//乱码解决
	public static void main(String[] args)throws Exception {
		
		String encode = URLEncoder.encode("你好世界", "utf-8");
		System.out.println(encode);
		String decode = URLDecoder.decode(encode, "utf-8");
		System.out.println(decode);
	}

}
