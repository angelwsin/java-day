package com.service.schedule;

import java.util.List;
import java.util.concurrent.ExecutorService;

import org.springframework.beans.factory.InitializingBean;

public abstract class Processor  implements InitializingBean{
    
    
      private  ExecutorService  executor;
      
      protected  int  maxRetry;
    
    
    
    
         public void afterPropertiesSet() throws Exception {
             Cmd cmd =  getClass().getAnnotation(Cmd.class);
             if(cmd==null) return;
             CmdUtils.addProcessor(cmd.value(), this);
        }
         
         
       
         
        
        public void  doRun(Command command){
            
            try {
                
                process(command);
                //update success
            } catch (Exception e) {
                command.setRetry(command.getRetry()+1);
               if(maxRetry<= command.getId()) {
                   //update  fail
               }
            }
        }
        
        
        
        
        
        
        public abstract void process(Command command);
        
        
        public void  run(List<Command> cmdList){
           for(Command cmd : cmdList){
               executor.execute(()->{
                   doRun(cmd);  
               });
           }
            
        }
         
         
         
    
    
    
    

}
