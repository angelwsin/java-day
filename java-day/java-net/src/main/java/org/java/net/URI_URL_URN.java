package org.java.net;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.URL;
import java.net.URLConnection;
import java.util.Objects;

import org.java.net.classpath.ClasspathURLStreamHandlerFactory;

public class URI_URL_URN {
	
	
	public static void main(String[] args)throws Exception {
		//http://www.ietf.org/rfc/rfc2396.txt
		
				// java 资源解析
				//URI   URL  URN  
				/*
				URI可以进一步分类为定位符，名称或两者。 该
				    术语“统一资源定位符”（URL）是指URI的子集
				    通过其主要访问的表示来识别资源
				    机制（例如，他们的网络“位置”），而不是识别
				    资源按名称或资源的其他属性。
				    术语“统一资源名称”（URN）是指URI的子集
				    即使在这种情况下，也需要保持全球独一无二和持久的
				    资源不复存在或变得不可用。*/
				
				
				//URL  [scheme:]scheme-specific-part[#fragment]
		        // [] 可选部分  
		        //URL 可以根据绝对和相对分类，也可以分为不透明和分级
		       //1)不透明URI是绝对URI，scheme-specific-part的部分不以斜杠字符（'/'）开始。不透明的URI不需要进一步解析
		/*
		 * mailto:java-net@java.sun.com 
		 * news:comp.lang.java 
		 * urn:isbn:096139210x
		 */
		
		 //层次结构URI是绝对URI，其scheme-specific-part的部分以斜杠字符开始，或者是相对URI，即不指定scheme的URI
		
		//[scheme:][//authority][path][?query][#fragment]
		
		//The authority component of a hierarchical URI is
		//[user-info@]host[:port]
		
		//Escaped octets, quotation, encoding, and decoding  转义，编码，解码
		
		URI uri = new URI("file:///~/calendar");
		System.out.println(uri.getScheme());
		
		//Class URL represents a Uniform Resource Locator, a pointer to a "resource" on the World Wide Web
		//指向万维网上的“资源”
		//
		URL url = new URL("https://docs.oracle.com/javase/1.3/docs/guide/collections/designfaq.html#28");
		
		//java.net.URL.getURLStreamHandler(String)  根据协议查找协议处理的Handler
		//1)从缓存中那不到，到第二步
		//2)URLStreamHandlerFactory 不为空 从Factory中创建
		//3)从系统环境变量中取 -Djava.protocol.handler.pkgs （以|分割) (继承URLStreamHandler）
		//4)从 sun.net.www.protocol.(协议).Handler类
		   //jdk 实现的协议有：http,https,ftp,file,jar
		System.setProperty("java.protocol.handler.pkgs", "org.java.net");
		//URL.setURLStreamHandlerFactory(new ClasspathURLStreamHandlerFactory()); 工厂方式
		URL classpath = new URL("classpath:config.properties");
		URLConnection conn = classpath.openConnection();
		try(InputStream is = conn.getInputStream();
			BufferedReader read = new BufferedReader(new InputStreamReader(is));){
			
			String line =null;
			while(!Objects.isNull(line=read.readLine())){
				System.out.println(line);
			}
			
		} catch (Exception e) {
			
		}
		
		
	}

}
