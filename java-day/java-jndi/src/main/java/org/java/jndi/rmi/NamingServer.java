package org.java.jndi.rmi;

import java.rmi.Remote;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;

import javax.naming.InitialContext;

import org.java.jndi.service.UserServiceImpl;

public class NamingServer {
    
    public static void main(String[] args)throws Exception {
        
        
        
         LocateRegistry.createRegistry(9090);
        
        //ObjectFactory  context 实例化工厂
        //如果没有指定 默认com.sun.jndi.url
        //自定义 jndi.properties
        InitialContext initContext = new InitialContext();
        
        
        Remote stub =   UnicastRemoteObject.exportObject(new UserServiceImpl(), 5434);
       initContext.bind("rmi://localhost:9090/userSerice", stub);
         
    }

}
