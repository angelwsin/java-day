package org.java.jvm.allocation;

//------------------------------ReallocMark---------------------------------
//Code which uses REALLOC_RESOURCE_ARRAY should check an associated
//ReallocMark, which is declared in the same scope as the reallocated
//pointer.  Any operation that could __potentially__ cause a reallocation
//should check the ReallocMark.
public class ReallocMark extends StackObj{

}
