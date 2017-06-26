package org.java.tools.jconsole;

import java.util.List;
import java.util.Properties;
import java.util.Set;

import com.sun.tools.attach.VirtualMachine;
import com.sun.tools.attach.VirtualMachineDescriptor;

import sun.jvmstat.monitor.HostIdentifier;
import sun.jvmstat.monitor.MonitoredHost;
import sun.jvmstat.monitor.MonitoredVm;
import sun.jvmstat.monitor.VmIdentifier;

public class JconsoleX {
	
	public static void main(String[] args) throws Exception{
		//java-day pid 
		int pid = 20032;

        List<VirtualMachineDescriptor> localList = VirtualMachine.list();
    	
    	/*for(VirtualMachineDescriptor desc : localList){
    		System.out.println(desc.displayName()+":"+desc.id());
    		VirtualMachine localVirtualMachine = VirtualMachine.attach(desc);
    		 Properties localProperties = localVirtualMachine.getAgentProperties();
    		String str = (String)localProperties.get("com.sun.management.jmxremote.localConnectorAddress");
    		System.out.println(str);
    		localVirtualMachine.detach();
    	}*/
        VirtualMachine vm = VirtualMachine.attach(String.valueOf(pid));
		
		 Properties localProperties = vm.getAgentProperties();
		 String str1 = (String)localProperties.get("com.sun.management.jmxremote.localConnectorAddress");
	     vm.detach();
	     System.out.println(str1);          
		
	}
	
	
	
	/**
	 * 
		
		
	 * @throws Exception
	 */
	public  static void  Monitor()throws Exception{
		MonitoredHost localMonitoredHost = MonitoredHost.getMonitoredHost(new HostIdentifier((String)null));
        Set<Integer> localSet = localMonitoredHost.activeVms();
        for(Integer i : localSet){
       MonitoredVm localMonitoredVm = localMonitoredHost.getMonitoredVm(new VmIdentifier(String.valueOf(i)));
        }
		
	}

}
