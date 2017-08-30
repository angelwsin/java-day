package com.service.schedule;

import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class CmdUtils {
    
    
    public static ConcurrentHashMap<String, Processor> proccessor = new ConcurrentHashMap<>();
    
    public static void  addProcessor(String key,Processor processor){
        proccessor.put(key, processor);
    }
    
    
    public static Set<String> getProcessorKey(){
         return proccessor.keySet();
    }
    
    

}
