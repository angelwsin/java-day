package org.java.jvm.memory;


//--------------------------------------------------------------------------------------
//ChunkPool implementation

//MT-safe pool of chunks to reduce malloc/free thrashing
//NB: not using Mutex because pools are used before Threads are initialized
public class ChunkPool<mtInternal> extends CHeapObj{
    
    Chunk       _first;        // first cached Chunk; its first word points to next chunk
    int       _num_chunks;   // number of unused chunks in pool
    int       _num_used;     // number of chunks currently checked out
     int _size;         // size of each chunk (must be uniform)

}


/*
PoolChunk主要使用long allocate(int normCapacity) 在buffer pool中分配buffer。这个类有几个重要的概念：page:是chunk中内存分配的最小单元，chunk:表示一系列的page, 一个chunk的大小chunksize=2{maxorder}*pageSize。

首先需要分配一个长度等于chunksize的字节数组，当需要从中分配一个bytebuf时，返回一个第一个有足够空间满足这个bytebuf大小的位置。然后标记这块缓冲不可再分配了，除非该bytebuf释放。

为了在chunk中搜索满足大小的内存快的偏移，我们需要构造一个完全满二叉树，该二叉树使用byte[]存储-memoryMap,该二叉树的深度为maxOrder+1,从0开始计数，

0                                           1

1                                    2                  3

2                                4       5         6       7

3                            8    9 10  11 12  13  14 15

maxOrder 

这个满二叉树，每个叶子结点标识一个page的使用状态，根结点就标识整个chunk的使用状态。 二叉树的length为2{maxorder+1}*pageSize.  [0]不存储值

在chunk中分配算法如下，如果要分配一个chunksize/2{k}，我们将从第k层从左到到右中寻找未使用的节点。

memoryMap[id]=depth_of_id   =>没有使用

memoryMap[id]>depth_of_id   =>他的子结点被分配了，该结点不能分配，但是他的子结点还可以被分配。

memoryMap[id]=maxorder+1   =>子结点完全分配完了*/