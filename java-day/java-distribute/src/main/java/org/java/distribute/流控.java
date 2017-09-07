package org.java.distribute;


//http://jm.taobao.org/2012/12/10/two-flow-limit-mode/
public class 流控 {

    
    /**
     * 
     * 1.滑窗模式
     *  模式分析: 
                               在每次有访问进来时，我们判断前N个单位时间里总访问量是否超过了设置的阈值，若超过则不允许执行。
                            如 dubbo TpsLimitFilter(控制速率)
     * 2.响应模式
     *   模式分析：
                               每次操作执行时，我们通过判断当前正在执行的访问数是否超过某个阈值在决定是否限流。
                     如:dubbo ActiveLimitFilter(并发控制)
          
                 控制速率
                       令牌桶控制的是一个时间窗口内的通过的数据量，在 API 层面我们常说的 QPS、TPS，正好是一个时间窗口内的请求量或者事务量，只不过时间窗口限定在 1s 罢了。
         Guava 的 RateLimiter 来实现基于令牌桶的流控
        SmoothBursty 有一个可以放 N 个时间窗口产生的令牌的桶，系统空闲的时候令牌就一直攒着，最好情况下可以扛 N 倍于限流值的高峰而不影响后续请求
        Guava 的SmoothWarmingUp
     */
    
}
