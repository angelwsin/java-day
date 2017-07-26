package org.java.jndi.rmi;

import java.util.Hashtable;

import javax.naming.Context;
import javax.naming.InitialContext;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )throws Exception
    {
        Hashtable<String,String> environment = new Hashtable<String, String>();
        //It specifies the class name of the initial context factory for the provider.
        environment.put(Context.INITIAL_CONTEXT_FACTORY,
                "com.sun.jndi.rmi.registry.RegistryContextFactory");
        environment.put(Context.PROVIDER_URL, "rmi://localhost:9090/userSerice");
        InitialContext initContext = new InitialContext(environment);
        
    }
}
