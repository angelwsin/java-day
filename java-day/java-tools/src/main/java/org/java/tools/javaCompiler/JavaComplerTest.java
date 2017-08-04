package org.java.tools.javaCompiler;

import java.io.File;
import java.util.Arrays;

import javax.tools.JavaCompiler;
import javax.tools.JavaCompiler.CompilationTask;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;

public class JavaComplerTest {
    
    
    @SuppressWarnings("rawtypes")
    public static void main(String[] args) throws Exception{
        
        //编译器
        JavaCompiler javaCompiler =  ToolProvider.getSystemJavaCompiler();
        
        //文件管理器
        StandardJavaFileManager fileManger = javaCompiler.getStandardFileManager(null, null, null);
        
        Iterable it =  fileManger.getJavaFileObjects(new File(""));
        
        CompilationTask task  = javaCompiler.getTask(null, fileManger, null, Arrays.asList("-d",""), null, it);
        task.call();
        fileManger.close();
        
    }

}
