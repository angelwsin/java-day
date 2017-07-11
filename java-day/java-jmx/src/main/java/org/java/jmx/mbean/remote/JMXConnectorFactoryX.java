package org.java.jmx.mbean.remote;

import java.util.HashMap;
import java.util.Map;

import javax.management.MBeanInfo;
import javax.management.MBeanOperationInfo;
import javax.management.MBeanServerConnection;
import javax.management.ObjectName;
import javax.management.remote.JMXConnector;
import javax.management.remote.JMXConnectorFactory;
import javax.management.remote.JMXServiceURL;

public class JMXConnectorFactoryX {
    
    public static void main(String[] args) throws Exception{
        
      //service:jmx:protocol:remainder
        // java 自带 两种协议 rmi iiop
        JMXServiceURL serviceURL = new JMXServiceURL("service:jmx:rmi:///jndi/rmi://localhost:1099/server");
        
        Map<String,Object> environment = new HashMap<String, Object>();
        
        JMXConnector jmxconnector = JMXConnectorFactory.connect(serviceURL, environment);
        MBeanServerConnection  connection = jmxconnector.getMBeanServerConnection();
        ObjectName  exe  = new ObjectName("exe:type=executor");
        MBeanInfo  mBeanInfo =  connection.getMBeanInfo(exe);
        MBeanOperationInfo[] ops = mBeanInfo.getOperations();
        
        for(MBeanOperationInfo op : ops ){
            
            connection.invoke(exe, op.getName(), null, null) ;
        }
        
        
    }

}
