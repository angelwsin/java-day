package org.java.tools.jconsole;

import java.util.List;
import java.util.Properties;

import com.sun.tools.attach.VirtualMachine;
import com.sun.tools.attach.VirtualMachineDescriptor;

public class JconsoleLocal {
	
	
	/*
	 * 模拟 jconsole 本地连接
	 */
	public static void main(String[] args) throws Exception{
		
		String select ="org.java.jmx.MBeanApp";
		//得到本地可选的 vm
		List<VirtualMachineDescriptor>  vDesc =  VirtualMachine.list();
		
		//选中要连接的本地vm
		VirtualMachine  vmSelected = null;
		String address = null;
		for(VirtualMachineDescriptor desc : vDesc){
			System.out.println(desc.displayName()+":"+desc.id());
			if(select.equals(desc.displayName())){
				vmSelected = VirtualMachine.attach(desc);

				 Properties localProperties = vmSelected.getAgentProperties();
				 address = (String)localProperties.get("com.sun.management.jmxremote.localConnectorAddress");
				vmSelected.detach();
			}
		}
		
		if(vmSelected!=null){
			vmSelected.
		}
		
	}

}
