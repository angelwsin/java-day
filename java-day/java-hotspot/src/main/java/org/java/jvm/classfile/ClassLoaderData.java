package org.java.jvm.classfile;

import org.java.jvm.memory.CHeapObj;
import org.java.jvm.oops.OopDesc;

public class ClassLoaderData<mtClass> extends CHeapObj{
    
    OopDesc _class_loader;          // oop used to uniquely identify a class loader
    // class loader or a canonical class path

}
