package org.java.jvm.classfile;

import org.java.jvm.memory.MemoryType;
import org.java.jvm.oops.klass.Klass;

public class DictionaryEntry extends HashtableEntry<Klass, MemoryType>{
	
	ClassLoaderData       _loader_data;

	
	boolean equals(String class_name, ClassLoaderData loader_data)  {
	    Klass klass = (Klass)literal();
	    return (klass.name()== class_name &&
	            _loader_data == loader_data);
	  }
	
	public DictionaryEntry next()  {
	    return (DictionaryEntry)next();
	  }
}
