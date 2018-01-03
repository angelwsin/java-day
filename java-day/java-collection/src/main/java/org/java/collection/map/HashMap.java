package org.java.collection.map;

public class HashMap {
	
	/**
	 * hashMap解决冲突
	 * 
	 * 1.链表法
	 * 2.开放地址
	 */
	
	public static void main(String[] args) {
		int[]  s = new int[]{2,5,6,10,28,48,29,12,38,56};
		int sum = 7;
		int[]  y = new int[s.length];
		for(int i=0;i<s.length;i++){
			y[i] = sum-s[i];
		}
		
	}

}
