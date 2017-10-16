package org.java.tools.jar;

import sun.tools.jar.Main;

//jar

/*JAR file is a file format based on the popular ZIP file format and is used for aggregating many files into one. 
A  JAR file is essentially a zip file that contains an optional META-INF directory. A JAR file can be created by the command-line jar tool,
or by using the  java.util.jar API in the Java platform. There is no restriction on the name of a JAR file,
it can be any legal file name on a particular platform.*/
public class Jar {
    
    
    public static void main(String[] args) {
        Main jar  = new Main(System.out, System.err, "jar");
    }

}
