package org.java.classloader.hotdeploy;

import java.io.File;
import java.lang.reflect.Method;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;



/**
 * 热部署
 * 
 *
 */
public class HotDeploy {
    
    final  static String CONTENT = System.getProperty("user.dir")+File.separator+"deploy"+File.separator
                                    +File.separator+"classes"+File.separator;
    static HotDeployClassLoader classLoader = new HotDeployClassLoader();
    static CountDownLatch       latch = new CountDownLatch(1);
    
    static ConcurrentHashMap<String, Class<?>> klass = new ConcurrentHashMap<>();
    static volatile  boolean flag = false;

    public static void startListenner() {
        Thread thread = new Thread("class modify ") {

            @Override
            public void run() {
                for (; true;) {
                    String path = "org.java.service.Service".replace(".", "/")+".class";
                    File file = new File(CONTENT+path);
                    long old = file.lastModified();
                    try {
                        Thread.sleep(30000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    if (file.lastModified() != old) {

                        try {
                            Class<?> xlass = classLoader.loadClass("org.java.service.Service");
                            System.out.println("加载类" + xlass);
                            klass.put("org.java.service.Service", xlass);
                            flag = true;
                            break;

                        } catch (Exception e) {
                            // TODO: handle exception
                            e.printStackTrace();
                        }

                    }
                }

            }
        };
        thread.start();
    }

    public static void main(String[] args) throws Exception {
        HotDeployClassLoader classLoaderx = new HotDeployClassLoader();
        Class<?> xxx =  classLoaderx.loadClass("org.java.service.Service");
        try {
            Method method = xxx.getMethod("say", String.class);
            method.invoke(xxx.newInstance(), "heha");
        } catch (Exception e) {
            e.printStackTrace();
        }

        startListenner();
        while(!flag){
            Thread.sleep(1000);
        }
        Class<?> deploy = klass.get("org.java.service.Service");
        Method methodx = deploy.getMethod("say", String.class);
        methodx.invoke(deploy.newInstance(), "hot deploy");
        Thread.sleep(Integer.MAX_VALUE);
    }
    

}
