package com.spring.beans;

import org.springframework.beans.factory.config.RuntimeBeanNameReference;
import org.springframework.beans.factory.config.RuntimeBeanReference;

public class PropertyValues {
    
    
    
    //beanDefinition PropertyValues
    public static void main(String[] args) {
        
        
        //应用 beanDefinition  ref
        
        RuntimeBeanNameReference ref = new RuntimeBeanNameReference("beanName");
        
        RuntimeBeanReference refBean = new RuntimeBeanReference("beanName");
        
        
    }

    
    /**
     * 
     * PropertyEditorRegistrySupport
     * 对属性的转换 
     */
}
