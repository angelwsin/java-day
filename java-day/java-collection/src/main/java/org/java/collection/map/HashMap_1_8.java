package org.java.collection.map;

import java.util.HashMap;
import java.util.Map;

public class HashMap_1_8 {
    
    public static void main(String[] args) {
        
        
        //依赖于 hashcode  数组  链表  链表解决冲突
        //默认 16  扩容2倍
        //链表   原来位置 j   j+old   分半 
        //& 高低位 拆分
        Map<String,String>     hashMap = new HashMap<String,String>();
        
        System.out.println(9&7);
        System.out.println(9&8);
        System.out.println(9&15);
        
        
        //map 扩容
        
        //1.7 遍历 从新计算hash值  二倍扩容    遍历移除
        
        //1.8  newCap = oldCap << 1
        /**
         * 1.8的HashMap对 hash做了处理(XORs) java.util.HashMap.hash(Object)
         *  hash是个32的int 
         *  hash =  (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16)
         *  区分高位，低位  用于后面的扩容
         * 
         *  hash&(n-1)  低位不变
         *  hash&n      高位         index+old
         *  
         *  举例
         *  
         *  size  16    1111
         *  
         *  size  32    11111
         *                       
         *  低位不变     hash = 8     1000   oldIndex = 8   newIndex= 8 
         *         hash = 24    11000  oldIndex = 8   newIndex= 8+16 = 24
         *         
         *         
         * 初始化  loHead,loTail(Hash低位队列)
         *      hiHead,hiTail(Hash高位队列)        
         * Node<K,V> loHead = null, loTail = null;
                        Node<K,V> hiHead = null, hiTail = null;
                        Node<K,V> next;
                        do {
                            next = e.next;
                            if ((e.hash & oldCap) == 0) {
                                if (loTail == null)
                                    loHead = e;
                                else
                                    loTail.next = e;
                                loTail = e;
                            }
                            else {
                                if (hiTail == null)
                                    hiHead = e;
                                else
                                    hiTail.next = e;
                                hiTail = e;
                            }
                        } while ((e = next) != null);
                        //低位队列还在原来的位置不用移动
                        if (loTail != null) {
                            loTail.next = null;
                            newTab[j] = loHead;
                        }
                        //高位队列要移动到j + oldCap的位置上
                        if (hiTail != null) {
                            hiTail.next = null;
                            newTab[j + oldCap] = hiHead;
                        }
         *  
         */
    }

}
