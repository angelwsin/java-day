package org.java.bio;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileDescriptor;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * http://blog.csdn.net/cywosp/article/details/8767327
 *
 */
public class App 
{
    public static void main( String[] args )throws Exception
    {
        File file = new File(System.getProperty("user.dir")+"/src/main/resources/filedesc.txt");
        FileOutputStream out = new FileOutputStream(file,false);
        long handl  = -1;
        try{
            FileDescriptor  fd  =     out.getFD();
            Field  fds =  FileDescriptor.class.getDeclaredField("handle");
            fds.setAccessible(true);
            System.out.println(handl=(Long)fds.get(fd));
            out.write("hello".getBytes());
            // write不够，需要fsync 同步写文件刷新到磁盘
            out.getFD().sync();
        }catch (Exception e) {
        }finally {
            out.close();
        }
        FileDescriptor  fd  =     out.getFD();
        /**
         * handle 是 windows
         * fd     linux
         */
        Field  fds =  FileDescriptor.class.getDeclaredField("handle");
        Field  fdx  =  FileDescriptor.class.getDeclaredField("fd");
        fds.setAccessible(true);
        fdx.setAccessible(true);
        fds.set(fd, handl);
        Method method = FileDescriptor.class.getDeclaredMethod("set", int.class);
        method.setAccessible(true);
        method.invoke(fd,(int) handl);
        System.out.println(fdx.get(fd)+":"+fds.get(fd));
        
        out.write("hello".getBytes());
        
        
        
    }
}
