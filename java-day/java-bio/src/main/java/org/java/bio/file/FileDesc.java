package org.java.bio.file;

import java.io.File;
import java.io.FileDescriptor;
import java.io.FileOutputStream;
import java.lang.reflect.Field;

public class FileDesc {
    
    //bio cup轮询查询 i/o模块状态  是否准备就绪
    public static void main(String[] args) {
        
        //FileSystem 
        FileDescriptor  filedesc = new FileDescriptor();
        for(int i=0;i<2;i++){
            new Writer("writer-"+i).start();
            new Writer("writer-"+i).start();
        }
        
        
    }
    
    // windowns 通过 dllexp  查看 jre 下的 java.ddl 中的方法
    static class Writer  extends  Thread{
        
         public Writer(String name){
              super(name);
         }
        
        //linux 文件描述符的概念
        @Override
        public void run() {
            
            String[] str = new String[]{"hello","world","hello","world"};
        
            File file = new File(System.getProperty("user.dir")+"/src/main/resources/filedesc.txt");
            //FileOutputStream 线程不安全
            try(FileOutputStream out = new FileOutputStream(file,false);){
                FileDescriptor  fd  =     out.getFD();
                Field  fds =  FileDescriptor.class.getDeclaredField("handle");
                fds.setAccessible(true);
                System.out.println(fds.get(fd));
                for(String content : str){
                    out.write((getName()+content).getBytes());
                    System.out.println(System.currentTimeMillis()+":"+getName()+" writer :"+content);
                    Thread.sleep(100);
                }
            }catch (Exception e) {
                e.printStackTrace();
            } 
        }
    }

}
