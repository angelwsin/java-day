package org.java.jmx;

import java.lang.management.ManagementFactory;

import javax.management.MBeanInfo;
import javax.management.MBeanServer;
import javax.management.MBeanServerFactory;
import javax.management.ObjectName;

import org.java.jmx.mbean.CommandImpl;
import org.java.jmx.mbean.ExecutorImpl;
import org.java.jmx.mbean.filter.ExecutorFilter;
import org.java.jmx.mbean.listener.ExectorListenner;

/*
 *  MBean之间的通信是必不可少的，Notification就起到了在MBean之间沟通桥梁的作用。JMX 的通知由四部分组成：
1、Notification这个相当于一个信息包，封装了需要传递的信息
2、Notification broadcaster这个相当于一个广播器，把消息广播出。
3、Notification listener 这是一个监听器，用于监听广播出来的通知信息。
4、Notification filiter 这个一个过滤器，过滤掉不需要的通知。这个一般很少使用。
*/
public class MBeanApp {

	
	public static void main(String[] args) throws Exception
	{
		       MBeanServer mBeanServer =     ManagementFactory.getPlatformMBeanServer();
		       System.out.println(mBeanServer.getDefaultDomain());
		       ObjectName  exe  = new ObjectName("exe:type=executor");
		       ExecutorImpl ex =  new ExecutorImpl();
		       mBeanServer.registerMBean(new ExecutorImpl(), exe);

		       
		       ObjectName  commd = new ObjectName("commad:type=command");
		       
		       mBeanServer.registerMBean(new CommandImpl(), commd);
		       
		       ex.addNotificationListener(new ExectorListenner(), new ExecutorFilter(), null);
		       
		       String runtimeName = ManagementFactory.getRuntimeMXBean().getName();
		         // format: "pid@hostname"
		         
		         System.out.println(runtimeName.substring(0, runtimeName.indexOf("@")));
		         Thread.sleep(Integer.MAX_VALUE);
		       
		       
	}
}
