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
    }

}
