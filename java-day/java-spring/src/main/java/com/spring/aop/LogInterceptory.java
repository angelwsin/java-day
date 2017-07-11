package com.spring.aop;

import org.aopalliance.intercept.MethodInvocation;
import org.springframework.aop.IntroductionInterceptor;

public class LogInterceptory implements IntroductionInterceptor{

    public Object invoke(MethodInvocation invocation) throws Throwable {
        System.out.println("invoke y ");
        return invocation.proceed();
    }

    public boolean implementsInterface(Class<?> intf) {
        // TODO Auto-generated method stub
        return false;
    }

}
