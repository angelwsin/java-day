package org.java.classloader;

import java.net.URL;
import java.net.URLClassLoader;

import sun.jvm.hotspot.debugger.MachineDescriptionIntelX86;
import sun.jvm.hotspot.memory.SystemDictionary;
import sun.jvm.hotspot.memory.SystemDictionary.ClassVisitor;
import sun.jvm.hotspot.oops.Klass;
import sun.jvm.hotspot.runtime.VM;
import sun.jvm.hotspot.types.basic.BasicTypeDataBase;
import sun.misc.Launcher;
import sun.misc.URLClassPath;

/**
 * Hello world!
 *
 */
public class ClassLoaderX 
{
    @SuppressWarnings("restriction")
    public static void main( String[] args )throws Exception
    {
        
     ClassLoader loader =    ClassLoaderX.class.getClassLoader();
     
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
     
    // VM.getVM().
     
     
     //Arguments::parse  属性解析
     //初始化 系统属性
     //// Initialize system properties.
    // Arguments::init_system_properties();
     
     /**
      * 
      *  // following are JVMTI agent writeable properties.
  // Properties values are set to NULL and they are
  // os specific they are initialized in os::init_system_properties_values().
  _java_ext_dirs = new SystemProperty("java.ext.dirs", NULL,  true);
  _java_endorsed_dirs = new SystemProperty("java.endorsed.dirs", NULL,  true);
  _sun_boot_library_path = new SystemProperty("sun.boot.library.path", NULL,  true);
  _java_library_path = new SystemProperty("java.library.path", NULL,  true);
  _java_home =  new SystemProperty("java.home", NULL,  true);
  _sun_boot_class_path = new SystemProperty("sun.boot.class.path", NULL,  true);

   _java_class_path = new SystemProperty("java.class.path", "",  true);

      */
     
     sun.misc.Launcher l = sun.misc.Launcher.getLauncher();
     
     //根类加载器的路径
     System.out.println("根类加载器");
      URLClassPath  path =   Launcher.getBootstrapClassPath();
      for(URL url : path.getURLs()){
          System.out.println(url.getFile());
      }
      
      URLClassLoader   ext = (URLClassLoader) l.getClassLoader().getParent();
      System.out.println("ext  类加载器"+ext);
      for(URL url : ext.getURLs()){
          System.out.println(url.getFile());
      }
      
      URLClassLoader app = (URLClassLoader) l.getClassLoader();
      System.out.println("系统类加载或app "+app);
      for(URL url : app.getURLs()){
          System.out.println(url.getFile());
      }
      
      //查看 jvm  加载的类 放在 系统字典中
    
      VM.initialize(new BasicTypeDataBase(new MachineDescriptionIntelX86(),null), true);
      SystemDictionary dic =  VM.getVM().getSystemDictionary();
      dic.classesDo(new ClassVisitor() {
        

        @Override
        public void visit(Klass klass) {
            System.out.println(klass.getAddress()+":"+klass.getName());
            
        }
    });
       
       
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
     * 链接    如方法的连接
     * 
     * java  普通方法
     *       符号引用转换为直接引用         address entry = Interpreter::entry_for_method(h_method);
     *       
     *       native  address* native_function_addr() const          { assert(is_native(), "must be native"); return (address*) (this+1); }
     * 
     * 
     * 跟踪类的加载
     * +TraceClassLoading
     * 
     * 
     * 根类加载器加载  c++实现
     * _well_known_klasses
     * 
     * java classloader 的类加载器加载    JavaCalls::call
     * 
     * 
     *  ClassFileParser::parseClassFile 解析字节码  生成  Klass对象
     * 
     * 
     * 
     */
   /* enum x{
        Object_klass_knum, java_lang_Object_knum = Object_klass_knum, \
                String_klass_knum, java_lang_String_knum = String_klass_knum, \  
    }
    static Klass* Object_klass() { return check_klass_Pre(_well_known_klasses[Object_klass_knum]); } \
    static Klass** Object_klass_addr() {                                                                       \
      return &SystemDictionary::_well_known_klasses[SystemDictionary::Object_klass_knum];           \
    } \
    
    *
    */
    
    
    /**
     * 类加载 过程 
     * 
     * 是不是 根类加载器 是
     */
}
