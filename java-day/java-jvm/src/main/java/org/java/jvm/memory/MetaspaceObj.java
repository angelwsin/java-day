package org.java.jvm.memory;


//Base class for objects stored in Metaspace.
//Calling delete will result in fatal error.
//
//Do not inherit from something with a vptr because this class does
//not introduce one.  This class is used to allocate both shared read-only
//and shared read-write classes.
//
public class MetaspaceObj {

}
