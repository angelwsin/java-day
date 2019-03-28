package org.java.serialize.java;

import org.java.serialize.SuperUser;
import org.java.serialize.User;

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
 *
 * java序列化的组成部分
 *
 * header (由魔数版本组成)
 *
 * 数据部分
 * 标识符(如对象的TC_OBJECT 对象的需要继续写类型描述如TC_CLASSDESC,ClassName,SerialVersionUID)
 *   1)TC_STRING|TC_LONGSTRING 字符串直接写 长度和value
 *   2)TC_ARRAY 数组的情况下 写ClassDesc 长度和value(原子类型直接写,对象类型调用对象的写)
 *   3）TC_ENUM 枚举情况下   写ClassDesc  枚举的name写字符串
 *   4）TC_OBJECT 写对象    写ClassDesc  写SerialData（一直往符类查找直到找到没有实现serializable的父类得到ClassDataSlot集合然后写数据）
 *
 *
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
