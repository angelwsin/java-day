package com.spring.beans;

import org.springframework.beans.factory.annotation.AnnotatedGenericBeanDefinition;
import org.springframework.beans.factory.config.BeanDefinitionHolder;
import org.springframework.beans.factory.parsing.BeanComponentDefinition;
import org.springframework.beans.factory.parsing.CompositeComponentDefinition;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.ChildBeanDefinition;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanDefinitionx {
    
    
    public static void main(String[] args) {
        
        //BeanDefinition  bean 的定义 spring bean的结构
        
        //没有父 beanDefinition的 bean 定义  
        //spring  运行时的bean
        AbstractBeanDefinition rootBeanDefinition = new RootBeanDefinition();
        
        //必须指定 父 beanDefinition
        AbstractBeanDefinition childBeanDefinition = new ChildBeanDefinition("parentName");
        
        //通用beanDefinition  父beanDefinition 可有可无
        AbstractBeanDefinition GenericBeanDefinition = new GenericBeanDefinition();
        
        //注解的 beanDefnition 
        AbstractBeanDefinition  AnnotateBeanDef = new AnnotatedGenericBeanDefinition(User.class);
        
       
        /**
         * 几个重要属性
         * 
         * 
        setBeanClassName(original.getBeanClassName());
        setFactoryBeanName(original.getFactoryBeanName());
        setFactoryMethodName(original.getFactoryMethodName());
        setScope(original.getScope());
        setAbstract(original.isAbstract());
        setLazyInit(original.isLazyInit());
        setConstructorArgumentValues(new ConstructorArgumentValues(original.getConstructorArgumentValues()));
        setPropertyValues(new MutablePropertyValues(original.getPropertyValues()));
        setSource(original.getSource());
        copyAttributesFrom(original);
        setBeanClass(originalAbd.getBeanClass())
         * 
         */
        
        
        //beanDefinition 辅助
        
        BeanDefinitionHolder  holder = new BeanDefinitionHolder(GenericBeanDefinition, "user");
        
        BeanComponentDefinition beanComponent = new BeanComponentDefinition(holder);
        
        //named group of components
        CompositeComponentDefinition composite  = new CompositeComponentDefinition("users", new Object());
        composite.addNestedComponent(beanComponent);
        
        
        
    }

}
