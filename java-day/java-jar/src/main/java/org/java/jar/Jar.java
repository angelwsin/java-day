package org.java.jar;

import java.io.File;
import java.util.Map;
import java.util.jar.Attributes;
import java.util.jar.JarFile;
import java.util.jar.Manifest;
import java.util.jar.Pack200;

/*JAR file is a file format based on the popular ZIP file format and is used for aggregating many files into one. 
A  JAR file is essentially a zip file that contains an optional META-INF directory. A JAR file can be created by the command-line jar tool,
or by using the  java.util.jar API in the Java platform. There is no restriction on the name of a JAR file,
it can be any legal file name on a particular platform.*/

//http://docs.oracle.com/javase/8/docs/technotes/guides/jar/jarGuide.html
public class Jar {
    
     public static void main(String[] args)throws Exception {
       
         //pack200    对jar的压缩工具
         
         Pack200.Packer localPacker = Pack200.newPacker();
         
             JarFile jarFile = new JarFile(new File(System.getProperty("user.dir")+"/jar/hadoop-hdfs-0.0.1-SNAPSHOT.jar"));
             Manifest mainfest = jarFile.getManifest();
             Attributes attrs = mainfest.getMainAttributes();
             
             for(Map.Entry<Object,Object> entry :attrs.entrySet()){
                  System.out.println(entry.getKey()+"="+entry.getValue());
             }
         
         
    }

}
