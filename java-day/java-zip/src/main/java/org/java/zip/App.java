package org.java.zip;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )throws Exception
    {
        ZipFile zipFile = new ZipFile(new File(System.getProperty("user.dir")+"/zip/xx.zip"));
        Enumeration<? extends ZipEntry> zipEnum = zipFile.entries();
        while(zipEnum.hasMoreElements()){
            ZipEntry zipEntry = zipEnum.nextElement();
            InputStream is = zipFile.getInputStream(zipEntry);
            File file = new File(System.getProperty("user.dir")+"/unzip/"+zipEntry.getName());
            if(!file.exists()) file.createNewFile();
            FileOutputStream out = new FileOutputStream(file);
            byte[] b = new byte[is.available()];
            is.read(b);
            out.write(b);
            out.close();
            is.close();
        }
    }
}
