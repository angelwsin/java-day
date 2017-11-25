package org.java.classloader;

import java.net.URL;
import java.net.URLClassLoader;

public class DefUrlClassLoader extends URLClassLoader {

	public DefUrlClassLoader(URL[] urls) {
		super(urls);
	}

	//jvm 启动时由根类加载器加载  sun.boot.class.path 路径下的类
	// Launcher 类属于根类加载器的路径下的类被加载
	// 同时初始化 ext,system类加载器 详细代码看Launcher的构造方法
	
	//可以查看 ext,system 类加载器都继承了 URLClassLoader
	@Override
	protected Class<?> findClass(String name) throws ClassNotFoundException {
		// TODO Auto-generated method stub
		//类文件的读取从ucp中读取
		return super.findClass(name);
	}
}
