package org.java.classloader.ProtectionDomain;

import java.net.URL;
import java.security.CodeSource;

public class ProtectionDomain {
	
	public static void main(String[] args) {
		
		CodeSource codeSource = ProtectionDomain.class.getProtectionDomain().getCodeSource();
		URL url = codeSource.getLocation();
		//转换协议 file:  jar:
		System.out.println(url.toExternalForm());
	}

}
