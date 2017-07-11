package com.spring.core;

import org.springframework.context.annotation.ScannedGenericBeanDefinition;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.core.type.classreading.CachingMetadataReaderFactory;
import org.springframework.core.type.classreading.MetadataReader;
import org.springframework.core.type.classreading.MetadataReaderFactory;

public class ASMClass {
    
    
    static final String DEFAULT_RESOURCE_PATTERN = "**/*.class";
    
    
    
    
    //class  asm 反汇编 
    public static void main(String[] args) throws Exception{
        
        String basePackage   ="com.service";
        //路径匹配  Ant path
        ResourcePatternResolver resourcePatternResolver = new PathMatchingResourcePatternResolver();
        
        String packageSearchPath = ResourcePatternResolver.CLASSPATH_ALL_URL_PREFIX +
                basePackage.replace('.', '/') + "/" + DEFAULT_RESOURCE_PATTERN;
        Resource[] resources = resourcePatternResolver.getResources(packageSearchPath);
        
        MetadataReaderFactory metadataReaderFactory =
                new CachingMetadataReaderFactory(resourcePatternResolver);
        
        for(Resource res : resources){
            MetadataReader reader =    metadataReaderFactory.getMetadataReader(res);
            
            //beanDefinition 
            ScannedGenericBeanDefinition scan  = new ScannedGenericBeanDefinition(reader);
            System.out.println(scan.getBeanClassName());
        }
        
        
       
      
    }

}
