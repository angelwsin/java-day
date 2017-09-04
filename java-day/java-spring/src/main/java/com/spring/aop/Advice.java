package com.spring.aop;

import org.springframework.aop.aspectj.autoproxy.AspectJAwareAdvisorAutoProxyCreator;
import org.springframework.aop.support.DefaultBeanFactoryPointcutAdvisor;

public class Advice {
    
    
    
    
    

    
    /*
     *      AspectJAwareAdvisorAutoProxyCreator
     * 
     * pointcut
     *     |
     *     |__AspectJExpressionPointcut     
     * 
     * advisor (DefaultBeanFactoryPointcutAdvisor)
     *    |
     *    |__Advice
     *    
     *    
     *    
     *    
     *    
     *    
     *    
     *    得到Advisor 根据 AspectJExpressionPointcut过滤
     *    
     *    ProxyFactory 创建代理对象  Advisor 设置到
     *       （JdkDynamicAopProxy，ObjenesisCglibAopProxy，JdkDynamicAopProxy 不同的策略创建代理对象）
     *       
     *       Advisor 得到MethodInterceptor  拦截的调用链
     *       
     *       
     *       
     *       定义不用的Advisor 可以完成拦截
     *       如 RegexpMethodPointcutAdvisor 正则匹配
     *         TransactionAttributeSourceAdvisor 处理事务的
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
     * 
     * 
     * 
     * 
     * 
     * 
     * 
     * 
     * 
     */
}
