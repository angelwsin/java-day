package com.spring.beans;

import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessor;
import org.springframework.beans.factory.support.CglibSubclassingInstantiationStrategy;

public class Beans {
    
    
    
    
    /*
     * 
     * beans
     *  |
     *  |__bean
     *  |    |
     *  |    |__PropertyValue
     *  |           |
     *  |           |__PropertyEditorRegistry
     *  |                       |
     *  |                       |__PropertyValuesEditor
     *  |                               |
     *  |                               |__TypeConverter          
     *  |                                
     *  |__factory
     *         |
     *         |__BeanFactory
     *         |       |
     *         |       |__HierarchicalBeanFactory(可继承的factory有父factory)
     *         |       |
     *         |       |__ListableBeanFactory
     *         |
     *         |
     *         |__BeanNameAware(beanName)
     *         |
     *         |__DisposableBean(销毁bean调用)
     *         |
     *         |__FactoryBean(此bean生成其他bean)
     *         |
     *         |__InitializingBean
     *         |
     *         |__ObjectFactory
     *         |
     *         |__annotation
     *         |
     *         |__config
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
     * bean实例化之旅       BeanDefinition
     *                 |
     *                 |
     *          InstantiationAwareBeanPostProcessor ( 是  Give BeanPostProcessors a chance to return a proxy instead of the target bean instance.）
     *                 |
     *                 |
     *                根据策略实例化对象 如（CglibSubclassingInstantiationStrategy）
     *                 |
     *                 |
     *                 populateBean （填充属性)
     *                 |
     *                 |
     *                 invokeAwareMethods (调用方法BeanNameAware,BeanClassLoaderAware,BeanFactoryAware)
     *                 |
     *                 |
     *                 BeanPostProcessor(postProcessBeforeInitialization)
     *                 |
     *                 |
     *                 invokeInitMethods(InitializingBean,init-method)
     *                 |
     *                 |
     *                 BeanPostProcessor(postProcessAfterInitialization)
     *                 |
     *                 |
     *                 DisposableBean
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
