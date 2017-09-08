package org.java.distribute.hystrix;

import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;
import com.netflix.hystrix.HystrixCommandKey;
import com.netflix.hystrix.HystrixCommandMetrics;
import com.netflix.hystrix.HystrixCommandProperties;
import com.netflix.hystrix.HystrixThreadPoolKey;
import com.netflix.hystrix.HystrixThreadPoolProperties;


//依赖隔离（线程隔离) 熔断器
//https://github.com/Netflix/Hystrix/
public class Service1HystrixCommand extends HystrixCommand<RpcResponse> {
    
     private RpcService rpcService;
     
     private RpcRequest request;
    

    protected Service1HystrixCommand(RpcService rpcService,RpcRequest request) {
        super(Setter.withGroupKey(HystrixCommandGroupKey.Factory.asKey("ServiceGroup"))
                .andCommandKey(HystrixCommandKey.Factory.asKey("servcie1query"))
                .andThreadPoolKey(HystrixThreadPoolKey.Factory.asKey("service1ThreadPool"))
                .andThreadPoolPropertiesDefaults(HystrixThreadPoolProperties.Setter()
                  .withCoreSize(20))//服务线程池数量
                .andCommandPropertiesDefaults(HystrixCommandProperties.Setter()
                  .withCircuitBreakerErrorThresholdPercentage(60)//熔断器关闭到打开阈值
                  .withCircuitBreakerSleepWindowInMilliseconds(3000)//熔断器打开到关闭的时间窗长度
            ));
        this.rpcService  = rpcService;
        this.request  = request;
    }
    
    
    @Override
    public RpcResponse run() throws Exception {
        return this.rpcService.call(request);
    }

    
    //降级失败的回调
    @Override
    public RpcResponse getFallback() {
        return super.getFallback();
    }
    
    public static void main(String[] args) {
        Service1HystrixCommand comd = new Service1HystrixCommand(new RpcServiceImpl(), new RpcRequest());
        RpcResponse response = comd.execute();
        //指标
        HystrixCommandMetrics metrics = comd.getMetrics();
        System.out.println(metrics.getCurrentConcurrentExecutionCount());
        System.out.println(response.isSuccess());
        
        
    }
}
