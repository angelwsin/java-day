package org.java.concurrent.lock;

//对Perterson进行扩展 到多线程
//下面分析两种支持n（n>2）线程的互斥协议。第一种协议称为过滤锁，它是Peterson锁算法在多线程上的直接一般化。第二种协议称为Bakery锁
public class FilterLock implements Lock{
	
	int[] level;
	int[] victim;
	
	public FilterLock(int n){
		level = new int[n];
		victim = new int[n];
	}

	@Override
	public void lock() {
		int me = (int) Thread.currentThread().getId();
		for(int i=1;i<level.length;i++){
			level[me] = i;
			victim[i] = me;
			int k = 0;
			//类比 Peterson锁
			//while((∃ k!=me)(level[k]>=i&&victim[i]==me))
			while(level[k%level.length!=me?k++%level.length:(k++)%level.length]>=i&&victim[i]==me){
				
			}
		}
		
	}

	@Override
	public void unlock() {
		int me = (int) Thread.currentThread().getId();
		level[me] = 0;
	}
	
	
	/**
	 * 
	 * 
	 *   n层的过滤层
	 *   Peterson的flag标志被推广 level[n] 数组
	 *   
	 *    level[n]  每个线程都必须通过n-1层的“排除”才能进入自己的临界区
	 *    ____
	 *    |   |   每一个层有一个victim[Q]域 用来“过滤出”一个线程，使其不能进入下一层
	 *    |___|
	 *    |
	 *    |
	 *    |
	 *    |
	 *    |
	 * 
	 * 
	 */

	
	public static void main(String[] args) {
		int k = 0;
		System.out.println(k++%10);
	}
}
