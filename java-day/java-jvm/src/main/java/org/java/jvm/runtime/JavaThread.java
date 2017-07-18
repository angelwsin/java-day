package org.java.jvm.runtime;

import org.java.jvm.oops.OopDesc;

public class JavaThread extends Thread{

    
    JavaThread    _next;                          // The next thread in the Threads list
    OopDesc            _threadObj;                     // The Java level thread object
    
    
 // OS data associated with the thread
    OSThread _osthread;  // Platform-specific thread information


}
