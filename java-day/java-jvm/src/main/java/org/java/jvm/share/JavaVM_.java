package org.java.jvm.share;

public class JavaVM_ {
    
    JNIInvokeInterface_ functions;
    
    
    int DestroyJavaVM() {
        return functions.DestroyJavaVM(this);
    }
    int AttachCurrentThread(Object penv, Object  args) {
        return functions.AttachCurrentThread(this, penv, args);
    }
    int DetachCurrentThread() {
        return functions.DetachCurrentThread(this);
    }

    int GetEnv(Object penv, int version) {
        return functions.GetEnv(this, penv, version);
    }
    int AttachCurrentThreadAsDaemon(Object penv, Object args) {
        return functions.AttachCurrentThreadAsDaemon(this, penv, args);
    }

}
