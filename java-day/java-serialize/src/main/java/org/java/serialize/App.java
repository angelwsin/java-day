package org.java.serialize;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

/**
 * 序列化协议:
 * 1.分隔符 如http协议使用 空格分割
 * 2.固定长度
 * 3.使用字段动态指定长度
 * 
 *
 */
public class App 
{
    public static void main( String[] args )throws Exception
    {
    	
    	/**
    	 * java 序列化和反序列化
    	 * 
    	 * 1.性能问题
    	 * 2.存储和传输效率问题
    	 * 3.需要实现serializable
    	 * 4.向后兼容性问题 serialVersionUID
    	 * 
    	 * 
    	 */
       
        //可以对每次序列化的内存空间复用  避免每次开辟空间的耗时
       // ByteArrayOutputStream out = new ByteArrayOutputStream();
    	FileOutputStream out = new FileOutputStream(new File(System.getProperty("user.dir"))+"/user.txt");
        ObjectOutputStream output  = new ObjectOutputStream(out);
        User user = new User();
        user.setUserName("zhangsan");
        //user.setPassword("26271621");
        output.writeObject(user);
        
    /*   byte[] x =  out.toByteArray();
       for(byte b : x){
    	  System.out.println(Integer.toHexString(Byte.toUnsignedInt(b)));//  8421
       }*/
       
       //java 的序列化协议
       //开头 魔数版本..........结束标志
        //java  serialize
        
        //接口 serializable
        
        //序列化协议使用  分割 
        
        /*序列化对象可以复写方法实现序列化
         * private void writeObject(java.io.ObjectOutputStream out)
        *     throws IOException
        * private void readObject(java.io.ObjectInputStream in)
        *     throws IOException, ClassNotFoundException;
        * private void readObjectNoData()
        *     throws ObjectStreamException;*/
        
        
        /**
         * 序列化辅助类
         * ObjectStreamClass   针对序列化对象
         * 
         * ObjectStreamField   针对序列化属性
         * 
         */
        
        
    }
}
