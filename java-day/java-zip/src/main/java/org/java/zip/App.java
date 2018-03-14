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
        
       /* Adler-32是Mark Adler发明的校验和算法，和32位CRC校验算法一样，都是保护数据防止意外更改的算法，但是这个算法较容易被伪造，所以是不安全的保护措施。
        * 但是比CRC好点的是，它计算的很快。这个算法那是从Fletcher校验和算法中修改过来的，原始的算法形式略快，但是可依赖性并不高。
        Adler-32的一种滚动哈希版本被用在了rsync工具中*/
    }
}
