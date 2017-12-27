package org.java.concurrent;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

public class CLHLock implements Lock{
	
	private final AtomicReference<QNode> tail = new AtomicReference<CLHLock.QNode>(new QNode());
	
	private final ThreadLocal<QNode>  pre;
	
	private final ThreadLocal<QNode>  Qnode;

	
	/*当一个线程需要获取锁时：

	1.创建一个的QNode，将其中的locked设置为true表示需要获取锁

	2.线程对tail域调用getAndSet方法，使自己成为队列的尾部，同时获取一个指向其前趋结点的引用myPred

	3.该线程就在前趋结点的locked字段上旋转，直到前趋结点释放锁

	4.当一个线程需要释放锁时，将当前结点的locked域设置为false，同时回收前趋结点
	*/
	
	
	public CLHLock() {
		Qnode = new ThreadLocal<QNode>(){
			protected QNode initialValue() {
				return new QNode();
			};
		};
		
		pre  = new ThreadLocal<>();
		
	}

	@Override
	public void lock() {
		QNode node = Qnode.get();
		//在申请
		node.locked = true;
		QNode Qpre = tail.getAndSet(node);
		pre.set(Qpre);
		//自旋检测前驱节点的状态
		while(Qpre.locked);
		
	}

	@Override
	public void lockInterruptibly() throws InterruptedException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean tryLock() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void unlock() {
		QNode node = Qnode.get();
		//释放
		node.locked = false;
		//同时回收前趋结点，重复利用节点
		Qnode.set(pre.get());
		
	}

	@Override
	public Condition newCondition() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	static class QNode{
		volatile boolean locked;
	}
	
	
	public static void main(String[] args) {
		CLHLock lock = new CLHLock();
		int i =0;
		lock.lock();
		i++;
		lock.unlock();
		System.out.println(i);
		
		lock.lock();
		i++;
		lock.unlock();
		System.out.println(i);
	}

}
