package org.java.instrumentation;

/**
 * https://docs.oracle.com/javase/8/docs/technotes/guides/instrumentation/index.html
 * 
 * jvm agent 
 * -agentlib:libname[=options] jvm原生支持
 * 比如在线的debug Java Debug Wire Protocol (JDWP)
 *  -agentlib:jdwp=transport=dt_socket,server=y,address=8000
 * 开发agent 接口文档
 * Agent Command Line Options in the JVM Tools Interface guide at http://docs.oracle.com/javase/8/docs/platform/jvmti/jvmti.html#starting
 * java.lang.instrument 是java语言层面的对agent的支持
 *
 */
public class App 
{
    
    
    //he premain method has one of two possible signatures. The JVM first attempts to invoke the following method on the agent class:

     //   public static void premain(String agentArgs, Instrumentation inst);
    //    If the agent class does not implement this method then the JVM will attempt to invoke:

    //    public static void premain(String agentArgs);
    
    
    
    public static void main( String[] args )
    {
        try {
            AttachVm.attachVM();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
        
    }
    
    //public static void agentmain(String agentArgs, Instrumentation inst);
   // If the agent class does not implement this method then the JVM will attempt to invoke:

   // public static void agentmain(String agentArgs);
   // The agent class may also have an premain method for use when the agent is started using a command-line option. When the agent is started after VM startup the premain method is not invoked.
   
}
