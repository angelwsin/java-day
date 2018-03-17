package org.java.serialize;

import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

/**
 * 
 * @author wu.qiang
 * java.io.ObjectStreamConstants java序列化得常量
 * 
 * class反射得到属性除去修饰符是Modifier.STATIC | Modifier.TRANSIENT 的属性
 * 
 * 序列化的协议
 * 魔数版本(header)TC_OBJECT(序列化的类型)desc(类型描述如TC_CLASSDESC,ClassName,SerialVersionUID)
 * 
 *
 */
public class EnCoder {
	
	
	public static void main(String[] args) {
		try(FileOutputStream out = new FileOutputStream(new File(System.getProperty("user.dir"))+"/userx.txt");
		    ObjectOutputStream output  = new ObjectOutputStream(out);) {
			SuperUser user = new User();
	        user.setUserName("zhangsan");
	        User userx = (User) user;
	        userx.setUserName("lisi");
	       // user.setPassword("26271621");
	        output.writeObject(userx);
		} catch (Exception e) {
			e.printStackTrace();
		}
        
	}

}
