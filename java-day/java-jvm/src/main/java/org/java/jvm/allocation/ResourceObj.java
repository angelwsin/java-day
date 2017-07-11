package org.java.jvm.allocation;


//----------------------------------------------------------------------
//Base class for objects allocated in the resource area per default.
//Optionally, objects may be allocated on the C heap with
//new(ResourceObj::C_HEAP) Foo(...) or in an Arena with new (&arena)
//ResourceObj's can be allocated within other objects, but don't use
//new or delete (allocation_type is unknown).  If new is used to allocate,
//use delete to deallocate.
public class ResourceObj extends AllocatedObj{

}
