package org.java.nio.buffer;

public class NIOBuffer {
    
    
    
    
    
    
    
    public static void main(String[] args) {
        
        
        /**
         * 
         * ByteBuffer
         *    |
         *    |__HeapByteBuffer
         *    |         |
         *    |         |__HeapByteBufferR(只读)
         *    |
         *    |
         *    |__MappedByteBuffer(用户空间和内核的映射 减少copy) (在堆外分配回收性能低 采用池化技术)
         *            |
         *            |__DirectByteBuffer
         *                     |
         *                     |__DirectByteBufferR
         * 
         */
        
    }

}
