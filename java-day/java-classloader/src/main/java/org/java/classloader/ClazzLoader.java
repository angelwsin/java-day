package org.java.classloader;

import java.net.URL;
import java.net.URLClassLoader;

public class ClazzLoader {
    
    
    
    /**
     * 
     *                 ClassLoader
     *                     |____URLClassLoader  (URLClassPath 类文件路径)
     *                              |
     *                              |__Launcher$ExtClassLoader 
     *                              |
     *                              |__Launcher$AppClassLoader
     * 
     * 
     * 
     * 
     * 
     * 
     * 
     */
    
    
    public static void main(String[] args) {
        
        sun.misc.Launcher l = sun.misc.Launcher.getLauncher();
        URLClassLoader app = (URLClassLoader) l.getClassLoader();
        System.out.println("系统类加载或app "+app);
        for(URL url : app.getURLs()){
            System.out.println(url.getFile());
        }
        
        
    }
    
    
    
    /**
     * 类加载过程
     * 
     *  .java  文件 编译成 .class文件
     *  
     *  jvm启动 设置加载路径
     *  
     *  设置方式:
     *    1.java  -D
     *  
     *  1.根类加载器的路径
     *  2.扩展类加载器的路径
     *  3.应用程序类加载器
     *  
     * 
     * 
     * 
     * 
     */

}
