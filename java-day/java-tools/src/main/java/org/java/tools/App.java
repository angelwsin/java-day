package org.java.tools;

import java.util.List;

import com.sun.tools.attach.VirtualMachine;
import com.sun.tools.attach.VirtualMachineDescriptor;



/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        List<VirtualMachineDescriptor> localList = VirtualMachine.list();
    	
    	for(VirtualMachineDescriptor desc : localList){
    		System.out.println(desc.displayName()+":"+desc.id());
    	}
    }
}
