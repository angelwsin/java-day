package org.java.thread;

import java.lang.reflect.Field;

//http://jm.taobao.org/2013/11/04/analysis-of-a-deadlock-caused-by-an-interrupt/
//http://jm.taobao.org/%2F2013%2F10%2F30%2F1719%2F
public class ThreadX {

	
	public static void main(String[] args) throws Exception{
		Thread h = new Thread(()->{
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("xxxxx");
		});
		h.start();
		Field field = h.getClass().getDeclaredField("eetop");
		field.setAccessible(true);
		Thread.sleep(1000);
		System.out.println(field.get(h));
	}
}
