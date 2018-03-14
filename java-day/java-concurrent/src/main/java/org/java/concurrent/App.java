package org.java.concurrent;

import java.util.TreeMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentSkipListMap;

/**
 * 并发的优化
 * 
 * 引入  自旋锁  lock
 * 
 * ConcurrentHashMap   分段锁    Segment分段锁维持一个HashMap
 * 
 * atomic   原子操作   cas
 * 
 * CopyOnWrite 写时复制   读多写少        读不加锁 写加锁    存在的问题 1.内存占用 2.数据一致性
 * 
 *  ForkJoin   
 *  Executor 线程池
 *  
 *  SkipList
 *  
 *      Skip List是一种随机化的数据结构，基于并联的链表，其效率可比拟于二叉查找树（对于大多数操作需要O(log n)平均时间）。
 *      基本上，跳跃列表是对有序的链表增加上附加的前进链接，增加是以随机化的方式进行的，所以在列表中的查找可以快速的跳过部分列表(因此得名)。
 *      所有操作都以对数随机化的时间进行。Skip List可以很好解决有序链表查找特定值的困难。
 *      
 *      跳表是平衡树的一种替代的数据结构，但是和红黑树不相同的是，跳表对于树的平衡的实现是基于一种随机化的算法的，这样也就是说跳表的插入和删除的工作是比较简单的。
 *      
 *      http://ifeve.com/cas-skiplist/
 *      
 *      
 *      Key-Value数据结构

                     目前常用的key-value数据结构有三种：Hash表、红黑树、SkipList，它们各自有着不同的优缺点（不考虑删除操作）：

       Hash表：插入、查找最快，为O(1)；如使用链表实现则可实现无锁；数据有序化需要显式的排序操作。
                     红黑树：插入、查找为O(logn)，但常数项较小；无锁实现的复杂性很高，一般需要加锁；数据天然有序。
       SkipList：插入、查找为O(logn)，但常数项比红黑树要大；底层结构为链表，可无锁实现；数据天然有序。
       
       
       线程存在的问题:死锁，饥饿，竞态条件或过度上下文切换
 * 
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        
        /**
         * linux  内核线程调度(linux中进程和线程同等对待  只是内存空间不同)
         * 
         * 使用双向链表组织 调用队列
         * 
         * 调度策略
         * 1.nice   时间片
         * 2.优先级
         * 
         * 
         * 阻塞放到 阻塞队列
         * 
         * 
         * AQS 
         * 
         * 
         * 
         * spinlock自旋锁    CLH锁

         * mutex排它锁    S（读锁）  X 写锁
         * 
         * spinlock不会导致线程的状态切换(用户态->内核态)，但是spinlock使用不当(如临界区执行时间过长)会导致cpu busy飙高
         * 
         * 2， spinlock与mutex对比
　　                         2.1，优缺点比较
　　spinlock不会使线程状态发生切换，mutex在获取不到锁的时候会选择sleep。
　　mutex获取锁分为两阶段，第一阶段在用户态采用spinlock锁总线的方式获取一次锁，如果成功立即返回；否则进入第二阶段，调用系统的futex锁去sleep，当锁可用后被唤醒，继续竞争锁。
　　Spinlock优点：没有昂贵的系统调用，一直处于用户态，执行速度快。
　　Spinlock缺点：一直占用cpu，而且在执行过程中还会锁bus总线，锁总线时其他处理器不能使用总线。
　　Mutex优点：不会忙等，得不到锁会sleep。
　　Mutex缺点：sleep时会陷入到内核态，需要昂贵的系统调用。
　　2.2，使用准则
　　Spinlock使用准则：临界区尽量简短，控制在100行代码以内，不要有显式或者隐式的系统调用，调用的函数也尽量简短。例如，不要在临界区中调用read,write,open等会产生系统调用的函数，也不要去sleep；strcpy，memcpy等函数慎用，依赖于数据的大小。
         */
        
        XLock  lock = new XLock();
        //lock 自旋锁
        Me s = new Me();
         for(int i=0;i<100;i++){
             new AddThred(s, lock).start();
         }
         
        
         
         try {
            Thread.currentThread().join(1000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
     
         System.out.println(s.s);
        
        //模拟  内核的线程调度       exector 框架
         
         
         
         
         
         
         
         
         //skipList
         
         ConcurrentSkipListMap<String, String> list = new ConcurrentSkipListMap<String, String>();
         //插入 cas lock free
         
         long start= System.currentTimeMillis();
         for(int i=0;i<10000;i++){
             list.put(String.valueOf(i), "value");
         }
         
         System.out.println("skipList:"+(System.currentTimeMillis()-start));
         
         
         ConcurrentHashMap<String, String> map = new ConcurrentHashMap<String, String>();
         start= System.currentTimeMillis();
         for(int i=0;i<10000;i++){
             map.put(String.valueOf(i), "value");
         }
         System.out.println("hashMap:"+(System.currentTimeMillis()-start));
        
         TreeMap<String, String> treeMap = new TreeMap<String, String>();
         start= System.currentTimeMillis();
         for(int i=0;i<10000;i++){
             treeMap.put(String.valueOf(i), "value");
         }
         System.out.println("treeMap:"+(System.currentTimeMillis()-start));
        
        
    }
    
    static  class AddThred extends Thread{
        private Me i ;
        private XLock lock;
        public AddThred(Me i,XLock lock) {
           this.i= i;
           this.lock = lock;
        }
        
        @Override
        public void run() {
            lock.lock();
            for(int i=0;i<10000;i++);
            i.s++;
            lock.unlock();
        }
    }
    
    static class Me {
        int s ;
        
    }
}
