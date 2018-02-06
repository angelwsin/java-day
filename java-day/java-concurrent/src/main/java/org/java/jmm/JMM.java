package org.java.jmm;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.locks.ReentrantLock;

//http://www.cs.umd.edu/~pugh/java/memoryModel/jsr-133-faq.html
//https://jcp.org/en/jsr/detail?id=379

//JDK1.6之后，对synchronized优化，根据不同情形出现了偏向锁、轻量锁、自旋锁，重量级锁 
public class JMM {
	
	//reordering -- jmm(阻止 ，happen before)------硬件(内存屏障)
	
	//Java includes several language constructs, including volatile, final, and synchronized
	
	//c 栈 https://www.cnblogs.com/findumars/p/7545818.html
	//内存屏障/栅栏(fence)  http://www.rdrop.com/users/paulmck/scalability/paper/whymb.2009.04.05a.pdf
	//https://www.jianshu.com/p/2ab5e3d7e510
	//内存屏障只与内存模型中描述的“获取”和“释放”等高级概念间接相关。 内存屏障本身并不是“同步屏障”
	//内存屏障指令直接控制CPU与其缓存之间的交互，其写入缓冲区包含等待刷新到内存的存储区和/或等待装载或推测性执行指令的缓冲区,这些影响可能会导致高速缓存，主内存和其他处理器之间的进一步交互
	
	/*硬件层的内存屏障分为两种：Load Barrier 和 Store Barrier即读屏障和写屏障。
	内存屏障有两个作用：
	阻止屏障两侧的指令重排序；
	强制把写缓冲区/高速缓存中的脏数据等写回主内存，让缓存中相应的数据失效。*/
	
	 //1)reordering  优化 as the compiler, the JIT, and the cache
	
	//2)正确的同步 incorrectly synchronized
	
	//3)synchronization do    happen before 用来阐述  When one action happens before another, the first is guaranteed to be ordered before and visible to the second
	/*The new memory model semantics create a partial ordering on memory operations (read field, write field, lock, unlock) and other thread operations (start and join), where some actions are said to happen before other operations. When one action happens before another, the first is guaranteed to be ordered before and visible to the second. The rules of this ordering are as follows:

		1)Each action in a thread happens before every action in that thread that comes later in the program's order.
		2)An unlock on a monitor happens before every subsequent lock on that same monitor.
		3)A write to a volatile field happens before every subsequent read of that same volatile.
		4)A call to start() on a thread happens before any actions in the started thread.
		5)All actions in a thread happen before any other thread successfully returns from a join() on that thread.
		*/
	
	//4)final fields  不变对象 和对象逃逸
	
	//5)volatile do    volatile变量，远超过volatile变量的意义，对volatile的写可见，对volatile的读也可见
	
	//6)"double-checked locking" problem
	// double-checked-locking - don't do this!

	/*private static Something instance = null;

	public Something getInstance() {
	  if (instance == null) {
	    synchronized (this) {
	      if (instance == null)
	        instance = new Something();
	    }
	  }
	  return instance;
	}*/
	   //这看起来非常聪明 - 在通用代码路径上避免了同步。 只有一个问题 - 它不起作用。 为什么不？ 最明显的原因是，初始化实例和写入实例字段的写入操作可以由编译器或缓存重新排序，这会产生返回看起来是部分构造的东西的效果。 结果是我们读取一个未初始化的对象。
	//使用volatile关键字可以消除尝试使用双重检查锁定模式时出现的问题,在新的内存模型下，使实例字段变为volatile将会“修复”带有双重检查的锁定的问题，因为那么在构造线程的Something的初始化和它的值的返回之间将会有一个Before-Before关系 读取它的线程。
	
	
	/*
	 * 内存屏障
	 * 
	 * 1)LoadLoad Barriers
	 *   Load1; LoadLoad; Load2
	 * 
	 * 2)StoreStore Barriers
	 *   Store1; StoreStore; Store2
	 *    Store1's data are visible to other processors (i.e., flushed to memory)
	 * 3)LoadStore Barriers
	 *   Load1; LoadStore; Store2
	 * 
	 * 4)StoreLoad Barriers
	 *   Store1; StoreLoad; Load2
	 *    ensures that Store1's data are made visible to other processors (i.e., flushed to main memory)
	 * 
	 * 
	 * 
	 * volatile 内存屏障的支持
	 * final    内存屏障的支持  final-field rule requiring a StoreStore barrier 
	 * 
	 * 
	 * 
	 * 
	 * jmm  http://ifeve.com/java-memory-model-1/
	 * 
	 * 
	 *  
	 *        happen-before  程序员 层
	 *        
	 *        
	 *        Memory Barriers   jmm层
	 *        
	 *        
	 *        reordering        编译器，处理器，runtime等
	 * 
	 * 
	 * 
	 * 重排序
	 * 1，数据依赖性   单线程，多线程都不支持重排序 
	 * 2，as-if-serial语义  保证单线程的执行结果正确 不对数据依赖排序
	 * 重排序对多线程的影响 如
	 * if (flag) {                //3
     *   int i =  a * a;        //4
     *   ……
     *  }
	 *   在多线程程序中，对存在控制依赖的操作重排序，可能会改变程序的执行结果，编译器和处理器会采用猜测（Speculation）执行来克服控制相关性对并行度的影响
	 *    以处理器的猜测执行为例，执行线程B的处理器可以提前读取并计算a*a，然后把计算结果临时保存到一个名为重排序缓冲（reorder buffer ROB）的硬件缓存中
	 * 
	 * 
	 * 
	 */
	public static void main(String[] args) {
		 int tid = 0x000000000fb0c800;
		 System.out.println(tid);
		 
		 L l = new L();
		
		 
		 for(int i=0;i<10;i++){
			 int y = i;
			 new Thread("reader-"+y){
				 
				 @Override
				public void run() {
					 try {
						 Random r = new Random();
						Thread.sleep(r.nextInt(10));
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					 System.out.println(this.getName()+":"+l.get(y+""));
				}
			 }.start();
		 }
		
		 for(int i=0;i<10;i++){
			 int y = i;
			 new Thread("writer-"+y){
				 
				 @Override
				public void run() {
					 l.add(y+"", y+"");
				}
			 }.start();
		 }
		 
		 try {
			Thread.currentThread().join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
	}
	
	
	
	
	
	
	
	
	
	
public static	class  L {
		private Map<String,String> x = new HashMap<>();
		private volatile int c = 0;
		
		private ReentrantLock lock = new ReentrantLock();
		
		public void add(String k,String v){
			lock.lock();
			try {
				x.put(k, v);
				c++;
			} finally {
				lock.unlock();
			}
		}
		
		public String get(String k){
			if(c>0){
				return x.get(k);
			}
			return null;
		}
		
	}
	
	

}
