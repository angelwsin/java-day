package org.java.jvm.classfile;

import org.java.jvm.memory.CHeapObj;

public class BasicHashtableEntry<T,F> extends CHeapObj{

	
	 int         _hash;
	 
	 BasicHashtableEntry<T,F> _next;
	 
	 BasicHashtableEntry<T,F> next()  {
		    return _next;
		  }
}
