package org.java.jvm.memory;


//------------------------------Chunk------------------------------------------
//Linked list of raw memory chunks
public class Chunk<mtChunk> extends CHeapObj{
    
    Chunk       _next;     // Next Chunk in list
    int  _len;      // Size of this Chunk

}
