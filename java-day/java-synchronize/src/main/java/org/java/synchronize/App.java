package org.java.synchronize;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        new App().say();
    }
    
    
    
    
    public synchronized void say(){
        
        System.out.println("hello ");
    }
}
