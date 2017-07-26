package org.java.jvm.runtime;

public class VMThread extends NamedThread{
    
 // Pointer to single-instance of VM thread
    private static  VMThread _vm_thread = new VMThread();
    
    private VMThread(){}

    
    public static VMThread create(){
        return _vm_thread;
    }
}
