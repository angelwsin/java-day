package org.java.jvm.runtime;

//WARNING:
//This is a very sensitive and fragile class. DO NOT make any
//change unless you are fully aware of the underlying semantics.

//This class can not inherit from any other class, because I have
//to let the displaced header be the very first word. Otherwise I
//have to let markOop include this file, which would export the
//monitor data structure to everywhere.
//
//The ObjectMonitor class is used to implement JavaMonitors which have
//transformed from the lightweight structure of the thread stack to a
//heavy weight lock due to contention

//It is also used as RawMonitor by the JVMTI

//ObjectMonitor.hpp
public class ObjectMonitor {
    
    
    void      set_object(Object  obj){}
    
    
    /*markOop   header() const;
        void      set_header(markOop hdr);

     * boolean       try_enter () {    }
    void      enter(){}
    void      exit(){}
    void      wait(){}
    void      notify(){}
    void      notifyAll(){}*/

}
