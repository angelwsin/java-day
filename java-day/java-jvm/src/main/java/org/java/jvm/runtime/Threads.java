package org.java.jvm.runtime;

import org.java.jvm.memory.AllStatic;
import org.java.jvm.prims.JNI.JavaVMInitArgs;

//The active thread queue. It also keeps track of the current used
//thread priorities.
public class Threads extends AllStatic{
    
    static JavaThread _thread_list;
    static int         _number_of_threads;
    static int         _number_of_non_daemon_threads;
    static int         _return_code;
    
 // Initializes the vm and creates the vm thread
    public static int create_vm(JavaVMInitArgs args, boolean canTryAgain){
        return 1;
    }

}
