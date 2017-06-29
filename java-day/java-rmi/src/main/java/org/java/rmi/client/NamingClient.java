package org.java.rmi.client;

import java.rmi.Naming;

import org.java.rmi.remote.Echo;

public class NamingClient {
    
    
    public static void main(String[] args)throws Exception {
        
        
        Echo stub  =  (Echo) Naming.lookup("rmi://localhost:1099/Hello");
        stub.sayHello();
    }

}
