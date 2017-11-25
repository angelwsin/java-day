package org.java.jvm.classfile;

//Verions of hashtable where two handles are used to compute the index.
public class TwoOopHashtable<T,F> extends Hashtable<T, F> {
	
	public  int compute_hash(String name, ClassLoaderData loader_data) {
	     int name_hash = name.hashCode();
	    // loader is null with CDS
	   
	     int loader_hash = loader_data == null ? 0 : loader_data.hashCode();
	    return name_hash ^ loader_hash;
	  }

	public int index_for(String name, ClassLoaderData loader_data) {
	    return this.hash_to_index(compute_hash(name, loader_data));
	  }

}
