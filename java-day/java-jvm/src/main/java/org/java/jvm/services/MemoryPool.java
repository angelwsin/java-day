package org.java.jvm.services;

import org.java.jvm.memory.CHeapObj;

public class MemoryPool<mtInternal> extends CHeapObj{

    
    enum PoolType {
        Heap,
        NonHeap
      };
      
      
   static class CollectedMemoryPool extends MemoryPool{
       
       
   }
   
   static class ContiguousSpacePool extends CollectedMemoryPool{
       
   }
   
   class SurvivorContiguousSpacePool extends CollectedMemoryPool {
   
   }
   
   class CompactibleFreeListSpacePool extends CollectedMemoryPool{}
   
   class GenerationPool extends CollectedMemoryPool{}
   
   
   class CodeHeapPool extends MemoryPool{}
   
   class MetaspacePool extends MemoryPool {}
   
   class CompressedKlassSpacePool extends MemoryPool{}
}
