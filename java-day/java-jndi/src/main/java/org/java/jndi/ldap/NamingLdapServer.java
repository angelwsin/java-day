package org.java.jndi.ldap;

import javax.naming.InitialContext;

import org.java.jndi.service.UserServiceImpl;

public class NamingLdapServer {
    
    public static void main(String[] args)throws Exception {
        
       
       // ldap://ldap.wiz.com/o=wiz,c=us
        
        InitialContext  context = new InitialContext();
        
        context.bind("ldap://localhost:9033/o=wiz", new UserServiceImpl());
        
    }

}
