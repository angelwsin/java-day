package org.java.collection.map;

import java.util.HashMap;
import java.util.Map;

public class Mapx {
    
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
        
        //1.7 遍历 从新计算hash值
        
        //1.8  二倍扩容
        /**
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
         */
    }

}
