package com.spring.aop;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class LogInterceptor {
    
    
    
     @Pointcut("execution(public * *(..))")
     public void log(){}
    
    
    @Before("log()")
    public void  beforeLog(){
        System.out.println("开始时间:"+System.currentTimeMillis());
        
    }
    
    @After("log()")
    public void  afterLog(){
        System.out.println("结束时间:"+System.currentTimeMillis());  
    }

}
