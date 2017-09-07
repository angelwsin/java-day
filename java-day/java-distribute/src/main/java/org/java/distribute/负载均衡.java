package org.java.distribute;

public class 负载均衡 {
    
    
    /**
     * 
     * 基于权重随机负载 如dubbo RandomLoadBalance、
     * 最少活跃数优先 如dubbo  LeastActiveLoadBalance、
     * Roundrobin(轮询) 如dubbo RoundRobinLoadBalance、
     * 一致性Hash  如dubbo ConsistentHashLoadBalance (客户端)
     * 
     * 
     * 
     * 
     * 
     * 
     * 
     * 
     * 
     * 
     * failback 失败自动恢复，后台记录失败请求，定时重发，通常用于消息通知操作
     * fialfast 快速失败，只发起一次调用，失败立即报错，通常用于非幂等性的写操作
     * failover 失败转移，当出现失败，重试其它服务器，通常用于读操作，但重试会带来更长延迟
     * Failsafe(失败安全，出现异常时，直接忽略，通常用于写入审计日志等操作)
     * Forking 并行调用，只要一个成功即返回，通常用于实时性要求较高的操作，但需要浪费更多服务资源
     * 
     * 
     * 
     * 
     * 
     * 
     * 
     * 
     * 
     * 
     * 
     * Callback(dubbo 回路调用CallbackServiceCodec)
     */

}
