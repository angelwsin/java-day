package com.jvm.Run_Time_Data_Areas;

public class MethodArea {
    
   /* The Java Virtual Machine has a method area that is shared among all Java Virtual
    Machine threads. The method area is analogous to the storage area for compiled
    code of a conventional language or analogous to the "text" segment in an operating
    system process. It stores per-class structures such as the run-time constant pool,
    field and method data, and the code for methods and constructors, including
    the special methods (§2.9) used in class and instance initialization and interface
    initialization*/
    
    
    
    class Run_Time_Constant_Pool{
       /* A run-time constant pool is a per-class or per-interface run-time representation
        of the constant_pool table in a class file (§4.4). It contains several kinds of
        constants, ranging from numeric literals known at compile-time to method and field
        references that must be resolved at run-time. The run-time constant pool serves a
        function similar to that of a symbol table for a conventional programming language,
        although it contains a wider range of data than a typical symbol table.
        Each run-time constant pool is allocated from the Java Virtual Machine's method
        area (§2.5.4). The run-time constant pool for a class or interface is constructed
        when the class or interface is created (§5.3) by the Java Virtual Machine
        */
    }

}




