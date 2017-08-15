package com.jvm.class_File_Format;

import java.io.File;

import java.io.FileInputStream;
import java.io.IOException;



/**
 * 
 * 每一个方法的调用 都有零个或多个 异常处理handle
 * 
 * 使用 异常处理表表示
 * 
 * 如
 * Exception table:
        from    to  target type
           14    50    50   any
           10    72    72   Class java/io/IOException
           10    72    80   Class java/lang/Exception
 * 
 * 根据异常表搜索 匹配的 的 exception handle
 * 
 * 
 * 如果没有找到 匹配的 exception handle
 * 
 * 当前方法会突然完成，当前方法的 本地变量表和操作数栈 都将被丢弃，栈帧退栈
 * 恢复 调用方法，异常在调用者上下文中继续抛出，继续方法链的调用
 * 当在调用链的最顶端没有找到匹配的 exception handle  当前的线程
 * 将被异常抛出而终止
 * 
 *
 */
public class Exceptions {
    
    /**
     * An exception in the Java Virtual Machine is represented by an instance of the class
      Throwable or one of its subclasses
     */
    
    
    public static void main(String[] args) {
        /**
         * Throwable
         * --Error
         * 
         * --Exception
         *    --RuntimeException
         *    --Exception (编译时异常 需要 throws )
         */
        
        
        
        
        /*public final java.io.FileDescriptor getFD() throws java.io.IOException;
        descriptor: ()Ljava/io/FileDescriptor;
        flags: ACC_PUBLIC, ACC_FINAL
        Code:
          stack=2, locals=1, args_size=1
             0: aload_0
             1: getfield      #113                // Field fd:Ljava/io/FileDescriptor;
             4: ifnull        12
             7: aload_0
             8: getfield      #113                // Field fd:Ljava/io/FileDescriptor;
            11: areturn
            12: new           #66                 // class java/io/IOException
            15: dup
            16: invokespecial #133                // Method java/io/IOException."<init>":()V
            19: athrow
            
            */
    }
    
    //exception handle table matche
    public void exception(){
        
        File file = new File("");
        try (FileInputStream is = new FileInputStream(file);){
           
        } catch (IOException e) {
           e.printStackTrace();
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
    
   /* 
    * exception handler is able to
      handle, and specifies the location of the code that is to handle that exception
    * 
    Exception table:
        from    to  target type
           14    50    50   any
           10    72    72   Class java/io/IOException
           10    72    80   Class java/lang/Exception
    */

}
