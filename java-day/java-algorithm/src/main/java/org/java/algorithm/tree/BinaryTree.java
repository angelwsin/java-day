package org.java.algorithm.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BinaryTree<T> {
    
    
    protected Node<T>  root;
    
    BinaryTree(T root){
        this.root =  new Node<T>();
        this.root.setData(root);
    }
    
   public BinaryTree() {
  }
    
    
    public void addLeft(T data){
        this.root.addLeft(data);
    }
    
    public void addRight(T data){
        this.root.addRight(data);
    }
    
    public static void main(String[] args) {
        
        BinaryTree<String> tree = new BinaryTree<String>();
        List<String> list = new ArrayList<String>();
        list.add("A");
        list.add("B");
        list.add(null);
        list.add(null);
        list.add("C");
        list.add(null);
        list.add(null);
        tree.createTree(list);
         tree.first();
        
        
        
    }
    
    public void  first(){
        this.root.first();
    }
    
    public void mid(){
        this.root.mid();
    }
    
    public void after(){
        this.root.after();
    }
    
    @SuppressWarnings("unchecked")
    public Node<T> createBinTree(){
        Scanner sc  = new Scanner(System.in);
        String data = sc.nextLine();
        System.out.println(data);
        if(" ".equals(data))
            return null;
        Node<T> node = new Node<T>();
        node.setData((T) data);
        node.setLeft(createBinTree());
        node.setRight(createBinTree());
        return node;
        
    }
    
    public void createTree(){
        this.root = createBinTree();
    }
    
    public Node<T> createBinTree(List<T> list){
        T data = list.remove(0);
        if(data==null)
            return null;
        Node<T> node = new Node<T>();
        node.setData(data);
        node.setLeft(createBinTree(list));
        node.setRight(createBinTree(list));
        return node;
        
    }
    
    public void createTree(List<T> list){
        this.root = createBinTree(list);
    }
    
    public int deep(){
        return 0;
    }

}
