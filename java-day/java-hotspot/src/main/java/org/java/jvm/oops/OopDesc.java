package org.java.jvm.oops;

import org.java.jvm.oops.klass.Klass;

//oopDesc is the top baseclass for objects classes.  The {name}Desc classes describe
//the format of Java objects so the fields can be accessed from C++.
//oopDesc is abstract.
//(see oopHierarchy for complete oop class hierarchy)
//
//no virtual functions allowed


// 对象头         oop-klass 二分模型
public class OopDesc {
    
     private volatile MarkOopDesc _mark;
     
     /*
     union _metadata {
         Klass*      _klass;
         narrowKlass _compressed_klass; //压缩
       } _metadata;*/
     
     private Klass _klass;  //直线对象的类元数据
 //------------------------------------ 对象头    
     

}
