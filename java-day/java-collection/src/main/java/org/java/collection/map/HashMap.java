package org.java.collection.map;

public class HashMap {
	
	/**
	 * hashMap解决冲突
	 * 
	 * 1.链表法
	 * 2.开放地址
	 *
	 *
	 *
	 * https://www.cnblogs.com/chinajava/p/5808416.html
	 *
	 *为了防止hash方法设计的不合理 当bin(箱)的深度过大时 链表切换为Tree结构
	 *
	 * java 的hash链表插入使用尾插法    hash扩容问题再hash
	 * redis 使用头插发 速度快 插后查找快  redis 分配是是一个二维数组每次只迁移一个箱子里的链表
	 *
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
