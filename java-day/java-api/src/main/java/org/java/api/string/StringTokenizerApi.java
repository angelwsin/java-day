package org.java.api.string;

import java.util.StringTokenizer;

public class StringTokenizerApi {
    
    public static void main(String[] args) {
        String str  ="xxx:bbb";
        StringTokenizer tocken = new StringTokenizer(str, ":");
        while (tocken.hasMoreElements()) {
            Object object = (Object) tocken.nextElement();
            System.out.println(object);
            
        }
    }

}
