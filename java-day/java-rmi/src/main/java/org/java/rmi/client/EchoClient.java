package org.java.rmi.client;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import org.java.rmi.remote.Echo;

public class EchoClient {
	
	public static void main(String[] args) throws Exception{
		
		Registry registry = LocateRegistry.getRegistry("localhost");
        Echo stub = (Echo) registry.lookup("Hello");
         stub.sayHello();
	}

}
