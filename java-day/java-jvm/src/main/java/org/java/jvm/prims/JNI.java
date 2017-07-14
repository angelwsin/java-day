package org.java.jvm.prims;

import org.java.jvm.runtime.Threads;
import org.java.jvm.share.JavaVM_;

public class JNI {
    
    
    
    int  JNI_CreateJavaVM(JavaVM_ vm, Object penv, Object args){
        
        Threads.create_vm((JavaVMInitArgs)args, false);
        return 1;
    }
    
    
    
    
    public static  class JavaVMInitArgs{
        int version;

        int nOptions;
        JavaVMOption options;
        boolean ignoreUnrecognized;
    }


    public static class JavaVMOption{
        String optionString;
        Object extraInfo;
        
    }
    

}


