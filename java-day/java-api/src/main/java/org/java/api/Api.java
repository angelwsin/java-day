package org.java.api;

public class Api {
    
    
    public static void main(String[] args) {
        
        
        /**
         * jre\lib
         * 
         * resouces.jar
         * rt.jar
         * jsse.jar
         * jce.jar
         * charsets.jar
         * jfr.jar
         * management-agent.jar   使用Instrumentation  sun.management.Agent类  // invoked by -javaagent or -Dcom.sun.management.agent.class
         * plugin.jar
         * 
         * jre\lib\ext
         * 
         * access-bridge-64.jar
         * cldrdata.jar
         * dnsns.jar
         * jaccess.jar
         * jfxrt.jar
         * localedata.jar
         * nashorn.jar
         * sunec.jar
         * sunjce_provider.jar
         * summscapi.jar
         * sunpkcs11.jar
         * zipfs.jar
         * 
         */
        
        
         /**
          * 
          * jdk
          * 
          * ant-javafx.jar
          * dt.jar
          * javafx-mx.jar
          * jconsole.jar
          * packager.jar
          * sa-jdi.jar
          * tools.jar
          * 
          * 
          */
    	//动态加载native lib
    	//路径java.library.path
    	/*Linux环境

    	系统变量LD_LIBRARY_PATH来添加java.library.path

    	Windows

    	在系统->高级系统设置->环境变量里，在path变量里添加。

    	Eclipse

    	在Properties -> Run/Debug settings -> Arguments->VM arguments里添加：

    	-Djava.library.path=/home/abc/workspace/
    	*/
    	System.loadLibrary("nativelib");
    }

}
