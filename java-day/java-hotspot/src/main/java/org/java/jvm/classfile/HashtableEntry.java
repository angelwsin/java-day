package org.java.jvm.classfile;

public class HashtableEntry<T, F> extends BasicHashtableEntry<T,F>{

	T               _literal;          // ref to item in table.

	public T literal() {
		return _literal;
	}
	
	HashtableEntry<T, F> next()  {
	    return (HashtableEntry<T, F>) _next;
	  }
	
	
}
