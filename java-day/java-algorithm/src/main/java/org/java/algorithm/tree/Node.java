package org.java.algorithm.tree;

import org.java.algorithm.dynamic.search.Status;

public class Node<T> implements Comparable<Node<T>>{
    
    protected Node<T>  left;
    
    protected T     data;
    
    protected Node<T>  right;
    
    protected Node<T>  parent;

    public Node<T> getLeft() {
        return left;
    }

    public void setLeft(Node<T> left) {
        this.left = left;
    }

    public T getData() {
        
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Node<T> getRight() {
        return right;
    }

    public void setRight(Node<T> right) {
        this.right = right;
    }

    public void addLeft(T data){
        if(this.getLeft()==null) {
            Node<T> left = new Node<T>();
            left.setData(data);
            this.setLeft(left);
            return ;
        }
        this.getLeft().addLeft(data);
    }
    
    public void addRight(T data){
       
        if(this.getRight()==null){
            Node<T> right = new Node<T>();
            right.setData(data);
            this.setRight(right);
            return ;
         }
       this.getRight().addRight(data);  

    }
    
    
    @Override
    public String toString() {
       return data.toString();
    }
    
    /*
     * 先序遍历  左根右
     */
    public void  mid(){
       if(this.getLeft()!=null) 
          this.getLeft().mid();
       
       System.out.println(this.toString());
       if(this.getRight()!=null)
           this.getRight().mid();
         
    }
    
    /*
     * 中序遍历 根左右
     */
    public void first(){
        System.out.println(this.toString());
        
        if(this.getLeft()!=null) 
            this.getLeft().first();
        if(this.getRight()!=null)
            this.getRight().first();
    }
    
    /*
     * 后序遍历 左右根
     */
    public void after(){
        if(this.getLeft()!=null) 
            this.getLeft().after();
        if(this.getRight()!=null)
            this.getRight().after();  
        System.out.println(this.toString());
    }
    
    public void createBinTree(T data){
        Node<T> node = new Node<T>();
        node.setData(data);
        node.setLeft(node);
        
        node.setRight(node);
    }

    @SuppressWarnings("unchecked")
    public int compareTo(Node<T> o) {
         if(this.data instanceof Comparable){
           return  ((Comparable<T>) this.data).compareTo(o.data);
         }
        return 0;
    }
    
    
    public boolean isLeafNode(){
           return this.left==null&&this.right==null;
    }
    
    public boolean isLeft(){
         return this.left!=null&&this.right==null;
    }
    
    public boolean isRight(){
        return this.right!=null&&this.left==null;
    }

    public boolean search(Node<T> key){
         if(this.compareTo(key)==0){
             System.out.println("查找到:"+key);
             return true;
         } else if (this.compareTo(key) > 0){
             if(this.getLeft()==null){
                 this.setLeft(key);
                 return false;
             }
             this.getLeft().search(key);
         }else if (this.compareTo(key) < 0){
             if(this.getRight()==null){
                 this.setRight(key);
                 return false;
             }
             this.getRight().search(key);
         }
         return false;
    }
    public boolean searchX(Node<T> key){
        if(this.compareTo(key)==0){
            System.out.println("查找到:"+key);
            return true;
        } else if (this.compareTo(key) > 0){
            if(this.getLeft()!=null){
                this.getLeft().search(key);
            }
           
        }else if (this.compareTo(key) < 0){
            if(this.getRight()!=null){
                this.getRight().search(key);
            }
            
        }
        return false;
   }
    
    public Status<T> searchV(Node<T> key){
              return null;
           }
    

    public Node<T> leftRotate(){
        Node<T> right =  this.getRight();
        this.setRight(right.getLeft());
        right.setLeft(this);
        return right;
    }
    
    public Node<T> rightRotate(){
        Node<T> left =   this.getLeft();
        this.setLeft(left.getRight());
        left.setRight(this);
        return left;
    }

    public Node<T> getParent() {
        return parent;
    }

    public void setParent(Node<T> parent) {
        this.parent = parent;
    }
   
}