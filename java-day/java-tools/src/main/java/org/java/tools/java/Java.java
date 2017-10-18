package org.java.tools.java;

import java.util.Map;

public class Java {
    
    
    public static void main(String[] args) {
    	
       //
    	System.out.println(System.getenv("_JAVA_VERSION_SET"));
    	Map<String,String> evn = System.getenv();
    	evn.forEach((String k,String v)->{
    		System.out.println(k+":"+v);
    		
    	});
    }

}
