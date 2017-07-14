package org.java.jvm.memory;


/*
 * Memory types
 */
public enum MemoryType {
    
    // Memory type by sub systems. It occupies lower byte.
    mtJavaHeap,//          = 0x00,  // Java heap
    mtClass,//             = 0x01,  // memory class for Java classes
    mtThread,//            = 0x02,  // memory for thread objects
    mtThreadStack,//       = 0x03,
    mtCode ,//             = 0x04,  // memory for generated code
    mtGC ,//               = 0x05,  // memory for GC
    mtCompiler  ,//        = 0x06,  // memory for compiler
    mtInternal ,//         = 0x07,  // memory used by VM, but does not belong to
                                   // any of above categories, and not used for
                                   // native memory tracking
    mtOther ,//            = 0x08,  // memory not used by VM
    mtSymbol ,//           = 0x09,  // symbol
    mtNMT ,//              = 0x0A,  // memory used by native memory tracking
    mtClassShared ,//      = 0x0B,  // class data sharing
    mtChunk   ,//          = 0x0C,  // chunk that holds content of arenas
    mtTest  ,//            = 0x0D,  // Test type for verifying NMT
    mtTracing ,//          = 0x0E,  // memory used for Tracing
    mtNone   ,//           = 0x0F,  // undefined
    mt_number_of_types,//  = 0x10   // number of memory types (mtDontTrack
                                   // is not included as validate type)

}
