package org.java.classloader.loadResources;

import java.lang.reflect.Field;
import java.net.URL;
import java.util.List;

import sun.misc.URLClassPath;

public class UCP {
	
	
	public static void main(String[] args) throws Exception{
		
		ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
		System.out.println(classLoader);
		Field field = classLoader.getClass().getDeclaredField("ucp");
		field.setAccessible(true);
		URLClassPath classpath  = (URLClassPath) field.get(classLoader);
		Field loaders = classpath.getClass().getDeclaredField("loaders");
		loaders.setAccessible(true);
		
		List<?> loadess  = (List<?>) loaders.get(classpath);
		System.out.println(loadess.size());
		URL url = classpath.findResource("stylesheet.css", false);
		System.out.println(url.toString());
		Class<?> clazz = Class.forName("sun.misc.URLClassPath$JarLoader");
		
		
		
	}

}
