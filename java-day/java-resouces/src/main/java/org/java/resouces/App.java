package org.java.resouces;

import java.net.URL;

/**
 * url uri urn 
 *
 */
public class App 
{
    public static void main( String[] args )throws Exception
    {
        
        //protocol://host:port/path?query#ref
        //资源与jar文件中的资源的URL的协议是不同的 开头分别为file:/和jar:file:/
        //jar文件的URL jar:http://hostname/my.jar!/
        //指向文件系统的URL jar:file:/c:/almanac/my.jar!/
        //指向jar文件里一个入口的URL jar:file:/c:/almanac/my.jar!/com/mycompany/MyClass.class
         URL url = new URL("");
         url.openConnection();
    }
}
