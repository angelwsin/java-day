package com.jvm.class_File_Format;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;

/**
 * every constructor written in the Java programming language (JLS §8.8) appears as an instance initialization method that has the special name <init>
 * 
 * @author Administrator
 * 
 *         class interface 的初始化
 *          The initialization method of a class or interface has the special name <clinit>
 *
 */
public class SpecialMethods {
    
    
    //jdk 
    public static void main(String[] args) {
        MethodHandles.Lookup lookup =  MethodHandles.lookup();
       
        try {
            MethodHandle methodHandle = lookup.findVirtual(SpecialMethods.class, "method", MethodType.methodType(int.class, int.class));
            int result = (int) methodHandle.invokeExact(new SpecialMethods(), 5);
            System.out.println(result);
        } catch (Throwable e) {
            e.printStackTrace();
        }
        
    }

    
    public int  method(int x){
        
        return x;
    }
}
