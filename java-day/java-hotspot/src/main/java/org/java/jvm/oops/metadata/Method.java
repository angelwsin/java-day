package org.java.jvm.oops.metadata;

public class Method extends Metadata{
    
    // Entry point for calling both from and to the interpreter.
  //  Address _i2i_entry;           // All-args-on-stack calling convention
    
 // The entry point for calling both from and to compiled code is
    // "_code->entry_point()".  Because of tiered compilation and de-opt, this
    // field can come and go.  It can transition from NULL to not-null at any
    // time (whenever a compile completes).  It can transition from not-null to
    // NULL only at safepoints (because of a de-opt).
    Nmethod  _code;                       // Points to the corresponding piece of native code

}


// 符号引用 解析 链接  LinkResolver