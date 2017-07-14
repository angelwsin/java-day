package org.java.jvm.memory;


//All classes in the virtual machine must be subclassed
//by one of the following allocation classes:
//
//For objects allocated in the resource area (see resourceArea.hpp).
//- ResourceObj
//
//For objects allocated in the C-heap (managed by: free & malloc).
//- CHeapObj
//
//For objects allocated on the stack.
//- StackObj
//
//For embedded objects.
//- ValueObj
//
//For classes used as name spaces.
//- AllStatic
//
//For classes in Metaspace (class data)
//- MetaspaceObj
//
//The printable subclasses are used for debugging and define virtual
//member functions for printing. Classes that avoid allocating the
//vtbl entries in the objects should therefore not be the printable
//subclasses.
//
//The following macros and function should be used to allocate memory
//directly in the resource area or in the C-heap, The _OBJ variants
//of the NEW/FREE_C_HEAP macros are used for alloc/dealloc simple
//objects which are not inherited from CHeapObj, note constructor and
//destructor are not called. The preferable way to allocate objects
//is using the new operator.
//
//WARNING: The array variant must only be used for a homogenous array
//where all objects are of the exact type specified. If subtypes are
//stored in the array then must pay attention to calling destructors
//at needed.
//
//NEW_RESOURCE_ARRAY(type, size)
//NEW_RESOURCE_OBJ(type)
//NEW_C_HEAP_ARRAY(type, size)
//NEW_C_HEAP_OBJ(type, memflags)
//FREE_C_HEAP_ARRAY(type, old, memflags)
//FREE_C_HEAP_OBJ(objname, type, memflags)
//char* AllocateHeap(size_t size, const char* name);
//void  FreeHeap(void* p);
//
//C-heap allocation can be traced using +PrintHeapAllocation.
//malloc and free should therefore never called directly.

//Base class for objects allocated in the C-heap.

//In non product mode we introduce a super class for all allocation classes
//that supports printing.
//We avoid the superclass in product mode since some C++ compilers add
//a word overhead for empty super classes.
public class AllocatedObj {

}
