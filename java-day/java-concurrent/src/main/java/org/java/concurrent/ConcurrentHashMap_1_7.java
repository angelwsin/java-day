package org.java.concurrent;

import java.util.concurrent.ConcurrentHashMap;

//Like {@link Hashtable} but unlike {@link HashMap}, this class  does not allow null to be used as a key or value

////JDK1.6之后，对synchronized优化，根据不同情形出现了偏向锁、轻量锁、自旋锁，重量级锁  jdk1.8 
public class ConcurrentHashMap_1_7 {
	public static void main(String[] args) {
		ConcurrentHashMap<String,String> map = new ConcurrentHashMap<String, String>();
		
		//ConcurrentHashMap 1.7  中维护一个分段锁数组segments(每一个Segment是实现了可重入锁ReentrantLock)
		//这样ConcurrentHashMap 比原来的HashMap多了一级
		
		//ConcurrentHashMap  读和写加锁问题 以及可见性问题
		/**
		 * 
		 * 
		 * 
		 * segments      __________________________________
		 *               |Segment|      |      |    |      |
		 *               ———————————————————————————————————
		 *                  |
		 *                  | 
		 * HashEntry<K,V>[]table
		 *      ——————————————————————————————————
		 *      |HashEntry|        |      |     |
		 *      ———————————————————————————————————
		 *      
		 *      
		 *      扩容 ： int newCapacity = oldCapacity << 1;
		 *      
		 *      扩容算法
		 *            计算当前idx下  最后一个移动的位置的元素
		 *            然后遍历 从新hash移动到新位置
		 *            
		 * HashEntry<K,V>[] oldTable = table;
            int oldCapacity = oldTable.length;
            int newCapacity = oldCapacity << 1;
            threshold = (int)(newCapacity * loadFactor);
            HashEntry<K,V>[] newTable =
                (HashEntry<K,V>[]) new HashEntry[newCapacity];
            int sizeMask = newCapacity - 1;
            for (int i = 0; i < oldCapacity ; i++) {
                HashEntry<K,V> e = oldTable[i];
                if (e != null) {
                    HashEntry<K,V> next = e.next;
                    int idx = e.hash & sizeMask;
                    if (next == null)   //  Single node on list
                        newTable[idx] = e;
                    else { // Reuse consecutive sequence at same slot
                        HashEntry<K,V> lastRun = e;
                        int lastIdx = idx;
                       //查找到最后一个需要移动的 HashEntry 和newTable中的位置
                        for (HashEntry<K,V> last = next;
                             last != null;
                             last = last.next) {
                            int k = last.hash & sizeMask;
                            if (k != lastIdx) {
                                lastIdx = k;
                                lastRun = last;
                            }
                        }
                        //最后一个HashEntry 插入
                        newTable[lastIdx] = lastRun;
                        // Clone remaining nodes
                         //逐个rehash 移动
                        for (HashEntry<K,V> p = e; p != lastRun; p = p.next) {
                            V v = p.value;
                            int h = p.hash;
                            int k = h & sizeMask;
                            HashEntry<K,V> n = newTable[k];
                            newTable[k] = new HashEntry<K,V>(h, p.key, v, n);
                        }
                    }
                }
            }
            int nodeIndex = node.hash & sizeMask; // add the new node
            node.setNext(newTable[nodeIndex]);
            newTable[nodeIndex] = node;
            table = newTable;
		 *                  
		 *       
		 *           
		 * 
		 * 
		 * jdk1.6 的实现  ConcurrentHashMap 怎么做到读不需要加锁  可以读到写的数据
		 * 
		 *  1.在 Segment 维护一个  volatile int count
		 *  2.HashEntry 中的 volatile V value
		 *  
		 *Read operations can thus proceed without locking, but rely
         * on selected uses of volatiles to ensure that completed
         * write operations performed by other threads are
         * noticed. For most purposes, the "count" field, tracking the
         * number of elements, serves as that volatile variable
         * ensuring visibility.  This is convenient because this field
         * needs to be read in many read operations anyway:
         *
         *   - All (unsynchronized) read operations must first read the
         *     "count" field, and should not look at table entries if
         *     it is 0.
         *
         *   - All (synchronized) write operations should write to
         *     the "count" field after structurally changing any bin.
         *     The operations must not take any action that could even
         *     momentarily cause a concurrent read operation to see
         *     inconsistent data. This is made easier by the nature of
         *     the read operations in Map. For example, no operation
         *     can reveal that the table has grown but the threshold
         *     has not yet been updated, so there are no atomicity
         *     requirements for this with respect to reads.
		 */
		
	/*ConcurrentHashMap 描述

                支持并发的读和高期望值的写，ConcurrentHashMap 遵守着Hashtable的功能规范
     ConcurrentHashMap 所有的功能都是线程安全的
               读操作都不需要加锁
              支持不需要对整个table加锁进行访问（读写） 分段锁的实现

                检索操作（包括get）通常不会阻塞，因此可能与更新操作（包括put和remove）重叠
                 不允许null被用作键或值   */ 
		
	}

}
