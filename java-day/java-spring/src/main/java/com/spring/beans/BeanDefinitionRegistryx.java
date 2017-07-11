package com.spring.beans;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.support.RootBeanDefinition;

public class BeanDefinitionRegistryx {

    
    
    
    
    //beanDefinition 注册中心
   public static void main(String[] args) {
       
       
       DefaultListableBeanFactory factory  = new DefaultListableBeanFactory();
       
       factory.registerBeanDefinition("beanName", new RootBeanDefinition());
       
    
  }
}
