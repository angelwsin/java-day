package org.java.algorithm.dynamic.search;

import org.java.algorithm.tree.Node;

public class BSTNode<T> extends Node<T>{
    
    //平衡因子
    private int       bf;

    public int getBf() {
        return bf;
    }

    public void setBf(int bf) {
        this.bf = bf;
    }
    
    @Override
    public String toString() {
        return super.toString()+",bf="+bf;
    }

    public boolean search(Node<T> key){
        int x = this.compareTo(key);
        if(x==0){
            System.out.println("查找到:"+key);
            return true; 
        }else if(x>0){
            if(this.getLeft()==null){
                this.setLeft(key);
                return false;
            }  
        }else if(x<0){
            if(this.getRight()==null){
                this.setRight(key);
                return false;
            }  
        }
        boolean deep = true;
        if(x>0){
             deep = this.getLeft().search(key);
            if(!deep){
              //  insertLeft(this);  
            }
        }else if(x<0){
             deep =  this.getRight().search(key);
            if(!deep){
               // insertRight(this);
            }  
        }
        
        return deep;
   }
    
  
    
    private void insertLeft(Node<T> node) {
        BSTNode<T> root = (BSTNode<T>) node;
        switch (root.getBf()) {
            case 0: {
                root.setBf(1);
                break;
            }
            case 1: {
                BSTNode<T> left = (BSTNode<T>) node.getLeft();
                if (left.getBf() == 1) {
                    node = node.rightRotate();
                    root.setBf(0);
                    left.setBf(0);
                } else if (left.getBf() == -1) {
                    BSTNode<T> rd = (BSTNode<T>) left.getRight();
                    switch (rd.getBf()) {
                        case 0:
                            root.setBf(0);
                            left.setBf(0);
                            break;
                        case 1:
                            root.setBf(-1);
                            left.setBf(0);
                            break;
                        case -1:
                            root.setBf(0);
                            left.setBf(1);
                            break;

                    }
                    rd.setBf(0);
                    node.setLeft(node.getLeft().leftRotate());
                    node= node.rightRotate();
                }
                break;
            }
            case -1: {
                root.setBf(0);
                break;
            }

        }
    }

    private void insertRight(Node<T> node) {
        BSTNode<T> root = (BSTNode<T>) node;
        switch (root.getBf()) {
            case 0: {
                root.setBf(-1);
                break;
            }
            case 1: {
                root.setBf(0);
                break;
            }
            case -1: {

                BSTNode<T> right = (BSTNode<T>) root.getRight();
                if (right.getBf() == -1) {
                    node.leftRotate();
                    root.setBf(0);
                    right.setBf(0);
                } else if (right.getBf() == 1) {
                    BSTNode<T> rd = (BSTNode<T>) right.getLeft();
                    switch (rd.getBf()) {
                        case 0:
                            root.setBf(0);
                            right.setBf(0);
                            break;
                        case 1:
                            root.setBf(-1);
                            right.setBf(0);
                            break;
                        case -1:
                            root.setBf(0);
                            right.setBf(-1);
                            break;

                    }
                    rd.setBf(0);
                    node.setRight(node.getRight().rightRotate());
                    node.leftRotate();
                }
                break;

            }

        }
    }
    
}
