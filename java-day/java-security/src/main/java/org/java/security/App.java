package org.java.security;

import java.security.AccessControlContext;
import java.security.AccessController;
import java.security.PrivilegedAction;

/**
 *Permissions fall into these categories: File, Socket, Net,
 * Security, Runtime, Property, AWT, Reflect, and Serializable
 */
public class App 
{
    public static void main( String[] args )
    {
        
        SecurityManager security = System.getSecurityManager();
        if (security != null) {
            //security.checkXXX(argument,  . . . );
            
           Integer x =  AccessController.doPrivileged(new PrivilegedAction<Integer>(){

                public Integer run() {
                    return 5;
                }
                
                
            },(AccessControlContext) security.getSecurityContext());
            
            
        }
    }
}
