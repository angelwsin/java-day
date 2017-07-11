package org.java.jmx.mbean.remote;

import java.lang.management.ManagementFactory;
import java.rmi.registry.LocateRegistry;
import java.util.HashMap;
import java.util.Map;

import javax.management.MBeanServer;
import javax.management.ObjectName;
import javax.management.remote.JMXConnectorServer;
import javax.management.remote.JMXConnectorServerFactory;
import javax.management.remote.JMXServiceURL;

import org.java.jmx.mbean.ExecutorImpl;

//jmx 远程访问 提供两种连接模式
//rmi  jmxmp
public class JMXConnectorServerFactoryX {
    
    
    public static void main(String[] args)throws Exception {
        //rmi注册中心
        LocateRegistry.createRegistry(1099); 
        //service:jmx:protocol:remainder
        // java 自带 两种协议 rmi iiop
       
        JMXServiceURL serviceURL = new JMXServiceURL("service:jmx:rmi:///jndi/rmi://localhost:1099/server");
        
        Map<String,Object> environment = new HashMap<String, Object>();
        
         MBeanServer mbeanServer = ManagementFactory.getPlatformMBeanServer();
         
         ObjectName  exe  = new ObjectName("exe:type=executor");
         mbeanServer.registerMBean(new ExecutorImpl(), exe);
         //JMXConnectorFactory 中查找provider 
         JMXConnectorServer  jmxConnectorServer =  JMXConnectorServerFactory.newJMXConnectorServer(serviceURL, environment, mbeanServer) ;
         jmxConnectorServer.start();
         
      
    }

}
