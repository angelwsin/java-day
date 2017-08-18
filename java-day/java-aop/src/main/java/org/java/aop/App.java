package org.java.aop;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 *
 *
 */
public class App 
{
    
    static{
       // -Dsun.misc.ProxyGenerator.saveGeneratedFiles=true
      //使用sun.misc.ProxyGenerator.saveGeneratedFiles=true可以生成代理代理对象的class文件
      //  System.setProperty("sun.misc.ProxyGenerator.saveGeneratedFiles", "true"); 
        //sun.misc.ProxyGenerator.saveGeneratedFiles
    }
    public static void main( String[] args )
    {
        
        //动态aop
        
        //静态aop
        
      //jdk 动态代理
        //具体生成 代理对象的see ProxyGenerator.generateClassFile  生成class文件 二进制
        //具体的 会有一个构造方法参数为InvocationHandler 该代理对象持有InvocationHandler 通过InvocationHandler调用代理方法
        
       // ProxyGenerator.generateProxyClass(arg0, arg1); 生成的对象使用这个方法
        UserService user = new UserServiceImpl();
        UserService userService = (UserService) Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(), new Class<?>[]{UserService.class}, new ProxyUser(user));
        
        userService.user();
        //先调用 代理对象的 user方法
        //然后调用 InvocationHandler的invoke 方法
        
        
        
        //CGLIB 基于 asm(一个Java字节码引擎库。ASM 是一个 Java 字节码操纵框架)
        //javassist
        //BCEL在实际的JVM 指令层次上进行操作(BCEL拥有丰富的JVM 指令级支持)而Javassist 所强调的源代码级别的工作
    }
    
    //代理模式
    
    
    
    
     static class ProxyUser  implements InvocationHandler{
         private UserService user;
         
         

        public ProxyUser(UserService user) {
            this.user = user;
        }



        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
              
            //proxy 生成的代理对象
            //method 要调用的方法引用
            // args 要调用的方法参数
            
            return  method.invoke(user, args);
        }
          
      }
     
     
     
     //代理对象如下
     
     /*
     public final class $Proxy0
     extends Proxy
     implements UserService
   {
     private static Method m1;
     private static Method m2;
     private static Method m3;
     private static Method m0;
     
     public $Proxy0(InvocationHandler paramInvocationHandler)
       throws 
     {
       super(paramInvocationHandler);
     }
     
     public final boolean equals(Object paramObject)
       throws 
     {
       try
       {
         return ((Boolean)this.h.invoke(this, m1, new Object[] { paramObject })).booleanValue();
       }
       catch (Error|RuntimeException localError)
       {
         throw localError;
       }
       catch (Throwable localThrowable)
       {
         throw new UndeclaredThrowableException(localThrowable);
       }
     }
     
     public final String toString()
       throws 
     {
       try
       {
         return (String)this.h.invoke(this, m2, null);
       }
       catch (Error|RuntimeException localError)
       {
         throw localError;
       }
       catch (Throwable localThrowable)
       {
         throw new UndeclaredThrowableException(localThrowable);
       }
     }
     
     public final void user()
       throws 
     {
       try
       {
         this.h.invoke(this, m3, null);
         return;
       }
       catch (Error|RuntimeException localError)
       {
         throw localError;
       }
       catch (Throwable localThrowable)
       {
         throw new UndeclaredThrowableException(localThrowable);
       }
     }
     
     public final int hashCode()
       throws 
     {
       try
       {
         return ((Integer)this.h.invoke(this, m0, null)).intValue();
       }
       catch (Error|RuntimeException localError)
       {
         throw localError;
       }
       catch (Throwable localThrowable)
       {
         throw new UndeclaredThrowableException(localThrowable);
       }
     }
     
     static
     {
       try
       {
         m1 = Class.forName("java.lang.Object").getMethod("equals", new Class[] { Class.forName("java.lang.Object") });
         m2 = Class.forName("java.lang.Object").getMethod("toString", new Class[0]);
         m3 = Class.forName("org.java.aop.UserService").getMethod("user", new Class[0]);
         m0 = Class.forName("java.lang.Object").getMethod("hashCode", new Class[0]);
         return;
       }
       catch (NoSuchMethodException localNoSuchMethodException)
       {
         throw new NoSuchMethodError(localNoSuchMethodException.getMessage());
       }
       catch (ClassNotFoundException localClassNotFoundException)
       {
         throw new NoClassDefFoundError(localClassNotFoundException.getMessage());
       }
     }
   }*/

    
    
}
