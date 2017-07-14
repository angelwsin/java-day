package org.java.jvm.oops.metadata;

import org.java.jvm.memory.MetaspaceObj;

public class ConstMethod extends MetaspaceObj{

}


enum type {
    _has_linenumber_table ,// = 0x0001,
    _has_checked_exceptions ,//= 0x0002,
    _has_localvariable_table,// = 0x0004,
    _has_exception_table ,//= 0x0008,
    _has_generic_signature ,//= 0x0010,
    _has_method_parameters,// = 0x0020,
    _is_overpass,// = 0x0040,
    _has_method_annotations ,//= 0x0080,
    _has_parameter_annotations,// = 0x0100,
    _has_type_annotations ,//= 0x0200,
    _has_default_annotations ,//= 0x0400
  };

  
  enum MethodType{ NORMAL, OVERPASS } ;