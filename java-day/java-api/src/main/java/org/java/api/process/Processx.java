package org.java.api.process;

import java.io.File;
import java.lang.ProcessBuilder.Redirect;
import java.util.Map;

public class Processx {
	
	public static void main(String[] args)throws Exception {
		
		Runtime.getRuntime().exec("java");
		
		//instance manages a collection of process attributes
		ProcessBuilder pb = new ProcessBuilder("myCommand", "myArg1", "myArg2");
		Map<String, String> env = pb.environment();
		env.put("VAR1", "myValue");
		env.remove("OTHERVAR");
		env.put("VAR2", env.get("VAR1") + "suffix");
		pb.directory(new File("myDir"));
		File log = new File("log");
		pb.redirectErrorStream(true);
		pb.redirectOutput(Redirect.appendTo(log));
		Process p = pb.start();
		
	}

}
