package org.java.net.address;

import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;

public class Address {

	//java.net 对网络地址的支持
	
	public static void main(String[] args) throws Exception{
		
		InetAddress local = InetAddress.getLocalHost();
		System.out.println(local.getHostName());
		System.out.println(local.getHostAddress());
		//本地环回接口
		System.out.println(local.getLoopbackAddress());
		
		//ipv4
		InetAddress localv4 = Inet4Address.getLocalHost();
		System.out.println(localv4.getHostAddress());
		
		//ipv6
		InetAddress localv6 = Inet6Address.getLocalHost();
		System.out.println(localv6.getHostAddress());
	}
	
	
}
