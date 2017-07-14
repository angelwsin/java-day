package org.java.jvm.memory;


//Helper class to allocate arrays that may become large.
//Uses the OS malloc for allocations smaller than ArrayAllocatorMallocLimit
//and uses mapped memory for larger allocations.
//Most OS mallocs do something similar but Solaris malloc does not revert
//to mapped memory for large allocations. By default ArrayAllocatorMallocLimit
//is set so that we always use malloc except for Solaris where we set the
//limit to get mapped memory.
public class ArrayAllocator {

}
