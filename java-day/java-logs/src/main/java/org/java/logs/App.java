package org.java.logs;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * Hello world!
 *
 */
public class App 
{
    
    private static Logger log = LoggerFactory.getLogger(App.class);
    public static void main( String[] args )
    {
        
        
        try{
            log.info("Hello World!");
             
            Integer.parseInt("x");
            
        }catch (Exception e) {
            System.out.println(e);
            StackTraceElement[] st =  e.getStackTrace();
            for(StackTraceElement ex : st){
                System.out.println(ex); 
            }
           
         // e.printStackTrace();
        }
        
        
        System.out.println( "Hello World!" );
    }
}
