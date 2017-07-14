package org.java.collection.list;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;
import java.util.Vector;

public class Listx {

    
    public static void main(String[] args) {
        
        
        List<String>  arrayList  =  new ArrayList<String>();//数组 扩容   copy
        List<String>  linkedList =  new LinkedList<String>();//链表
       
        Vector<String> vector = new Vector<String>();
        Stack<String>   stack = new Stack<String>();
        
        Deque<String>           qeque =  new ArrayDeque<String>();
    }
}
