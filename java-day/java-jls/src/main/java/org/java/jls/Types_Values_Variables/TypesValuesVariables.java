package org.java.jls.Types_Values_Variables;

import java.io.Serializable;
import java.util.List;

public class TypesValuesVariables {
	
	
	/**
	 * java 静态类型的语言，意味着任何变量和表达式在编译时期已经确定 java 又是一个强类型语言，那是因为类型限制变量可以容纳或表达式可以产生的值
	 * 限制这些值支持的操作，并确定其含义操作
	 * 
	 * 强类型 静态类型 可以在编译时 检查其错误
	 * 
	 * 
	 * 一.Kinds of Types and Values java 语言有两种类型： 1.基础类型 (primitive types) 2.引用类型
	 * (reference types)
	 * 
	 * 二. Primitive Types and Values
	 * 
	 * PrimitiveType: 
	 * {Annotation} NumericType 
	 * {Annotation} boolean 
	 * NumericType:IntegralType FloatingPointType 
	 * IntegralType: (one of) byte(1字节) short(2) int(4) long(8) char(2)
	 * FloatingPointType: (one of) float(4) double(8)
	 * 
	 *  注意：在进行拆箱时的NullPointerException 
	 *  
	 *三.Reference Types and Values   引用类型
	 *
	 *of reference types: class types , interface types ,
	 *type variables, and array types .
	 *
	 * 1.Objects
	 *      An object is a class instance or an array.
	 *      
	 *   创建对象包括隐式和显式创建
	 *   显式   如      new
	 *   隐式  如      当字符串连接运算符时，隐式创建一个新的类实例用于非常量表达式，导致一个新的对象的String类型,编译器会使用
	 *           StringBuilder 进行优化连接，返回一个新的对象的String
	 *   自动装箱   基本类型
	 *   
	 *   每一个对象都有一个 monitor 可以使用synchronized方法和 synchronized statement 来防止对象状态的并发控制
	 *   
	 * 2. Class Object
	 * 
	 * The class Object is a superclass of all other classes
	 * 
	 * 3.Class String
	 * Instances of class String represent sequences of Unicode code points.
     *   A String object has a constant (unchanging) value.
     *   String literals are references to instances of class String
     *   The string concatenation operator +  implicitly creates a new String
     *   object when the result is not a constant expression .
	 * 
	 * 4.When Reference Types Are the Same
	 * 
	 *   run-time type  类的加载器一致才认为是一致的run-time type
	 *   
	 * 
	 * 三.Type Variables 类型的变量  泛型
	 * 
	 * A type variable is an unqualified identifier used as a type in class, interface, method,
     * and constructor bodies.
     * A type variable is introduced by the declaration of a type parameter of a generic
     * class, interface, method, or constructor 
	 *  
	 * 所有类型变量声明有一个类型参数的绑定，如果没有声明没有绑定就是Object
	 * Every type variable declared as a type parameter has a bound. If no bound is
     *   declared for a type variable, Object is assumed.
     *    
     *TypeBound:
     * extends TypeVariable
     * extends ClassOrInterfaceType {AdditionalBound}
     * AdditionalBound:
     *    & InterfaceType
     *    
     *    
     * 四.Parameterized Types
     * 
     * A class or interface declaration that is generic defines a set of parameterized types
     *   
     *   
	 */
	
	public static void main(String[] args) {
		String x[] = new String[]{};
		@Deprecated int x1 = 0;
	}
	
	class TypeVariables<T extends Serializable & Comparable<T>>{
		
		private List<? extends Class<?>> list ;
	}

}
