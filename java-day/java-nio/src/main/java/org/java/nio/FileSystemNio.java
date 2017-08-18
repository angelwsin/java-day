package org.java.nio;

import java.io.File;
import java.io.FileInputStream;
import java.nio.file.FileSystem;

public class FileSystemNio {
    
    
    public static void main(String[] args)throws Exception {
        
        //WindowsFileSystem
        //ZipFileSystem
        FileSystem fs ;
        
        File file = new File("");
        FileInputStream is = new FileInputStream(file);
        //is.getChannel()
    }

}
