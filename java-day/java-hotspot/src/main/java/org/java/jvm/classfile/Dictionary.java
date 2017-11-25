package org.java.jvm.classfile;

import org.java.jvm.memory.MemoryType;
import org.java.jvm.oops.klass.Klass;

//MemoryType.mtClass
public class Dictionary extends TwoOopHashtable<Klass, MemoryType> {
	
	
	/**
	 * 
	 * 
	 * 结构  hashtable
	 *    _________________________
	 *    |    |     |     |     |      
	 *    
	 *    
	 *    
	 */
	
	// This routine does not lock the system dictionary.
	//
	// Since readers don't hold a lock, we must make sure that system
	// dictionary entries are only removed at a safepoint (when only one
	// thread is running), and are added to in a safe way (all links must
	// be updated in an MT-safe manner).
	//
	// Callers should be aware that an entry could be added just after
	// _buckets[index] is read here, so the caller will not see the new entry.
	DictionaryEntry  get_entry(int index,  int hash,
	                                       String class_name,
	                                       ClassLoaderData loader_data) {
	  for (DictionaryEntry entry = bucket(index);
	                        entry != null;
	                        entry = entry.next()) {
	    if (entry.hashCode() == hash && entry.equals(class_name, loader_data)) {
	      return entry;
	    }
	  }
	  return null;
	}

	public DictionaryEntry bucket(int index) {
		// TODO Auto-generated method stub
		return bucket(index);
	}
	
	
	


}
