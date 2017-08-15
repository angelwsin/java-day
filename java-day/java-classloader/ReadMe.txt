

boot(Bootstrap) 根类加载器 lib/rt.jar
ext  扩张类加载器  lib/ext
sys(app)  系统类加载器  classpath

自定义加载器

机制委托加载


   ClassLoader
   
          URLClassLoader
          
              Launcher$AppClassLoader  Launcher$ExtClassLoader
              
              


hotswap
http://blog.csdn.net/nameix/article/details/52277464
           
                