package org.java.concurrent;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class Deueue {
	
	public static void main(String[] args) {
		
		//阻塞队列的类型  以及加锁问题
		
		//加锁
		//坏处 移除操作需要整理
		ArrayBlockingQueue<Runnable>  arrays = new ArrayBlockingQueue<>(10);
		
		//http://blog.csdn.net/fei0724/article/details/30072057
		//两个锁队列 算法的变体
		LinkedBlockingQueue<Runnable> linked = new LinkedBlockingQueue<>();
	}

}
