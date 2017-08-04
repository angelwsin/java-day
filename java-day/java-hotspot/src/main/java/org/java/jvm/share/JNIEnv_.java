package org.java.jvm.share;

public class JNIEnv_ {
    
    JNINativeInterface_ functions;
    
    
    
    int GetVersion(JNIEnv_ env){   
       return  functions.GetVersion(this);
    }

}
