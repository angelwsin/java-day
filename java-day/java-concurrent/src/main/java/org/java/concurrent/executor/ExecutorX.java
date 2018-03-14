package org.java.concurrent.executor;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ExecutorX {
	
	
	
	
	//任务 分组  不同的任务速度
	
	public static void main(String[] args) {
		
		
		
		
		ExecutorService executor = new ThreadPoolExecutor(2, 4, 3, TimeUnit.SECONDS, new ArrayBlockingQueue<Runnable>(4));
		ExecutorCompletionService<Integer> completionService  = new ExecutorCompletionService<>(executor);
		completionService.submit(new RunTask());
		completionService.submit(new RunTask());
		completionService.submit(new RunTask());
		try {
			System.out.println(completionService.take().get());
			System.out.println(completionService.take().get());
			System.out.println(completionService.take().get());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	
	public static class RunTask implements Callable<Integer>{

		@Override
		public Integer call() throws Exception {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			return 5;
		}

		
		
	}

}
