package com.spring.context;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.service.UserService;

public class BeanFactoryx {
    
    
    public static void main(String[] args) {
        ClassPathXmlApplicationContext  context =  new ClassPathXmlApplicationContext("beans.xml");
        
        UserService userService = (UserService) context.getBean("userService");
        userService.getUser();
        userService.testUser();
        
        /*UserService userServicex = (UserService) context.getBean("userServicex");
        userServicex.getUser();*/
        
        
        //大致步骤
        
        //1.解析 xml配置  beanDefinition 注册到 BeanDefinitionRegistry
        //2.注册 BeanPostProcessor   后置处理器
        //3.Instantiate all remaining (non-lazy-init) singletons
        
        
        //getBean 步骤
        //1.bean 转换  区分 FactoryBean
        //2. Give BeanPostProcessors a chance to return a proxy instead of the target bean instance -BeanPostProcessor
        //3. FactoryMethod ,构造函数(有参数) constructor ,无参数构造函数               CglibSubclassingInstantiationStrategy 策略实例化封装到BeanWrapper
        //   注册自定义属性的编辑器  registerCustomEditors
        //4.填充属性 
        //5.initializeBean   
        // invokeAwareMethods --BeanNameAware,BeanClassLoaderAware,BeanFactoryAware
        // beanProcessor.postProcessBeforeInitialization
        // invokeInitMethods--InitializingBean.afterPropertiesSet(),init-method
        // beanProcessor.postProcessAfterInitialization
        //6.返回 实例对象
        
        
    }

}
