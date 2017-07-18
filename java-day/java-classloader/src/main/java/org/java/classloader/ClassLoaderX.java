package org.java.classloader;

/**
 * Hello world!
 *
 */
public class ClassLoaderX 
{
    public static void main( String[] args )throws Exception
    {
        
     ClassLoader loader =    ClassLoader.class.getClassLoader();
     
     /**
      * 类加载
      *  native  findLoadedClass0          
      *  根据类名和 加载器 的哈希值 ^ 查找    classloader.c  Java_java_lang_ClassLoader_findLoadedClass0
      *  
      *  缓冲的加载类放在 SystemDictionary 的hash列表中      返回一个 klass对象 
      *  bootstrap class loader  为 NULL
      */
     loader.loadClass(ClassLoaderX.class.getName());
     
     //父类委托查找 
     // 没有查找到自己加载  class findClass
        
       
    }

    /*
     * verifier.cpp  验证器
     * classLoader.cpp  类加载器
     * symbolTable.cpp  字符表   快速查找字符串     使用 hash表存储
     * classFileParser.cpp  解析class文件
     * systemDictionary.cpp 系统字典  加载的类存放在此
     */
    /**
     * -verbose:class
     * 
     * -XX:+TraceClassLoading 
     * -XX:+TraceClassLoadingPreorder
     * -XX:+TraceClassUnloading
     */
    
    /**
     * .class     加载                 验证，准备（静态属性分配默认值）,链接（符号引用转换为直接引用)         初始化阶段
     * 
     * 
     * 跟踪类的加载
     * +TraceClassLoading
     */
}
