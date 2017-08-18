package org.java.algorithm;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        //fail-fast
       
        //jdk1.7 使用排序算法 Dual-Pivot Quicksort 双轴快速排序  O(n log(n))
        Arrays.sort(new long[]{9,8});
        
        Map<String,String> hashMap =  new HashMap<>();
        //hashMap 的实现 及 扩充的算法
        
        //分段锁
        ConcurrentHashMap<String,String> ConcurrentHashMap = new ConcurrentHashMap<>();
        
        //A Red-Black tree 红黑树   排序 根据 Comparable或Comparator
        Map<String,String> treeMap = new TreeMap<>();
        
        //底层实现 使用 HashMap
        Set<String>  set = new HashSet<>();
    }
}
