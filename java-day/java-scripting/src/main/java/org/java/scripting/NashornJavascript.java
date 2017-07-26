package org.java.scripting;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;

//Java 8提供了一个新的Nashorn javascript引擎，它允许我们在JVM上运行特定的javascript应用。
//Nashorn javascript引擎只是javax.script.ScriptEngine另一个实现，而且规则也一样，允许Java和JavaScript互相操作
public class NashornJavascript {
    
    public static void main(String[] args) throws Exception{
        ScriptEngineManager manager = new ScriptEngineManager();
        ScriptEngine  engine =  manager.getEngineByName("JavaScript");
        System.out.println(engine.getClass().getName());
        System.out.println("Result:"+engine.eval(" function f(v){ return v+1;} f(1);"));
    }

}
