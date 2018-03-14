package org.java.io.nio.aio;

import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;

/**
 * http://www.jianshu.com/p/a33f741fe450
 * https://zhuanlan.zhihu.com/p/23488863
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        
        
        /*BIO与NIO

        BIO与NIO之间的共同点是他们都是同步的。而非异步的。

        BIO是阻塞的(当前线程必须等待感兴趣的事情发生), NIO是非柱塞的(事件选择，感兴趣的事情发生可以通知线程，而不必一直在哪等待);
        BIO是面向流式的IO抽象(一次一个字节地处理数据), NIO是面向块的IO抽象(每一个操作都在一步中产生或者消费一个数据块(Buffer));
        BIO的服务器实现模式为一个连接一个线程，NIO服务器实现模式为一个请求一个线程;
        */

      
        
        /**
         * 
         * 目标:不遗余力的榨取cpu 想方设法的减少内存拷贝
         * 
         * 阻塞
         * 
         * 
         * 非阻塞
         * 
         * 
         * 异步
         * 
         * 
         * 
         * 
         * 无处不存在的缓存
         * 
         * 所有的事件通知基于两类:
         *  1)主动查询   
         *    -轮询
         *    
         *  
         *  
         *  2)被动通知
         *      -订阅主题
         *      -注册监听器
         *      -观察者
         * 
         * 
         * 
         * 又分阻塞和非阻塞
         * 
         * 
         *需要补习下 如 linux io
         *
         * 应用程序   系统调用    内核         存在拷贝
         * 
         * 
         * 
         * 
         * 
         * 
         * io :  file io  ,net io
         * 
         * http://tutorials.jenkov.com/java-io/overview.html
         * 1)io 传统的阻塞io
         * 
         * 2)nio 非阻塞io
         * 
         * 3)aio Async I/O
         * 
         * 
         * 
         * 
         * 
         * 
         * 堆外内存
         * 
         * 
         * byte buffer
         * 
         * 
         * 
         * 
         * 
         * 
         */
        
        
        ByteBuffer bs = MappedByteBuffer.allocateDirect(23);
        
    }
}
