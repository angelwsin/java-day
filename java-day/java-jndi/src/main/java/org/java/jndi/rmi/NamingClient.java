package org.java.jndi.rmi;

import javax.naming.InitialContext;

import org.java.jndi.service.UserService;

public class NamingClient {
    
    
    public static void main(String[] args) throws Exception{
        InitialContext context = new InitialContext();
        
        UserService userService  = (UserService) context.lookup("rmi://localhost:9090/userSerice");
        
        userService.getUser();
        
    }

}
