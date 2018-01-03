package org.java.algorithm.tree;

import java.util.HashMap;
import java.util.Map;

public class N {
	
	public static void main(String[] args) {
        N n = null;
        n(n);
        System.out.println(n==null);
        
        Map<String,String> map = null;
        map(map);
        System.out.println(map==null);
        map = mapV();
        System.out.println(map==null);
    }
    
    //java 内存模型
    
    public static void n(N n){
        n = new N();
    }
    
    public static Map<String,String> mapV(){
         Map<String,String>map = new HashMap<String, String>();
         return map;
    }
    
    //方法传递都是按值(都是副本)  值分为两类  对于普通变量 数值 对于对象则是地址值
    public static   void map(Map<String,String> map){
        map = new HashMap<String, String>();
   }

}
