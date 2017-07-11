package org.java.bio.socket;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;


// bio 
// 线程池伪异步
public class Server {
    
    static int corePoolSize   = Runtime.getRuntime().availableProcessors();
    
   static  ExecutorService executor  = new ThreadPoolExecutor(corePoolSize, corePoolSize*2, 30, TimeUnit.MILLISECONDS, new ArrayBlockingQueue<Runnable>(100));
    
     public static void main(String[] args) {
        
         
         try(ServerSocket  server = new ServerSocket(9034);){
             
             while(true){
                Socket socket =  server.accept();
                
                //接受客户端连接
                executor.execute(new IOHandler(socket));
             }
            
             
             
         }catch (Exception e) {
           e.printStackTrace();  
        }
         
         
    }
    
     //内核态/用户态
    
    public static class IOHandler implements Runnable{
        
        private  Socket socket;
        
        

        public IOHandler(Socket socket) {
            super();
            this.socket = socket;
        }



        @Override
        public void run() {
            
            
        }
        
        
    }

}
