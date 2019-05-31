package org.java.logs;

import ch.qos.logback.classic.joran.JoranConfigurator;
import org.slf4j.ILoggerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.URL;


/**
 * https://github.com/angelwsin/log.git
 * 请参考
 *
 */
public class App 
{
    
    private static Logger log = LoggerFactory.getLogger(App.class);
    public static void main( String[] args )throws  Exception
    {
        
        
        try{
            log.info("Hello World!");
             
            Integer.parseInt("x");
            
        }catch (Exception e) {
            System.out.println(e);
            StackTraceElement[] st =  e.getStackTrace();
            for(StackTraceElement ex : st){
                System.out.println(ex); 
            }
           
         // e.printStackTrace();
        }
        
        
        System.out.println( "Hello World!" );


       //工厂模式 ILoggerFactory
        //初始化  org.slf4j.impl.StaticLoggerBinder  静态绑定找到实现类库
        //得到配置文件 解析JoranConfigurator
        // .xml 配置文件使用sax 解析规则 RuleStore(JoranConfigurator.addInstanceRules加载解析规则)
        // 规则使用   标签对应的 动作 Action

       //解析配置文件
        new JoranConfigurator().doConfigure(new URL(""));
    }
    
    
    
    
    /*
     * 梳理下 日志家族
     * 
     * 
     * 
     *          日志接口         commons-logging(apache)     slf4j(Simple Logging Facade for JAVA )    
     *          
     *          实现                 log4j,jdk14logger            logback
     * 
     *          运行时              过动态查找的机制，绑定日志实现库                       静态绑定
     * 
     * 
     *                            适配
     *           
     *         log4j             slf4j-log4j12                 slf4j
     *         
     *         jdk14logger       slf4j-jdk14
     * 
     * 
     * 
     * 
     */
}
