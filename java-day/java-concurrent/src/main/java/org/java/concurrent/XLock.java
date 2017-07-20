package org.java.concurrent;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

public class XLock implements Lock{
    
    private Sync sync ;
     public XLock(){
         sync = new Sync(1);
     }
    
    /**
     * 
     * @author Administrator
     *自旋锁的变体 The wait queue is a variant of a "CLH" (Craig, Landin, and
     * Hagersten) lock queue
     * 
     * AbstractQueuedSynchronizer 维持一个双向队列
     * 每次 只拿 头结点 执行
     * 其他结点 放在 tail尾部
     * 
     * State 标识锁的状态
     */

    private class Sync extends AbstractQueuedSynchronizer {

        public Sync(int stat) {
            setState(stat);
        }

        @Override
        protected boolean tryAcquire(int arg) {
            int stat = getState();
            return compareAndSetState(stat, arg);
        }

        @Override
        protected boolean tryRelease(int arg) {
            int stat = getState();
            return compareAndSetState(stat, arg);
        }
    }

    public void lock() {
        sync.acquire(0);
    }

    public void lockInterruptibly() throws InterruptedException {
        // TODO Auto-generated method stub

    }

    public boolean tryLock() {
        return false;
    }

    public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
        // TODO Auto-generated method stub
        return false;
    }

    public void unlock() {
       sync.release(1);

    }

    //Condition 上维持一个阻塞队列
    public Condition newCondition() {
        // TODO Auto-generated method stub
        return null;
    }

}
