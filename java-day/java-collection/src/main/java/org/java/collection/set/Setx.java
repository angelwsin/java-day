package org.java.collection.set;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class Setx {

    
    public static void main(String[] args) {
       //去重  依赖 eques 方法 
        
        //HashMap<E,Object> map   使用map的key不可重复实现的  所有的value 指向一个object
        Set<String>  hashSet  = new HashSet<String>();
        
        //TreeMap      使用map  中的比较器
        Set<String>  treeSet  = new TreeSet<String>();    
        
    }
}
