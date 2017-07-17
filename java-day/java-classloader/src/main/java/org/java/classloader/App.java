package org.java.classloader;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )throws Exception
    {
        
     ClassLoader loader =    App.class.getClassLoader();
     
     /**
      * 类加载
      *  native  findLoadedClass0 
      *  根据类名和 加载器 的哈希值 ^ 查找    classloader.c  Java_java_lang_ClassLoader_findLoadedClass0
      */
     loader.loadClass(App.class.getName());
        
       
    }
}
