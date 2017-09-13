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

}
