package org.java.rmi.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.rmi.server.RMISocketFactory;

public class RMISocketServerFactory extends RMISocketFactory{

	//MRI client 端
	@Override
	public Socket createSocket(String host, int port) throws IOException {
		return RMISocketFactory.getDefaultSocketFactory()
				.createSocket(host, port);
	}

	//MRI server 端
	@Override
	public ServerSocket createServerSocket(int port) throws IOException {
		return new ServerSocket(8976);
	}

}
