package org.java.concurrent;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadPool {
	
	
	public static void main(String[] args) {
		
		ThreadPoolExecutor  executor = new ThreadPoolExecutor(3, 5, 
				1000, TimeUnit.SECONDS, new ArrayBlockingQueue<>(3) , new ThreadFactory() {
					
					@Override
					public Thread newThread(Runnable r) {
						return null;
					}
				}, new RejectedExecutionHandler() {
					
					@Override
					public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
						// TODO Auto-generated method stub
						
					}
				});
		
		
		executor.execute(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				
			}
		});
		
		
		//threadpool 中维护 Set containing all worker threads in pool(Set<Worker> 创建Worker 执行task)
		
		//java.util.concurrent.ThreadPoolExecutor.addWorker(Runnable, boolean) 添加工作者逻辑
		//java.util.concurrent.ThreadPoolExecutor.runWorker(Worker) 工作者的执行逻辑
		
	}

}
