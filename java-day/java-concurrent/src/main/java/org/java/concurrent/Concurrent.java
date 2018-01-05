package org.java.concurrent;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;

public class Concurrent {
	
	
	/*
	 * 互斥：是指某一资源同时只允许一个访问者对其进行访问，具有唯一性和排它性。但互斥无法限制访问者对资源的访问顺序，即访问是无序的。
	 * 同步：是指在互斥的基础上（大多数情况），通过其它机制实现访问者对资源的有序访问。在大多数情况下，同步已经实现了互斥，特别是所有写入资源的情况必定是互斥的。少数情况是指可以允许多个访问者同时访问资源
	 * 
	 * 协作协议：
	 *  互斥必需特性  可见性 原子性 （安全性）
	 *  死锁基础特性
	 *  无饥饿必需关注的特性
	 *  等待问题 容错非常重要
	 * 生产者-消费者协议:无饥饿性
	 *  (使用标志位中断实现 java中的 await(),notify()实现原理)
	 *  场景:处理器向通讯缓存区中放置数据
	 * 读-写问题
	 *   互斥，生产者-消费者协议解析，但是它们都必须等待，怎么解决无等待的读写?
	 * 并行的困境:
	 *  阿姆达尔定律(amdahl并行性定理)http://ifeve.com/amdahls-law/
	 *  
	 *  
	 *  
	 *  
	 *  
	 *  
	 *  
	 *  
	 *  
	 *  
	 *  
	 *  
	 *  
	 *  
	 *  
	 *  note:
	 *  伟大的计算原理
	 *  分布式计算领域最牛会议之PODC，全称是ACM
	 *  
	 *  大牛:
	 *  Leslie Lamport 训练自己的批判思维和抽象思维
	 *  E.W.Dijkstra
	 */
    
    
    /**
     * 
     * 线程通讯
     * 1.共享内存      java
     * 2.消息      Actor
     * 
     * @param args
     */
    
    public static void main(String[] args) {
        //Java并发编程的4种风格：Threads，Executors，ForkJoin和Actors
        
        
        //裸线程   Thread   共享内存通讯
        
        
        
        //Executor和CompletionService     task 调度api
        
        //ForkJoin
        
        
        
        //Actor JDK中没有actor的实现；因此你必须引用一些实现了actor的库
        
        /**
         * Actor模型原理
         * Actor模型=数据+行为+消息
         * Actor模型内部的状态由自己的行为维护，外部线程不能直接调用对象的行为，必须通过消息才能激发行为，这样就保证Actor内部数据只有被自己修改。
         * 
         * 
         * 
         * 
         * 
         * 
         * 数据库互相 转账  可能死锁
         */
        
    }
    
    public void forkJoin(){
        ForkJoinPool  pool = new ForkJoinPool();
       // pool.execute(task);
        
        
    }
    
    class SumTask<Integer> extends ForkJoinTask<Integer>{

        @Override
        public Integer getRawResult() {
            return null;
        }

        @Override
        protected void setRawResult(Integer value) {
            
        }

        @Override
        protected boolean exec() {
            return false;
        }

       
        
        
    }

}
