package org.java.concurrent.lock;
//LockOne 没有竞争的时候很好的运行
public class LockOne implements Lock{
	
	private boolean[] flags  = new boolean[2];

	@Override
	public void lock() {
		
		int i = (int) Thread.currentThread().getId();
		int j = 1-i;
		flags[i] = true;
		while(flags[j]);
		
	}

	@Override
	public void unlock() {
		int i = (int) Thread.currentThread().getId();
		flags[i] = false;
		
	}

	
	public static void main(String[] args) {
		//并发时会产生死锁  flags[i] = true; 都为true
	}
	

}
