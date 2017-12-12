package org.java.tools.jmap;

import java.util.ArrayList;
import java.util.List;

/*
 * jmap -histo [pid]

导出整个JVM 中内存信息
jmap -dump:format=b,file=文件名 [pid]

jhat是sun 1.6及以上版本中自带的一个用于分析JVM 堆DUMP 文件的工具，基于此工具可分析JVM HEAP 中对象的内存占用情况
jhat -J-Xmx1024M [file]
执行后等待console 中输入start HTTP server on port 7000 即可使用浏览器访问 IP：7000

eclipse Memory Analyzer
Eclipse 提供的一个用于分析JVM 堆Dump文件的插件。借助这个插件可查看对象的内存占用状况，引用关系，分析内存泄露等。

http://www.eclipse.org/mat/downloads.php
 */
public class JMapx {
	
	 static List a = new ArrayList<>();
	public static void main(String[] args) {
		/*try {
			JMap.main(args);
		} catch (Exception e) {
			e.printStackTrace();
		}*/
		
		new Thread(){
			@Override
			public void run() {
				while(true){
					try {
						a.add(new Object());
					} catch (Exception e) {
						// TODO: handle exception
					}
					
				}
			}
		}.start();
		
		try {
			Thread.sleep(Integer.MAX_VALUE);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
