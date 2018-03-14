package org.java.algorithm.search;

import java.util.List;


//静态查找 折半查找     顺序表   查找过程 二叉判定树
public class BinSearch extends AbstractSearch{
  
  
  
  public static void main(String[] args) {
      binV(arrays,40000,0,arrays.size()-1);
  }
  
  
  public static void bin(List<Node> list,int key){
      int start = 0;
      int end =   list.size()-1;
      
      while(start<=end){
          int mid = (start+end)/2;
          if(list.get(mid).getKey()==key){
              System.out.println("查找到:"+key);
              return ;
          }else if(list.get(mid).getKey()>key){
              end = mid -1;
          }else{
              start = mid+1;
          }
              
      }
  }
  
  public static void binV(List<Node> list,int key,int start,int end){
      int mid = (start+end)/2;
      if(start>end){
          System.out.println("没找到");
          return ;
      }
      if(list.get(mid).getKey()==key){
          System.out.println("查找到:"+key);
          return ;
      }else if(list.get(mid).getKey()>key){
          binV(list,key,start,mid-1);
      }else{
          binV(list,key,mid+1,end);
      }
      
  }

}
