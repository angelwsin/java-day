package org.java.tools.java;

import java.util.Map;

public class Java {
    
    
    public static void main(String[] args) {
    	
       //
    	System.out.println(System.getenv("_JAVA_VERSION_SET"));
    	Map<String,String> evn = System.getenv();
    	evn.forEach((String k,String v)->{
    		//System.out.println(k+":"+v);
    		
    	});
    	System.out.println(System.getProperty("sun.java.command"));
    	System.out.println(System.getProperty("java.vm.name"));
    	System.out.println(System.getProperty("sun.boot.library.path"));
    	
    	//java [-options] class [args...]
    	
    	
    	//-options
    	
    	//1.针对jvm的参数
    	////JavaVMOption     key,value
    	
    	//2.配置的参数 设置系统属性
    	// -D
    	
    	//3.启动一些服务  如  jpda 
    	
    	
    	//java [-options] class [args...]
    	//设置 运行JRE版本  SelectVersion()
    	  //1.在环境变量中设置 _JAVA_VERSION_SET
    	  //2.在 -options设置 1.5已经废弃
    	  //3. -jar 在manifest 中查找
       //创建执行环境     CreateExecutionEnvironment
    	  //查找进程运行的绝对路径exec_path  linux  /proc/self/exe
    	  //根据    -d64或-d32           选择系统的架构arch
    	  //再根据 arch 查找GetJREPath()   
    	  //jrepath 查找    搜索路径(windows 下) exec_path\bin\java.dll 或 exec_path\jre\bin\java.dll
    	                 //搜索路径(linux 下) exec_path/lib/libjava.so 或 exec_path/jre/lib/libjava.so
    	 //jvm type 路径  $jrepath/lib/$arch/jvm.cfg
    	//jvmpath   得到jvm type(server,clinet)  查找jvmpath路径(windows)$jrepath\bin\$jvm type\jvm.dll
    	//动态链接jvmpath 得到 jvm创建和初始化参数的方法  JNI_CreateJavaVM，JNI_GetDefaultJavaVMInitArgs
    	//default CLASSPATH SetClassPath  -Djava.class.path=getenv("CLASSPATH")||.
    	//ParseArguments -options  
    	   //-classpath  -cp  setclasspath
    	   //.....
    	
    	//-Dsun.java.command
    	//-Dsun.java.launcher=SUN_STANDARD
    	//system 
    	 //java.vm.specification.name
    	//java.vm.name
    	//java.vm.version
    	//java.vm.info
    	//java.ext.dirs                ext classpath jre\lib\ext
    	//java.endorsed.dirs
    	//sun.boot.library.path         dll_dir=jre/bin
    	//java.library.path             PATH
    	//java.home                     JAVA_HOME
    	//sun.boot.class.path           boot classpath     
    	                                       /*jre/lib/resources.jar:
                                                 jre/lib/rt.jar:
                                                 jre/lib/sunrsasign.jar:
                                                 jre/lib/jsse.jar:
                                                 jre/lib/jce.jar:
                                                 jre/lib/charsets.jar:
                                                 jre/lib/jfr.jar:
                                                 jre/classes";*/
    	                               
    	//java.class.path               system classpath  CLASSPATH|-classpath  -cp|-Djava.class.path
    	
    	System.out.println(System.getProperty("java.library.path"));
    	
    	System.out.println(System.getProperty("java.ext.dirs"));
    	System.out.println(System.getProperty("java.class.path"));
    	System.out.println(System.getProperty("sun.boot.class.path"));
    	
    	//Arguments::parse() 解析 vm 的options 参数
    	
    	
    	/*// All platforms
    	  "JAVA_HOME", "JRE_HOME", "JAVA_TOOL_OPTIONS", "_JAVA_OPTIONS", "CLASSPATH",
    	  "JAVA_COMPILER", "PATH", "USERNAME",

    	  // Env variables that are defined on Solaris/Linux/BSD
    	  "LD_LIBRARY_PATH", "LD_PRELOAD", "SHELL", "DISPLAY",
    	  "HOSTTYPE", "OSTYPE", "ARCH", "MACHTYPE",

    	  // defined on Linux
    	  "LD_ASSUME_KERNEL", "_JAVA_SR_SIGNUM",

    	  // defined on Darwin
    	  "DYLD_LIBRARY_PATH", "DYLD_FALLBACK_LIBRARY_PATH",
    	  "DYLD_FRAMEWORK_PATH", "DYLD_FALLBACK_FRAMEWORK_PATH",
    	  "DYLD_INSERT_LIBRARIES",

    	  // defined on Windows
    	  "OS", "PROCESSOR_IDENTIFIER", "_ALT_JAVA_HOME_DIR",*/
    	
    	
    	
    }

}
