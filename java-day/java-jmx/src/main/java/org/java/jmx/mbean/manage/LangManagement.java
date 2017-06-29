package org.java.jmx.mbean.manage;

import java.lang.management.ManagementFactory;
import java.lang.management.MemoryMXBean;

public class LangManagement {
    
    
    //Provides the management interfaces for monitoring and management of the Java virtual machine and other components in the Java runtime
    public static void main(String[] args) {
        
        MemoryMXBean memoryMxBean =   ManagementFactory.getMemoryMXBean();
        
        System.out.println(String.format("objectName=%s", memoryMxBean.getObjectName()));
        System.out.println(String.format("heapMax=%d",  memoryMxBean.getHeapMemoryUsage().getMax()));
    }

}
