package org.java.rmi.server;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

import org.java.rmi.remote.Echo;
import org.java.rmi.remote.impl.EchoImpl;

public class RMIServer {
	
	
	public static void main(String[] args)throws Exception {
		
		Echo stub = (Echo) UnicastRemoteObject.exportObject(new EchoImpl(), 8798);
		// Bind the remote object's stub in the registry
		// port of 1099
		//RMIService  a bootstrap remote object registry on a particular host 
        Registry registry = LocateRegistry.createRegistry(1099);
        registry.bind("Hello", stub);

        System.err.println("Server ready");
		
	}

}
