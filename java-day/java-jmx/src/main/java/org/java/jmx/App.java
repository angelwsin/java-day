package org.java.jmx;

import java.lang.management.ManagementFactory;

import javax.management.MBeanServer;
import javax.management.MBeanServerFactory;
import javax.management.ObjectName;

import org.java.jmx.mbean.PrintMBean;
import org.java.jmx.mbean.Print;

/**
 * The Java Management Extensions (JMX) API is a standard API for management and monitoring of resources 
 * such as applications, devices, services, and the Java virtual machine. The JMX technology was 
 * originally developed through the Java Community Process (JCP) as Java Specification Request (JSR) 3, 
 * Java Management Extensions, and JSR 160, JMX Remote API.

Typical uses of the JMX technology include:

Consulting and changing application configuration
Accumulating statistics about application behavior and making them available
Notifying of state changes and erroneous conditions.
 *
 */
public class App 
{
    public static void main( String[] args )throws Exception
    {
        //MBeanServerFactory.createMBeanServer()
        MBeanServer mBeanServer =  ManagementFactory.getPlatformMBeanServer();
        
        //ObjectName 由两部分组成  domain 和 key properties
        //domain string但不包含:不推荐使用// 以后可能会用  domain可以使用通配符 *(0or more) ?(1)
        //key properties 没有顺序的key/value 中间使用,分割 使用通配符 *(0or more) ?(1)
        //为了避免冲突 可以使用包名 类名
        ObjectName  jd  = new ObjectName("com.jmx:type=JmxBean");
        //注册MBean  MBean 的实现   查找MBean接口
        //1 实现 DynamicMBean  
        //2 Standard MBean  子类的类名+MBean = 父类的类名
        //3. 接口使用注解 @MBean  并且 类名以MBean 结尾 
         mBeanServer.registerMBean(new Print(), jd);
         
        
       // mBeanServer.invoke(jd, "print", new String[]{"print hello "}, new String[]{"java.lang.String"});
        
        
        /*MBean 注册到MBeanServer 中的组件
         * 
         * ManagementFactory  MBeanServer工厂
         * MBeanServerBuilder 
         * MBeanServer builder 可以继承Builder定制自己的MBeanServer
         * 自定义 builder插入通过 设置变量 JmxProperties.JMX_INITIAL_BUILDER=builder class
         * MBeanServerDelegate  delegate that should be used by the MBeanServer implementation.
         * 
         * mbsInterceptor (MBeanServer)delegate注册到mbsInterceptor上
         * 
         */
        
        /*
         * 使用的设计模式
         * 
         * 工厂
         * builder
         * 委托
         */
         String runtimeName = ManagementFactory.getRuntimeMXBean().getName();
         // format: "pid@hostname"
         
         System.out.println(runtimeName.substring(0, runtimeName.indexOf("@")));
         Thread.sleep(Integer.MAX_VALUE);
         //jconsole
         
         /*
          * MXBeans
          * 1)Standard MBeans 子类的类名+MBean = 父类的类名
          * 2)MXBeans          @MXBean
          * 3)Dynamic MBeans  DynamicMBean interface
          * 4)Open MBeans      javax.management.openmbean.
          * 5)Model MBeans     javax.management.modelmbean.
          * 
          */
    }
}
