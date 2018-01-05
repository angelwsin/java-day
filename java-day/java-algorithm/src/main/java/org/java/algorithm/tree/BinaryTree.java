package org.java.algorithm.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


/*B树：二叉树，每个结点只存储一个关键字，等于则命中，小于走左结点，大于走右结点；

B-树：多路搜索树，每个结点存储M/2到M个关键字，非叶子结点存储指向关键字范围的子结点；

所有关键字在整颗树中出现，且只出现一次，非叶子结点可以命中；

B+树：在B-树基础上，为叶子结点增加链表指针，所有关键字都在叶子结点中出现，非叶子结点作为叶子结点的索引；B+树总是到叶子结点才命中；

B*树：在B+树基础上，为非叶子结点也增加链表指针，将结点的最低利用率从1/2提高到2/3*/

// 折半查找   log2^n 关键字大小有序排列
//分析折半查找 二分查找树
//二叉树查找    因为不同的排序得到的效率不一样最坏为n
//进入平衡二叉树    使效率提高 但是 删除，插入频繁
//红黑树
//多路查找树
// B树  B-  B+
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
