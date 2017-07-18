package org.java.jvm.oops;

import org.java.jvm.oops.klass.Klass;

//已加载的java类 创建一个 instanceKlass对象
public class InstanceKlass extends Klass{

	
	 int             _nonstatic_oop_map_size;// size in words of nonstatic oop map blocks
	 
	 //实例数据的排列顺序
	 //longs/doubles  ints shorts/chars bytes/booleans oops  相同宽度的字段分配到一起
}




//ValueObjs embedded in klass. Describes where oops are located in instances of
//this klass.

//java对象的实例域
class OopMapBlock{
	
	
}

/**
 * class 字节码
 * 
 *   魔术
 *   主版本
 *   次版本
 *   常量池
 *   访问限制
 *   this
 *   super class
 *   super interface
 *   field
 *   method
 *   属性
 */



  /**
   * .class     加载                 验证，准备（静态属性分配默认值）,链接（符号引用转换为直接引用)         初始化阶段
   * 
   * 
   * 跟踪类的加载
   * +TraceClassLoading
   */
