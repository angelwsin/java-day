package org.java.concurrent;


/**
 * 哲学家进餐问题
 * @author Administrator
 * 
 * 五双筷子
 *
 */
public class DinningPhilosophers {
	
	
	public static void main(String[] args) {
	
	     Object[] kai = new Object[]{new Object(),new Object(),new Object(),new Object(),new Object()};
		
		  for(int i=1;i<=5;i++){
		     new Thread(new Philosophers(i, kai), "哲学家"+i).start();
		  }
		
	}
	
	
	
	static class Philosophers implements Runnable{
		
		private int  n ;
		
		private Object  left;
		
		private Object  right;
		
		

		public Philosophers(int n,Object[] kai) {
			this.n = n;
			this.left = n==1?kai[kai.length-1]:kai[n-2];
			this.right = kai[n-1];
		}






		@Override
		public void run() {
		    while (true) {
				synchronized (left) {

				synchronized (right) {
					System.out.println(String.format("%d哲学家进餐了", n));
					try {
						Thread.sleep(10000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					System.out.println(String.format("%d哲学家进餐结束", n));

				}
				
			}
			System.out.println(String.format("%d哲学家思考", n));
				
			}
			
			
		}
		
		
	}
	
	



}
