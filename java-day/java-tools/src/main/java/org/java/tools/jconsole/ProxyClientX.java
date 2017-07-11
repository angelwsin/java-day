package org.java.tools.jconsole;

import java.io.IOException;
import java.lang.management.ManagementFactory;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import javax.management.MBeanServerConnection;
import javax.management.remote.JMXConnector;
import javax.management.remote.JMXConnectorFactory;
import javax.management.remote.JMXServiceURL;
import javax.management.remote.rmi.RMIConnector;
import javax.management.remote.rmi.RMIServer;

import com.sun.tools.attach.VirtualMachine;



public class ProxyClientX {
	
	private String hostName ;
    private int port;
	private JMXServiceURL jmxUrl;
	
	 private MBeanServerConnection mbsc;
	 private JMXConnector jmxc ;
	 
	 private VirtualMachine lvm;
	private String userName;
	private String password;
	private RMIServer stub = null;
	
	 private static Map<String, ProxyClientX> cache;
	
	
	
	 static{
		 
		 cache = Collections.synchronizedMap(new HashMap());
	 }
	
	
	 //本地 pid 连接
	public ProxyClientX(VirtualMachine lvm) {
		super();
		this.lvm = lvm;
	}






	public ProxyClientX(String hostName, int port) {
		this.hostName = hostName;
		this.port = port;
		
	}





    //远程 <hostname>:<port> 或 service:jmx:<protocol>:<sap>
	public void conect()throws Exception{
		//本地连接
		if(this.jmxUrl==null&&"localhost".equals(hostName)&&this.port==0){
			this.mbsc = ManagementFactory.getPlatformMBeanServer();
		}else{
			if (this.lvm != null) {
				String address = startManagementAgent(this.lvm);
				if (this.jmxUrl == null) {
					this.jmxUrl = new JMXServiceURL(address);
				}
			}
				       Map<String,Object>localObject = new HashMap();
				       if (false) {
				         ((Map)localObject).put("jmx.remote.x.check.stub", "true");
				       }
				 
				         if (isVmConnector())
				         {
				           /*if (this.stub == null) {
				             checkSslConfig();
				           }*/
				           this.jmxc = new RMIConnector(this.stub, null);
				           this.jmxc.connect((Map)localObject);
				         } else {
				           this.jmxc = JMXConnectorFactory.connect(this.jmxUrl, (Map)localObject);
				         }
				       
				       this.mbsc = this.jmxc.getMBeanServerConnection();
		}
	}
	
	private boolean isVmConnector() {
        // TODO Auto-generated method stub
        return false;
    }






    public static ProxyClientX getProxyClient(VirtualMachine paramLocalVirtualMachine)
			    throws IOException
			  {
			     String str = getCacheKey(paramLocalVirtualMachine);
			     ProxyClientX localProxyClient = (ProxyClientX)cache.get(str);
			     if (localProxyClient == null) {
			       localProxyClient = new ProxyClientX(paramLocalVirtualMachine);
			      cache.put(str, localProxyClient);
			     }
			     return localProxyClient;
		   }






	private static String getCacheKey(VirtualMachine paramLocalVirtualMachine) {
		
		return paramLocalVirtualMachine.id();
	}
	
	
	private String startManagementAgent(VirtualMachine vim){
		String address = null;
		try {
		VirtualMachine vm = 	VirtualMachine.attach(vim.id());
		Properties localProperties = vm.getAgentProperties();
		 address = (String)localProperties.get("com.sun.management.jmxremote.localConnectorAddress");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return address;
	}

}
