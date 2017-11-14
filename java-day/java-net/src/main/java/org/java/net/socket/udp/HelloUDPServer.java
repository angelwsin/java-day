package org.java.net.socket.udp;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

//UDP穿透容易
public class HelloUDPServer {
	
	
	public static void main(String[] args) throws Exception{
		DatagramSocket  udpServer = new DatagramSocket(1098);
		udpServer.setReceiveBufferSize(10);
		byte[] buf = new byte[1024];
		DatagramPacket rev = new DatagramPacket(buf, buf.length);
		udpServer.receive(rev);
		System.out.println(new String(buf));
		
	}
	/*
	 * TCP,UDP 区别
	 * tcp.面向连接，有序，流模式  (流模式，可以指定位置读)，开销大
	 * udp.无连接，无序，数据报模式（不可分割的数据包），开销小
	 */

}
