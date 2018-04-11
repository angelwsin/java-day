package org.java.aop.cglib;

import org.java.aop.UserService;
import org.java.aop.UserServiceImpl;

import net.sf.cglib.proxy.Enhancer;

/*CGLIB代理主要通过对字节码的操作，为对象引入间接级别，以控制对象的访问。我们知道Java中有一个动态代理也是做这个事情的，
那我们为什么不直接使用Java动态代理，而要使用CGLIB呢？答案是CGLIB相比于JDK动态代理更加强大，JDK动态代理虽然简单易用，但是其有一个致命缺陷是，
只能对接口进行代理。如果要代理的类为一个普通类、没有接口，那么Java动态代理就没法使用了。*/

//CGLIB底层使用了ASM（一个短小精悍的字节码操作框架）来操作字节码生成新的类。
//除了CGLIB库外，脚本语言（如Groovy何BeanShell）也使用ASM生成字节码。ASM使用类似SAX的解析器来实现高性能

public class Cglib {
	
	
	public static void main(String[] args) {
		
		Enhancer  echancer = new Enhancer();
		echancer.setSuperclass(UserServiceImpl.class);
		echancer.setCallback(new SayMethod());
		echancer.create();
	}

}
