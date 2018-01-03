package org.java.algorithm.search;

import java.util.List;


//静态查找 顺序查找
public class OrderSearch  extends AbstractSearch{
  
  
  
  
  
  
  public static void main(String[] args) {
     
      long time  = System.currentTimeMillis();
      genV(arrays,99);
      System.out.println(System.currentTimeMillis()-time);
  }
  
  
  public static void  gen(List<Node> list,int key){
     
       for(int i=0;i<list.size();i++){
           if(list.get(i).getKey()==key){
               System.out.println("查找到 :"+key);
               return;
           }
       }
       System.out.println("没有查到：");
  }
  
  
  //增加哨兵 不要每次都判断是否到达末尾
  
  public static void genV(List<Node> list,int key){
      //高位增加哨兵
       list.add(list.size(), new Node(key));
       int i=0;
       for(;!(list.get(i).getKey()==key);i++)
           ;
       if(i<list.size()-1){
           System.out.println("查找到 :"+key);  
       }else{
           System.out.println("没有查到："); 
       }
  }

}