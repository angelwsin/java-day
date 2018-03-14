package org.java.algorithm.tree;

public class HuffmanNode<T> implements Comparable<HuffmanNode<T>>{
    
    private int weight;
    
    private T   data;

    public int getWeight() {
        return weight;
    }



    public void setWeight(int weight) {
        this.weight = weight;
    }



    public int compareTo(HuffmanNode<T> o) {
        return this.weight-o.weight;
    }



    public T getData() {
        return data;
    }



    public void setData(T data) {
        this.data = data;
    }
    
    @Override
    public String toString() {
        return this.weight+"";
    }

}
