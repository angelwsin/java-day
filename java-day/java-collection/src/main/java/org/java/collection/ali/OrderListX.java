package org.java.collection.ali;

import java.util.ArrayList;

public class OrderListX {
	
	

	private final ArrayList<Integer>  elements;
	
	private final int  maxSize;

	//读多写少 有序 
	// 二元组 位置和数据
	public OrderListX(int maxSize) {
		elements = new ArrayList<>(maxSize);
		this.maxSize = maxSize;
	}
	
	public void add(int e){
		synchronized (elements) {
			
		}
		
	}

}
