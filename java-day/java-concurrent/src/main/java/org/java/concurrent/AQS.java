package org.java.concurrent;

import java.util.concurrent.locks.AbstractQueuedSynchronizer;

//CLH的一种变体被应用在了JAVA并发框架中。CLH在SMP系统结构下该法是非常有效的

// Wait queue node class.  spinlocks自旋锁
public class AQS  extends AbstractQueuedSynchronizer{
	
   /*     +------+  prev +-----+       +-----+
   * head |      | <---- |     | <---- |     |  tail
   *      +------+ --->  +-----+ --->  +-----+
   *                next
   *                
   *  
   *  AQS 对CLH 的改变 使用双向链表
   *  使用  int state 代表locked
   *  The synchronization state.
   *  可中断
   *  
   *  await 的实现使用 Condition 每一个Condition中维护一个链表（node）的节点
   *  使用LockSupport实现
   *  java.util.concurrent.locks.LockSupport.park(object)
   *  java.util.concurrent.locks.LockSupport.unpark(Thread.currentThread())
   *  
   */
	
	

}
