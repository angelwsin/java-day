package org.java.net;

import java.net.InetAddress;

/**
 * 
 * java net
 *
 */
public class App 
{
    public static void main( String[] args )throws Exception
    {

    	//地址
    	InetAddress local = InetAddress.getLocalHost();
    	
    	//dns 域名
    	InetAddress.getByName("www.daidu.com");
    	
    	//URL  URI  URN
    	

    }
}
