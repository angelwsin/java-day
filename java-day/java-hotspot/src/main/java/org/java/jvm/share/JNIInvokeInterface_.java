package org.java.jvm.share;


/* End VM-specific. */
public class JNIInvokeInterface_ {
   
    
    public int DestroyJavaVM(JavaVM_ vm){  return 1;}
    
    public int AttachCurrentThread(JavaVM_ vm,Object penv,Object args){return 1;}
    
    public int DetachCurrentThread(JavaVM_ vm){return 1;}
    
    public int GetEnv(JavaVM_ vm,Object penv,int version){return 1;}
    
    public int AttachCurrentThreadAsDaemon(JavaVM_ vm,Object penv,Object args){return 1;}

}
