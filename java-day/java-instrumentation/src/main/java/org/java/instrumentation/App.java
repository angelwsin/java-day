package org.java.instrumentation;

/**
 * Hello world!
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
