package org.java.thread;

import java.io.File;
import java.io.IOException;
import java.lang.ProcessBuilder.Redirect;
import java.util.Map;

public class Processes {
	
	//This class is used to create operating system processes
	public static void main(String[] args) {
		//Runtime.getRuntime().exec 底层使用的ProcessBuilder
		
		try {
			Runtime.getRuntime().exec("myCommand" );
			Process p = new ProcessBuilder("myCommand", "myArg").start();
			
			ProcessBuilder pb =
					   new ProcessBuilder("myCommand", "myArg1", "myArg2");
					 Map<String, String> env = pb.environment();
					 env.put("VAR1", "myValue");
					 env.remove("OTHERVAR");
					 env.put("VAR2", env.get("VAR1") + "suffix");
					 pb.directory(new File("myDir"));
					 File log = new File("log");
					 pb.redirectErrorStream(true);
					 pb.redirectOutput(Redirect.appendTo(log));
					 Process px = pb.start();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
