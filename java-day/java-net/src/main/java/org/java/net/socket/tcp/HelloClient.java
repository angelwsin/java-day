package org.java.net.socket.tcp;

import java.net.Socket;

public class HelloClient {
	
	public static void main(String[] args) throws Exception{
		
		try(Socket client = new Socket("localhost", 5089);) {
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
		/*
		 * 1)调用 socket()建立套接字。
		 * 2)connect()
		connect()系统调用为一个套接字设置连接，参数有文件描述符和主机地址。
		某些类型的套接字是无连接的，大多数是UDP协议。对于这些套接字，连接时这样的：默认发送和接收数据的主机由给定的地址确定，可以使用 send()和 recv()。 返回-1表示出错，0表示成功。
		函数原型：
		int connect(int sockfd, const struct sockaddr *serv_addr, socklen_t addrlen);
		*/
	}

}
