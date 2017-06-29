package org.java.rmi.server;

import java.rmi.Remote;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.RMISocketFactory;
import java.rmi.server.UnicastRemoteObject;

import org.java.rmi.remote.impl.EchoImpl;

public class RMISocketServer {
	
	
    //MarshalledObject  序列化工具
	public static void main(String[] args) throws Exception{
		
	    RMISocketFactory factory = new RMISocketServerFactory();
	   
		 Remote subt = UnicastRemoteObject.exportObject(new EchoImpl(), 1243, factory,factory);
		 
		Registry registry =  LocateRegistry.createRegistry(1099);
		
		registry.bind("Hello", subt);
	}
	
	
	

}
