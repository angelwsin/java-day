package org.java.net.socket.udp;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class HelloUDPServer {
	
	
	public static void main(String[] args) throws Exception{
		DatagramSocket  udpServer = new DatagramSocket(1098);
		udpServer.setSendBufferSize(1024);
		byte[] buf = new byte[1024];
		DatagramPacket rev = new DatagramPacket(buf, buf.length);
		udpServer.receive(rev);
		System.out.println(new String(buf));
		
	}

}
