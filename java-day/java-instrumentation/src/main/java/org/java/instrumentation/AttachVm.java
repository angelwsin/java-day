package org.java.instrumentation;

import java.lang.management.ManagementFactory;
import java.lang.management.RuntimeMXBean;

import com.sun.tools.attach.VirtualMachine;

public class AttachVm {

    
    
    public static void attachVM()throws Exception{
        RuntimeMXBean runtimeMXBean = ManagementFactory.getRuntimeMXBean();
        VirtualMachine vm = VirtualMachine.attach(runtimeMXBean.getName().split("@")[0]);
         vm.loadAgent("org.java.instrumentation.Angent");
         vm.detach();
       
    }
}
