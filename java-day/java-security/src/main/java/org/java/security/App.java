package org.java.security;

import java.security.AccessControlContext;
import java.security.AccessController;
import java.security.PrivilegedAction;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        SecurityManager security = System.getSecurityManager();
        if (security != null) {
            //security.checkXXX(argument,  . . . );
            
           Integer x =  AccessController.doPrivileged(new PrivilegedAction<Integer>(){

                @Override
                public Integer run() {
                    return 5;
                }
                
                
            },(AccessControlContext) security.getSecurityContext());
            
            
        }
    }
}
