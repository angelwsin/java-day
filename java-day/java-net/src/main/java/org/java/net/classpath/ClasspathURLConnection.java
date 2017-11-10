package org.java.net.classpath;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

public class ClasspathURLConnection extends URLConnection{

	protected ClasspathURLConnection(URL url) {
		super(url);
	}

	@Override
	public void connect() throws IOException {
		
		
	}
	
	
	@Override
	public InputStream getInputStream() throws IOException {
		String path = getURL().getPath();
		return Thread.currentThread().getContextClassLoader().getResourceAsStream(path);
	}

}
