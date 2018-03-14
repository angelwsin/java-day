package org.java.algorithm.dynamic.search;

import java.util.ArrayList;
import java.util.List;

import org.java.algorithm.tree.BinaryTree;
import org.java.algorithm.tree.Node;
import org.java.algorithm.tree.NodeType;


/*
 * BinarySortTree
 * 二叉排序树（二叉查找树）
 * 或者是一颗空树，具有以下性质的树
 * 1）若它的左子树不空，则左子树所有结点的值均小于它的根结点的值
 * 2）若它的右子树不空，则右子树所有结点的值均大于它的根结点的值
 * 3）它的左、右子树也是二叉排序树
 * 
 *查找的复杂度和 给定的数的序列有关  进行优化 平衡二叉树
 */
public class BinarySortTree<T> extends BinaryTree<T>{
    
    
    public static void main(String[] args) {
        BinarySortTree<Integer> tree = new BinarySortTree<Integer>();
        List<Integer> list = new ArrayList<Integer>();
        list.add(45);
        list.add(24);
        list.add(53);
        list.add(12);
        list.add(13);
        list.add(37);
        list.add(93);
        for(Integer node : list){
            tree.search(node);
        }
        tree.mid();
        
        tree.delete(24);
        tree.mid();
              
    }
    
    
    
    
    public Node<T> search(Node<T> key){
        return search(this.root, key);
    }
    
    private  Node<T> search(Node<T> node,Node<T> key){
        if(node==null)return null;
        if(node.compareTo(key)==0){
           return node;
        }else if(node.compareTo(key)>0){
          return  search(node.getLeft(),key);
        }else{
         return  search(node.getRight(),key); 
        }
        
        
    }
    /**
     * 
     * 
     * @param node
     * @param key
     * @return
     */
    public  SearchStatus<T> search(Node<T> node,Node<T> key,SearchStatus<T> local){
        
        if(node==null)return local;
        if(node.compareTo(key)==0){
            local.setSucess(node);
           return local;
        }else if(node.compareTo(key)>0){
            local.setFail(node);
            local.setNodeType(NodeType.Left);
          return search(node.getLeft(),key,local);
        }else{
            local.setFail(node);
            local.setNodeType(NodeType.Right);
         return  search(node.getRight(),key,local) ;
        }
        
        
    }
    
    
    public void insert(Node<T> key){
        SearchStatus<T> local = search1(key);
        Node<T> node = local.getFail();
        Node<T> success = local.getSucess();
        if(node!=null&&success==null){
            if(node.compareTo(key)>0){
                node.setLeft(key);
            }else if(node.compareTo(key)<0){
                node.setRight(key);
            }
        }else {
            if(success!=null){
                String pre =  node==null?"无":node.toString();
                System.out.println("查找到:"+local.getNodeType().name()+","+success.toString()+",双亲节点:"+pre);   
            }else {
                if(this.root==null)
                    this.root = key; 
            }
           
        }
    }
    
    public  SearchStatus<T> search1(Node<T> key){
       return  search(this.root, key, new SearchStatus<T>());
    }
    
    public void search(T data){
        Node<T> key = new Node<T>();
        key.setData(data);
        insert(key);
    }
    
    /*
     * 1)删除的节点是叶子节点直接删除
     * 2)删除的节点只有左子树或右子树 ，左子树（或右子树）直接成为删除节点双亲的左子树
     * 3)(中序)删除节点左右节点都有，两种方案:1.删除节点的左子树直接代替删除节点链接到删除节点的双亲上，右子树为删除节点的前驱节点的右子树
     *                        2.删除节点的前驱节点直接代替删除节点链接到删除节点的双亲上，删除节点的前驱节点的左子树成为删除节点的前驱节点的双亲节点的右子树
     */
    public void delete(T data){
        Node<T> key = new Node<T>();
        key.setData(data);
        SearchStatus<T> local = search1(key);
        Node<T> node = local.getFail();
        Node<T> success = local.getSucess();
        if(success==null){
            System.out.println("未找到");
            return;   
        }
           
        if(success!=null&&node==null){
            this.root = null;
            return ;
        }
        //叶子节点
        if(success.isLeafNode()){
         if(local.getNodeType()==NodeType.Left){
             node.setLeft(null);
         }else{
             node.setRight(null); 
         }
         
        }  //只有左子树或右子树
        else if(success.isLeft()){
             node.setLeft(success.getLeft());
            
        }else if(success.isRight()){
             node.setLeft(success.getRight());
        }else{
            
            //方案一
            fangAn1(node,success);
            //方案二
            //fangAn2(node,success,local.getNodeType());
        }
        success = null;
        
    }
    
    
    private void fangAn1(Node<T> node,Node<T> success){
        node.setLeft(success.getLeft());
        //左子树往右走
        Node<T> left = success.getLeft();
        Node<T> pre = left;
        while(left.getRight()!=null){
               pre = left;
               left = left.getRight();
        }
        pre.setRight(success.getRight());
    }
    
    private void fangAn2(Node<T> node,Node<T> success,NodeType nodeType){
        //左子树往右走
        Node<T> left = success.getLeft();
        Node<T> pre = left;
        while(left.getRight()!=null&&left.getRight().getRight()==null){
               pre = left;
               left = left.getRight();
        }
      if(nodeType==NodeType.Left){
          node.setLeft(pre.getRight());
      }else{
         node.setRight(pre.getRight()); 
      }
      Node<T> q = pre.getRight().getLeft();
      pre.getRight().setLeft(success.getLeft());
      pre.getRight().setRight(success.getRight());   
      pre.setRight(q);      
 
      
    }

    
    
}
