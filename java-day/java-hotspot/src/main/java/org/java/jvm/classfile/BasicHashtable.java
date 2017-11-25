package org.java.jvm.classfile;

import org.java.jvm.memory.CHeapObj;

public class BasicHashtable<T,F> extends CHeapObj{
	
	// Instance variables
	  int               _table_size;
	  HashtableBucket<T,F>[]     _buckets;
	  BasicHashtableEntry<T,F> _free_list;
	  char[]            _first_free_entry;
	  char[]             _end_block;
	  int               _entry_size;
	  int               _number_of_entries;
	  
	// Bucket handling
	public  int hash_to_index( int full_hash) {
	    int h = full_hash % _table_size;
	    return h;
	  }
	
	
	 BasicHashtableEntry<T,F> bucket(int i) {
		  return _buckets[i].get_entry();
		}

}
