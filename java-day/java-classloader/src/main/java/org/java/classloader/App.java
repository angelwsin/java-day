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
      *  
      *  缓冲的加载类放在 SystemDictionary 的hash列表中
      *  bootstrap class loader  为 NULL
      */
     loader.loadClass(App.class.getName());
     
     //父类委托查找 
     // 没有查找到自己加载  class findClass
        
       
    }
}
