package org.java.net.socket.udp;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;

public class HelloUDPClient {
	
	
	public static void main(String[] args)throws Exception {
		InetSocketAddress bindaddr = new InetSocketAddress("localhost", 1098);
		DatagramSocket client = new DatagramSocket();
		client.connect(bindaddr);
		byte[] str = "hello".getBytes();
		DatagramPacket hello = new DatagramPacket(str, str.length);
		client.send(hello);
		
	}

}
