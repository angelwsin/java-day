package org.java.concurrent;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;

public class Concurrent {
    
    
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
