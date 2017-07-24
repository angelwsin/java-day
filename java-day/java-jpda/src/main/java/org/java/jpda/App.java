package org.java.jpda;

/**
 * Java 的调试体系—— JPDA
 *
 */
public class App 
{
    /*JDB是基于文本和命令行的调试工具(例如Sun JDB
     * jdb
     * 
     * https://www.ibm.com/developerworks/cn/java/j-lo-jpda1/index.html
     * 
     * http://blog.sina.com.cn/s/blog_56d8ea900102x3mz.html
     */
    public static void main( String[] args )
    {
        /*
         * hotspot db
         */
        sun.jvm.hotspot.HSDB.main(args);
        
    }
}
