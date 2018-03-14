package org.java.concurrent.blocking.queue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class BlockingQueueX {
	
	
	 //BlockingQueue  模型  生产者-消费者模式
	

	 
	
	/*
	 * 有界的
	 * ArrayBlockingQueue典型的是 缓存buffer  持有一把锁ReentrantLock 连个等待条件notEmpty，notFull
	 * 
	 * 无界的：
	 * LinkedBlockingQueue  也可以指定     持有两把锁 two lock queue
	 * 优先级:
	 * PriorityBlockingQueue
	 * 同步队列: in which each insert operation must wait for a corresponding remove operation by another thread
	 * SynchronousQueue       http://blog.csdn.net/mrwangwang/article/details/20526785
	 * 延时队列： DelayQueue  底层使用PriorityBlockingQueue
	 * 
	 */

	 
	 ArrayBlockingQueue<Integer> mx = new ArrayBlockingQueue<>(5) ;
	 
	 
	 
	static public class ArrayBlockingQueueVsLinkedBlockingQueue {  
		  //队列最大容量  
		  public static final int Q_SIZE = 1024000;  
		  //生产者/消费者线程数  
		  public static final int THREAD_NUM = 4;  
		    
		  //产品  
		  class Product{  
		      String name;  
		      Product(String name){  
		          this.name = name;  
		      }  
		  }  
		  public void test(final BlockingQueue<Product> q) throws InterruptedException{  
		      //生产者线程  
		      class Producer implements Runnable{  
		          @Override  
		          public void run() {  
		              for(int i=0;i<Q_SIZE*10;i++){  
		                  try {  
		                      q.put(new Product("Lee"));  
		                  } catch (InterruptedException e) {  
		                      e.printStackTrace();  
		                  }  
		              }  
		          }  
		            
		      };  
		      //消费者线程  
		      class Consumer implements Runnable{  
		          @Override  
		          public void run(){  
		              for(int i=0;i<Q_SIZE*10;i++){  
		                  try {  
		                      q.take();  
		                  } catch (InterruptedException e) {  
		                      // TODO Auto-generated catch block  
		                      e.printStackTrace();  
		                  }  
		              }  
		          }  
		      };  
		      //创建生产者  
		      Thread[] arrProducerThread = new Thread[THREAD_NUM];  
		      for(int i=0;i<THREAD_NUM;i++){  
		          arrProducerThread[i] = new Thread(new Producer());  
		      }  
		      //创建消费者  
		      Thread[] arrConsumerThread = new Thread[THREAD_NUM];  
		      for(int i=0;i<THREAD_NUM;i++){  
		          arrConsumerThread[i] = new Thread(new Consumer());  
		      }  
		      //go!  
		      long t1 = System.currentTimeMillis();  
		      for(int i=0;i<THREAD_NUM;i++){  
		          arrProducerThread[i].start();  
		          arrConsumerThread[i].start();  
		      }  
		      for(int i=0;i<THREAD_NUM;i++){  
		          arrProducerThread[i].join();  
		          arrConsumerThread[i].join();  
		      }  
		      long t2 = System.currentTimeMillis();  
		      System.out.println(q.getClass().getSimpleName() + " cost : " + (t2-t1));  
		  }  
		  public static void main(String[] args) throws InterruptedException{  
			  //System.out.println(Runtime.getRuntime().availableProcessors());
		      final BlockingQueue<Product> q1 = new LinkedBlockingQueue<Product>(Q_SIZE);  
		      final BlockingQueue<Product> q2 = new ArrayBlockingQueue<Product>(Q_SIZE);  
		      new ArrayBlockingQueueVsLinkedBlockingQueue().test(q2);  
		      new ArrayBlockingQueueVsLinkedBlockingQueue().test(q1);  
		      
		  }  
		}  

	 
}



