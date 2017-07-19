package org.java.instrumentation;

import java.lang.instrument.Instrumentation;

public class Angent {
    
    
    public static void agentmain(String agentArgs, Instrumentation inst){
         inst.addTransformer(new ClassFileTransformerx());
    }

}
