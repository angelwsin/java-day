package org.java.classloader.hotdeploy;

import java.io.FileInputStream;

import org.apache.commons.io.IOUtils;

public class HotDeployClassLoader extends ClassLoader{
    
    
    public HotDeployClassLoader(ClassLoader parent) {
        super(parent);
    }
    
    
     public HotDeployClassLoader() {
        // TODO Auto-generated constructor stub
    }
    
    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        // TODO Auto-generated method stub
        String path = name.replace(".", "/")+".class";
        try(FileInputStream input = new FileInputStream(HotDeploy.CONTENT+path);){
            byte[] code = IOUtils.toByteArray(input);
           return defineClass(name, code, 0, code.length);
        }catch (Exception e) {
            // TODO: handle exception
        }
        
        return null;
    }
    
    
    

    
    
    public static void main(String[] args)throws Exception {
        HotDeployClassLoader classLoader = new HotDeployClassLoader();
        Class<?> xclass = classLoader.loadClass("org.java.service.Service");
        System.out.println(xclass);
    }
  
}
