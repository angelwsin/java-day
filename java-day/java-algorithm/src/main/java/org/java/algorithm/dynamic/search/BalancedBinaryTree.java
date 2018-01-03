package org.java.algorithm.dynamic.search;

import java.util.ArrayList;
import java.util.List;

import org.java.algorithm.tree.Node;
import org.java.algorithm.tree.NodeType;

/*
 * 平衡二叉树
 * 它的左子树和右子树都是平衡二叉树且左子树和右子树的深度之差绝对值不超过1
 * 
 * logn
 * 平衡二叉树的调整
 * 二叉排序树插入节点失去平衡的的最小树根节点记为 n
 * 1)单向右旋： n左子树根节点的左子树插入,n的平衡因子1->2 向右顺时针旋转
 * 2)单向左旋：n右子树根节点的右子树插入,n的平衡因子-1->-2 向左逆时针旋转
 * 3)先左后右: n左子树根节点的右子树插入,n的平衡因子1->2 
 * 4)先右后左: n右子树根节点的左子树插入,n的平衡因子-1->-2
 */
public class BalancedBinaryTree<T> extends BinarySortTree<T>{
    
    
    
    public static void main(String[] args) {
        BalancedBinaryTree<Integer> tree = new BalancedBinaryTree<Integer>();
        List<Integer> list = new ArrayList<Integer>();
        list.add(13);
        list.add(24);
        list.add(37);
        list.add(90);
        list.add(53);
        for(Integer node : list){
            tree.search(node);
           
            //tree.searchV(node);
        }
        tree.mid();
        System.out.println(tree.root);
    }
   
    /**
     * 平衡二叉排序树BBST插入一个新元素的递归算法
     * 一)空树，直接插入成为根节点，深度加1
     * 二)e的关键字和根节点相同不插入
     * 三)若e的关键字小于根节点并且左子树不存在此关键字，插入后左子树深度加1，插入分一下情况:
     * 1)BBST根节点平衡因子为-1(右>左):根节点平衡因子改为0，深度不变
     * 2)BBST根节点平衡因子为0(左=右):根节点平衡因子改为1，树深度加1
     * 3)BBST根节点平衡因子为1(左>右):若左子树根节点平衡因子1:单向右旋，旋转后将根节点和左子树平衡因子改为0，深度不变；
     *                         若左子树根节点平衡因子-1:先左(左子树根节点)后右，旋转后将根节点和左子树平衡因子，深度不变；
     *  四)若e的关键字大于根节点并且右子树不存在此关键字，插入后右子树深度加1，插入分一下情况:
     * 1)BBST根节点平衡因子为1(右<左):根节点平衡因子改为0，深度不变
     * 2)BBST根节点平衡因子为0(左=右):根节点平衡因子改为-1，树深度加1
     * 3)BBST根节点平衡因子为-1(左<右):若右子树根节点平衡因子-1:单向左旋，旋转后将根节点和左子树平衡因子改为0，深度不变；
     *                          若右子树根节点平衡因子1:先右(右子树根节点)后左，旋转后将根节点和左子树平衡因子，深度不变；
     * 
     * 
     * 
     */
    public void insert(Node<T> key){
         key =(BSTNode<T>) key;
        SearchStatus<T> local = search1(key);
        BSTNode<T> node = (BSTNode<T>) local.getFail();
        BSTNode<T> success = (BSTNode<T>) local.getSucess();
        if(node!=null&&success==null){
            this.root = local.getRoot();
            
         /*  if(node.compareTo(key)>0){
                node.setLeft(key);
                 node.setBf(1);
                insertLeft(node);
            }else if(node.compareTo(key)<0){
                node.setRight(key);
                node.setBf(-1);
                insertRight(node);
                
            }*/
            
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
    
    //没有指针的概念 真不爽
    @Override
    public  SearchStatus<T> search(Node<T> node,Node<T> key,SearchStatus<T> local){
        
        if (node == null) {
            local.setExist(false);
            if (local.getFail() == null) {
                node = key;
                return local;
            } else {
                if (local.getNodeType() == NodeType.Left) {
                    local.getFail().setLeft(key);
                } else if (local.getNodeType() == NodeType.Right) {
                    local.getFail().setRight(key);
                }
            }

            return local;
        }
        node.setParent(local.getParent());
        local.setParent(node);
        if (node.compareTo(key) == 0) {
            local.setSucess(node);
            return local;
        } else if (node.compareTo(key) > 0) {
            local.setFail(node);
            local.setNodeType(NodeType.Left);
            
           SearchStatus<T> localx =search(node.getLeft(), key, local);
            if(localx.isExist()) return localx;
            Balance<T> bal= insertLeft(node);
            localx.setRoot(bal.getNode());
            if(BalanceType.leftAndRight==bal.getType())
                node.getParent().setLeft(localx.getRoot());
            return localx;
        } else {
            local.setFail(node);
            local.setNodeType(NodeType.Right);
            SearchStatus<T> localx = search(node.getRight(), key, local);
            if(localx.isExist()) return localx;
            Balance<T> bal= insertRight(node);
            localx.setRoot(bal.getNode());
            if(BalanceType.rightAndLeft==bal.getType())
                node.getParent().setRight(localx.getRoot());
            return localx;
        }
        
    }
     public  void searchV(T data){
         BSTNode<T> key = new BSTNode<T>();
         key.setData(data);
        if(this.root==null){ this.root = key; return;}
        this.root.search(key);
        
    }
     
    
    @Override
    public void search(T data) {
        BSTNode<T> key = new BSTNode<T>();
        key.setData(data);
        insert(key);
    }
    
    public Node<T> leftRotate(Node<T> node){
        Node<T> right =  node.getRight();
        node.setRight(right.getLeft());
        right.setLeft(node);
       return  right;
    }
    
    public Node<T> rightRotate(Node<T> node){
        Node<T> left =   node.getLeft();
        node.setLeft(left.getRight());
        left.setRight(node);
        return  left;
    }
    
    private Balance<T>  insertLeft(Node<T> node) {
        Balance<T> bal = new Balance<T>();
        BSTNode<T> root = (BSTNode<T>) node;
        switch (root.getBf()) {
            case 0: {
                root.setBf(1);
                break;
            }
            case 1: {
                BSTNode<T> left = (BSTNode<T>) root.getLeft();
                if (left.getBf() == 1) {
                    node = rightRotate(node);
                    root.setBf(0);
                    left.setBf(0);
                    bal.setType(BalanceType.right);
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
                    node.setLeft(leftRotate(node.getLeft()));
                    node= rightRotate(node);
                    bal.setType(BalanceType.leftAndRight);
                }
                break;
            }
            case -1: {
                root.setBf(0);
                break;
            }

        }
        bal.setNode(node);
        return bal;
    }

    private Balance<T>  insertRight(Node<T> node) {
        Balance<T> bal = new Balance<T>();
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
                    node = leftRotate(node);
                    root.setBf(0);
                    right.setBf(0);
                    bal.setType(BalanceType.left);
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
                    node.setRight(rightRotate(node.getRight()));
                    node = leftRotate(node);
                    bal.setType(BalanceType.rightAndLeft);
                }
                break;

            }

        }
        bal.setNode(node);
        return bal;
    }
    
 public  Node<T> search(Node<T>parent,Node<T> node,Node<T> key){
       
        if(node==null) return node;
        
         node.setParent(parent);
        if (node.compareTo(key) == 0) {
           return node;
        } else if (node.compareTo(key) > 0) {
           return search(node, node.getLeft(), key);
        } else {
           return search(node, node.getRight(), key);
        }
    }

}
