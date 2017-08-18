package org.java.jpda;

/**
 * Unit test for simple App.
 */
public class AppTest 
    
{
    
    //-agentlib:jdwp=transport=dt_socket,server=y,address=8000
    public static void main(String[] args) throws Exception{
        
        System.out.println("");
        
        Thread.sleep(Integer.MAX_VALUE);
    }
}
