package org.java.rmi.server;

import java.rmi.Naming;
import java.rmi.Remote;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;

import org.java.rmi.remote.impl.EchoImpl;

public class RMINamingServer {
    
    //Naming  rul方式
    
    public static void main(String[] args)throws Exception {
        
        //Naming 封装了 注册中心   URI
        //rmi
        LocateRegistry.createRegistry(1099);
        Remote stub =   UnicastRemoteObject.exportObject(new EchoImpl(), 5434);
        Naming.bind("rmi://localhost:1099/Hello", stub);
        
       
    }

}
