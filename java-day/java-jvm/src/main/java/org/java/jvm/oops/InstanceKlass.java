package org.java.jvm.oops;

import org.java.jvm.oops.klass.Klass;

public class InstanceKlass extends Klass{

	
	 int             _nonstatic_oop_map_size;// size in words of nonstatic oop map blocks
}




//ValueObjs embedded in klass. Describes where oops are located in instances of
//this klass.

//java对象的实例域
class OopMapBlock{
	
	
}
