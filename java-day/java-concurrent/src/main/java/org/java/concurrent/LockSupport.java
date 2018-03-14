package org.java.concurrent;

public class LockSupport {

	
    public static void main(String[] args) {
		 //LockSupport
    	
    	java.util.concurrent.locks.LockSupport.park();
    	//This object is recorded while
    	 //* the thread is blocked to permit monitoring and diagnostic tools to
    	// * identify the reasons that threads are blocked
    	//这个对象是用来记录线程被阻塞时被谁阻塞的。用于线程监控和分析工具来定位原因的
    	java.util.concurrent.locks.LockSupport.park(new LockSupport());
    	
    	java.util.concurrent.locks.LockSupport.unpark(Thread.currentThread());
	}
}
