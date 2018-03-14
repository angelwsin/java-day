package org.java.net.socket.address;

import java.net.InetAddress;
import java.net.InetSocketAddress;

public class SocketAdr {
	
	
	public static void main(String[] args)throws Exception {
		InetSocketAddress socketAdr  = new InetSocketAddress(InetAddress.getLocalHost(), 4000);
		System.out.println(socketAdr.getPort());
	}

}
