package org.java.concurrent.lock;


/**
 * 安全性，活性
 * 互斥
 * 死锁
 * 饥饿（公平性）
 * @author Administrator
 * 
 * 公平性 
 *  1)门廊区
 *  2)等待区
 *
 */
public interface Lock {
	
	public void lock();
	
	public void unlock();

}
