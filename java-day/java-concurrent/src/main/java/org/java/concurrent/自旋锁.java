package org.java.concurrent;

public class 自旋锁 {
	
	
	/**
	 * http://www.bubuko.com/infodetail-638815.html
	 * CLH锁 、MCS锁
	 * 
	 * 
	 * CLH(Craig, Landin, and Hagersten  locks): 是一个自旋锁，能确保无饥饿性，提供先来先服务的公平性。
	 * CLH锁也是一种基于链表的可扩展、高性能、公平的自旋锁，申请线程只在本地变量上自旋，它不断轮询前驱的状态，如果发现前驱释放了锁就结束自旋。
	 * 
	 * CLH锁即Craig, Landin, and Hagersten (CLH) locks，CLH锁是一个自旋锁，能确保无饥饿性，提供先来先服务的公平性。
	 * 何谓自旋锁？它是为实现保护共享资源而提出一种锁机制。其实，自旋锁与互斥锁比较类似，它们都是为了解决对某项资源的互斥使用。无论是互斥锁，还是自旋锁，
	 * 在任何时刻，最多只能有一个保持者，也就说，在任何时刻最多只能有一个执行单元获得锁。但是两者在调度机制上略有不同。对于互斥锁，如果资源已经被占用，
	 * 资源申请者只能进入睡眠状态。但是自旋锁不会引起调用者睡眠，如果自旋锁已经被别的执行单元保持，调用者就一直循环在那里看是否该自旋锁的保持者已经释放了锁，"自旋"一词就是因此而得名。

	 * 
	 * https://www.ibm.com/developerworks/cn/linux/l-cn-spinlock_mips/index.html
	 * 
	 */

}
