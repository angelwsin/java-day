package org.java.jvm;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	
        
        
        
        
        /**
         * 
         * 
         *        java 语法表现层 .java
         *      -------------------------
         *                             |
         *                             | 编译
         *        平台无关数据结构层 .class   
         *      -------------------------
         *                             |
         *                             | 类加载
         *         组织成 jvm 中的数据结构模型(c/c++)    
         *      --------------------------
         *                             |
         *                             | 解析指令
         *             运行层  
         *      ---------------------------
         * 
         * 
         * 
         * 
         */
        
        
        
        
        
        
    	/**
    	 * 
    	 * JVMTI Env
    	 * JNI
    	 * JPLISAgent    Java programming language Agents
    	 * 
    	 * 
    	 * JNI
    	 * 
    	 * JNIEnv_结构 封装了 JNINativeInterface_(jni functions)
    	 * 
    	 */
        
    	System.out.println(System.getProperty("sun.java.launcher.pid"));
        
        
        
        
    }
}
