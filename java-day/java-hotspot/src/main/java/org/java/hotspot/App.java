package org.java.hotspot;

/**
 * Hello world!
 *
 */
public class App 
{
	
	static volatile int x = 5;
    public static void main( String[] args )
    {
        
        /**
         * concurrent: 并发, 多个线程协同做同一件事情(有状态)   应用程序和 gc 并发

            parallel: 并行, 多个线程各做各的事情(互相间无共享状态)  gc并行
         * -XX:+PrintCommandLineFlags
         * 
         * 
         * parallel scavenge
         * -XX:+UseParallelGC    -XX:+UseParallelOldGC    PSYoungGen
         * 
         * -XX:+UseParNewGC      -XX:+UseConcMarkSweepGC    par new
         * 
         * -XX:+UseSerialGC               defnew    tenured
         * 
         * -XX:+UseG1GC
         * G1的首要目标是为需要大量内存的系统提供一个保证GC低延迟的解决方案. 也就是说堆内存在6GB及以上,稳定和可预测的暂停时间小于0.5秒.
         * 
         * http://blog.csdn.net/renfufei/article/details/41897113
         */
        /**
        0.814: [GC (Allocation Failure)
                 [PSYoungGen: 33280K->5090K(38400K)] 
                33280K->9475K(125952K), 0.0374454 secs] 
                        [Times: user=0.03 sys=0.00, real=0.04 secs] 
                        
                            
                            
          2017-07-21T16:24:20.797+0800: 0.880: [GC (Allocation Failure) 2017-07-21T16:24:20.797+0800: 0.880: 
                    [ParNew: 34944K->4350K(39296K), 0.0110085 secs]
                     34944K->9493K(126720K), 0.0110763 secs] 
                     [Times: user=0.00 sys=0.00, real=0.01 secs] 
                        
        */
    	
    	x = 9;
    	ch();
    	
    	try {
			Thread.sleep(Integer.MAX_VALUE);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    
    
    static void ch(){
    	for(int i=0;i<200;i++){
    		x = i;
    	}
    }
    
    
    
}
