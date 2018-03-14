package org.java.security.ACL;

import java.security.AccessControlContext;
import java.security.AccessController;
import java.security.PrivilegedAction;

/**
 * http://docs.oracle.com/javase/8/docs/technotes/guides/security/crypto/CryptoSpec.html
 *Permissions fall into these categories: File, Socket, Net,
 * Security, Runtime, Property, AWT, Reflect, and Serializable
 * 
 * java command are by default not run with a SecurityManager installed
 * 1.setSecurityManager method
 * 2.-Djava.security.manager  开启java的安全模式
 * 
 * http://www.cnblogs.com/yiwangzhibujian/p/6207212.html
 */
public class AccessControl {

	
	
	public static void main(String[] args) {
		 // access control
        SecurityManager security = System.getSecurityManager();
        
       // System.out.println(security.getClass());
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
