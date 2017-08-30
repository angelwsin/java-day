package org.java.tools.javaCompiler;

import java.io.File;

import javax.tools.JavaCompiler;
import javax.tools.JavaCompiler.CompilationTask;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;

// 动态编译
@SuppressWarnings("restriction")
public class JavaComplerTest {
    
    
    @SuppressWarnings({ "rawtypes" })
    public static void main(String[] args) throws Exception{
        
        //编译器
        JavaCompiler javaCompiler =  ToolProvider.getSystemJavaCompiler();
        
        
        //文件管理器
        StandardJavaFileManager fileManger = javaCompiler.getStandardFileManager(null, null, null);
        
        Iterable it =  fileManger.getJavaFileObjects(new File("D:\\git\\java-day\\java-day\\java-tools\\src\\test\\java\\org\\java\\tools\\Hello.java"));
        //Arrays.asList("-d","")
        //CompilationTask 底层调用   javac 命令编译
        CompilationTask task  = javaCompiler.getTask(null, fileManger, null,null , null, it);
        Boolean issu = task.call();
        System.out.println(issu);
        fileManger.close();
        
    }

}
