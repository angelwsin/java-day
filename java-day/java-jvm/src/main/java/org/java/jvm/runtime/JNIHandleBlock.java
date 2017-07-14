package org.java.jvm.runtime;

import org.java.jvm.memory.CHeapObj;
import org.java.jvm.oops.Oop;

//JNI handle blocks holding local/global JNI handles
public class JNIHandleBlock<mtInternal> extends CHeapObj {
   final   static int block_size_in_oops  = 32;
    
    Oop[]     _handles= new Oop[block_size_in_oops]; // The handles

}
