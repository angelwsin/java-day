package org.java.bio.file.system;

import java.io.File;

public class FileSystem {
    
    
    public static void main(String[] args) {
        
        //java.nio.file.FileSystem  文件系统的抽象 针对不同的平台提供不同的Provider
        
        
        //java.io.FileSystem fs = java.io.FileSystem.getFileSystem();
      //windows 平台
        //Win32FileSystem   WinNTFileSystem
        
        
        File file = new File("");
        
        //File的操作 依赖于 FileSystem的支持
        
        //辅助类有
        //Paths
        //Files
        
        
    }

}
