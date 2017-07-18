package org.java.jvm.oops.klass;

import org.java.jvm.oops.metadata.Metadata;

//
//A Klass provides:
//1: language level class object (method dictionary etc.)
//2: provide vm dispatch behavior for the object
//Both functions are combined into one C++ class.

//One reason for the oop/klass dichotomy in the implementation is
//that we don't want a C++ vtbl pointer in every object.  Thus,
//normal oops don't have any virtual functions.  Instead, they
//forward all "virtual" functions to their klass, which does have
//a vtbl and does the C++ dispatch depending on the object's
//actual type.  (See oop.inline.hpp for some of the forwarding code.)
//ALL FUNCTIONS IMPLEMENTING THIS DISPATCH ARE PREFIXED WITH "oop_"!

//Klass layout:
// [C++ vtbl ptr  ] (contained in Metadata)
// [layout_helper ]
// [super_check_offset   ] for fast subtype checks
// [name          ]
// [secondary_super_cache] for fast subtype checks
// [secondary_supers     ] array of 2ndary supertypes
// [primary_supers 0]
// [primary_supers 1]
// [primary_supers 2]
// ...
// [primary_supers 7]
// [java_mirror   ]
// [super         ]
// [subklass      ] first subclass
// [next_sibling  ] link to chain additional subklasses
// [next_link     ]
// [class_loader_data]
// [modifier_flags]
// [access_flags  ]
// [last_biased_lock_bulk_revocation_time] (64 bits)
// [prototype_header]
// [biased_lock_revocation_count]
// [_modified_oops]
// [_accumulated_modified_oops]
// [trace_id]

//javaclass 对象指向它的类元数据的指针
public class Klass extends Metadata{

}
