package com.httpclient;

import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

public class HttpClientTest {
	
	public static void main(String[] args) {
		
		//使用过滤链式编程完成 aop  ClientExecChain
		//在链式执行中使用拦截器 HttpProcessor 进行拦截
		try(CloseableHttpClient client = HttpClients.createDefault();) {
			HttpGet get = new HttpGet();
			client.execute(get);
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
		
		
	}

}
