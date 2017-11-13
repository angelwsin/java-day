package org.java.net;

import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.Proxy.Type;
import java.net.URL;

import sun.net.www.MessageHeader;

//http connect 请求头  代理
//http://blog.csdn.net/kobejayandy/article/details/24606521
public class URLX {
	
	
	public static void main(String[] args) throws Exception{
		URL url = new URL("https://baidu.com");
		//1)代理
		InetSocketAddress sa = new InetSocketAddress("hostname", 8080); 
		Proxy proxy = new Proxy(Type.HTTP, sa);
		url.openConnection(proxy);
		//2)不使用代理
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		//
		conn.connect();
		//conn.getOutputStream().write(b);
		conn.getContent();
		//http 涉及到认证,cookie
		
		//http 协议编码,解码
		
		MessageHeader requests = new MessageHeader();
		String method = "GET";
		String httpVersion= "1.1";
		requests.prepend(method + " " + "/"+" "  + httpVersion, null);
		requests.set("Host", "");
		
		
		
	}

}
