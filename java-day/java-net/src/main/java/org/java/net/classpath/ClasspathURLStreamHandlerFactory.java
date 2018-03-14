package org.java.net.classpath;

import java.net.URLStreamHandler;
import java.net.URLStreamHandlerFactory;

public class ClasspathURLStreamHandlerFactory implements URLStreamHandlerFactory{
	
	 private final  String CLASSPATH ="classpath";

	@Override
	public URLStreamHandler createURLStreamHandler(String protocol) {
		if(CLASSPATH.equals(protocol)){
			return new Handler();
		}
		return null;
	}

}
