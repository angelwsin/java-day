package org.java.concurrent.lock;


//当两个线程进行竞争的时候，总有一个牺牲品（较晚对victim赋值的线程），因此可以避免死锁。
//但是，当没有竞争的时候就杯具了，如果只有一个线程想进入临界区，那么牺牲品一直是自己，直到等待别人来替换自己才行。

//LockTwo有竞争的时候运行的非常好
public class LockTwo implements Lock{
	
	private volatile long  flag ;

	@Override
	public void lock() {
		long i =  Thread.currentThread().getId();
		flag = i;//让别人先走，暂时牺牲自己
		while(flag==i);
		
	}

	@Override
	public void unlock() {
		// TODO Auto-generated method stub
		
	}
	
	
	public static void main(String[] args) {
		
	}

}
