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
    
    
    
    
    /*
     * 梳理下 日志家族
     * 
     * 
     * 
     *          日志接口         commons-logging(apache)     slf4j(Simple Logging Facade for JAVA )    
     *          
     *          实现                 log4j,jdk14logger            logback
     * 
     *          运行时              过动态查找的机制，绑定日志实现库                       静态绑定
     * 
     * 
     *                            适配
     *           
     *         log4j             slf4j-log4j12                 slf4j
     *         
     *         jdk14logger       slf4j-jdk14
     * 
     * 
     * 
     * 
     */
}
