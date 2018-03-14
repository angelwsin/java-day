package org.java.algorithm.tree;

import java.util.TreeSet;

/*
 * 赫夫曼树（最优树）
 */
public class HuffmanTree<T>  extends BinaryTree<HuffmanNode<T>>{
    
    
    
    public  void huffman(TreeSet<Node<HuffmanNode<T>>> set){
        this.root = huff(set);
       
    }
    
    private Node<HuffmanNode<T>>  huff(TreeSet<Node<HuffmanNode<T>>> set){
        if(set.size()==1){
            return set.pollFirst();
        }
        Node<HuffmanNode<T>> left = set.pollFirst();
        Node<HuffmanNode<T>> right = set.pollFirst();
        Node<HuffmanNode<T>> node = new Node<HuffmanNode<T>>();
        node.setLeft(left);
        node.setRight(right);
        HuffmanNode<T> huf = new HuffmanNode<T>();
        huf.setWeight(left.getData().getWeight()+right.getData().getWeight());
        node.setData(huf);
        set.add(node);
       return huff(set);    
    }
    
    public static void main(String[] args) {
        TreeSet<Node<HuffmanNode<String>>> set = new TreeSet<Node<HuffmanNode<String>>>();
        int[]  arrays = new int[]{7,5,2,4};
        for(int a :arrays){
            HuffmanNode<String> huf = new HuffmanNode<String>(); 
            huf.setWeight(a);
            Node<HuffmanNode<String>> node = new Node<HuffmanNode<String>>();
            node.setData(huf);
            set.add(node);
        }
        HuffmanTree<String> tree = new HuffmanTree<String>();
        System.out.println(set.toString());
        tree.root = tree.huff(set);
        tree.first();
        
    }

}