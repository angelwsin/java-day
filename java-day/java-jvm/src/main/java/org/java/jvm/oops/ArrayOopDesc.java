package org.java.jvm.oops;


//arrayOopDesc is the abstract baseclass for all arrays.  It doesn't
//declare pure virtual to enforce this because that would allocate a vtbl
//in each instance, which we don't want.

//The layout of array Oops is:
//
//markOop
//Klass*    // 32 bits if compressed but declared 64 in LP64.
//length    // shares klass memory or allocated after declared fields.

public class ArrayOopDesc extends OopDesc{

}
