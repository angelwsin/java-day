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
        
        init_globals();
        
        //java main 主线程  执行  main方法
        JavaThread main_thread = new JavaThread();
        
        
        
        //vm 线程
     //   Vmthread
        
        
        
        return 1;
    }
    
    private static  void init_globals(){
        
        //jmx 
        
        
        //codeCache_init
        
        //universe   gc的选取  堆的初始化      SystemDictionary 等初始化
        
        //interpreter_init  解释器模块
        
        //templateTable_init  模板表
    }

}
