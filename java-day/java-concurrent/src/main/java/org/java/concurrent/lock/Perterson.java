package org.java.concurrent.lock;

//LockOne类适合没有竞争的场景，LockTwo类适合有竞争的场景。
//那么将LockOne类和LockTwo类结合起来，就可以构造出一种很好的锁算法。该算法无疑是最简洁、最完美的双线程互斥算法，按照其发明者的名字被命名为“Peterson算法”
public class Perterson implements Lock{
	
	private boolean[] flags  = new boolean[2];
	
	private volatile long  flag ;

	@Override
	public void lock() {
		int i = (int) Thread.currentThread().getId();
		int j = 1-i;
		flags[i] = true;
		flag = i;
		while(flags[j]&&flag==i);
		
	}

	@Override
	public void unlock() {
		int i = (int) Thread.currentThread().getId();
		flags[i] = false;
	}

}
