package org.java.concurrent;

import java.util.concurrent.ConcurrentHashMap;

//Like {@link Hashtable} but unlike {@link HashMap}, this class  does not allow null to be used as a key or value
public class ConcurrentHashMap_1_7 {
	public static void main(String[] args) {
		ConcurrentHashMap<String,String> map = new ConcurrentHashMap<String, String>();
		
		//ConcurrentHashMap 1.7  中维护一个分段锁数组segments(每一个Segment是实现了可重入锁ReentrantLock)
		//这样ConcurrentHashMap 比原来的HashMap多了一级
		
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
		 * 
		 */
		
	}

}
