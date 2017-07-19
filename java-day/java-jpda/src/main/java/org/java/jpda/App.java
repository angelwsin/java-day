package org.java.jpda;

/**
 * Hello world!
 *
 */
public class App 
{
    /*JDB是基于文本和命令行的调试工具(例如Sun JDB
     * jdb
     * 
     */
    public static void main( String[] args )
    {
        /*
         * hotspot db
         */
        sun.jvm.hotspot.HSDB.main(args);
        
    }
}
