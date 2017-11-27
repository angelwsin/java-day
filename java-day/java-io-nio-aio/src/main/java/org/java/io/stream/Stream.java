package org.java.io.stream;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;
import java.io.PushbackInputStream;
import java.io.SequenceInputStream;
import java.net.URL;
import java.util.zip.ZipOutputStream;

import javax.crypto.Cipher;
import javax.crypto.CipherOutputStream;

//字节流   计算机存储的都是字节流
//字符流    看到的字符流

//字节流的 设计模式  装饰者模式
// bio  半双工 
public class Stream {
	
	
	public static void main(String[] args)throws Exception {
		
		    //文件处理的流 
		   URL url = Stream.class.getClassLoader().getResource("config.properties");
	       File file = new File(url.getPath());
	       
		   FileInputStream fileInputStream = new FileInputStream(file);
		   
		   //内存流
		   byte[] buf = new byte[1024];
		   ByteArrayInputStream  byteArrayInputStream = new ByteArrayInputStream(buf);
		   
		   //管道流
		   PipedInputStream pipedInputStream = new PipedInputStream();
		   PipedOutputStream pipedOutputStream = new PipedOutputStream();
		   //顺序流
		   SequenceInputStream sequenceInputStream = new SequenceInputStream(fileInputStream, byteArrayInputStream);
		   
		   //缓存流
		   BufferedInputStream  bufferedInputStream  = new BufferedInputStream(fileInputStream);
		   
		   //数据流 Java data types
		   DataInputStream  dataInputStream  = new DataInputStream(fileInputStream);
		   
		  //对象流  对象序列化  查看  java-serialize
		  // ObjectInputStream  objectInputStream = new ObjectInputStream(fileInputStream);
		   
		   //“推回”或“未读”一个字节的能力
		   PushbackInputStream pushbackInputStream = new PushbackInputStream(fileInputStream);
		   byte[] b = new byte[1];
		   pushbackInputStream.unread(b);
		   byte[] bx = new byte[1024];
		   pushbackInputStream.read(bx);
		   System.out.println(new String(bx));
		   
		   //CipherInputStream  
		   //  DeflaterInputStream, InflaterInputStream  压缩，解压
		   
		   //InflaterInputStream 解压
		   //GZIPInputStream, ZipInputStream
		   //DigestInputStream
		   
		   
		   //输出流
		   //文件输出流
		   FileOutputStream fileOutputStream  = new FileOutputStream(file);
		   
		   
		   //秘钥
		   Cipher ci  =  Cipher.getInstance("AES");
		   CipherOutputStream cipher  = new CipherOutputStream(fileOutputStream, ci);
		   
		   //Deflater 压缩  当数据量大可以压缩，减少带宽的占用
		   //GZIPOutputStream, ZipOutputStream
		   File zipFile = new File(System.getProperty("user.dir")+"/out.zip");
		   ZipOutputStream zipOutPutStream = new ZipOutputStream(new FileOutputStream(zipFile));
		   
		   
		   
		   
		   
		   
		   
		   
		   
		
	}

}
