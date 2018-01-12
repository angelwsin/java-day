package org.java.concurrent.lock;


//多线程锁 
//该算法采用面包店里发号机的一种分布式版本来保证先来先服务特性：每个线程在门廊区得到一个序号，然后一直等待，直到再没有序号比自己更早的线程尝试进入临界区为止。
public class Bakery implements Lock{

	@Override
	public void lock() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void unlock() {
		// TODO Auto-generated method stub
		
	}

}
