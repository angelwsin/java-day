package org.java.concurrent.future;

public class FutureX {
	
	public static void main(String[] args) {
		
		//Future 的生命周期
		/*Possible state transitions:
		     * NEW -> COMPLETING -> NORMAL
		     * NEW -> COMPLETING -> EXCEPTIONAL
		     * NEW -> CANCELLED
		     * NEW -> INTERRUPTING -> INTERRUPTED
		     
		    private volatile int state;
		    private static final int NEW          = 0;
		    private static final int COMPLETING   = 1;
		    private static final int NORMAL       = 2;
		    private static final int EXCEPTIONAL  = 3;
		    private static final int CANCELLED    = 4;
		    private static final int INTERRUPTING = 5;
		    private static final int INTERRUPTED  = 6;
		    
		    */
		
		
		//所有的 get()请求会阻塞在waiters 链表 上 等待  CANCELLED
		//正常终止，异常，取消
	}

}
