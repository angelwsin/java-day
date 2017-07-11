package org.java.jvm.allocation;



//Base class for objects used as value objects.
//Calling new or delete will result in fatal error.
//
//Portability note: Certain compilers (e.g. gcc) will
//always make classes bigger if it has a superclass, even
//if the superclass does not have any virtual methods or
//instance fields. The HotSpot implementation relies on this
//not to happen. So never make a ValueObj class a direct subclass
//of this object, but use the VALUE_OBJ_CLASS_SPEC class instead, e.g.,
//like this:
//
//class A VALUE_OBJ_CLASS_SPEC {
//  ...
//}
//
//With gcc and possible other compilers the VALUE_OBJ_CLASS_SPEC can
//be defined as a an empty string "".
//
public class _ValueObj {

}
