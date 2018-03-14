package org.java.security.JCA;

import java.security.AccessControlContext;
import java.security.AccessController;
import java.security.Key;
import java.security.PrivilegedAction;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;

/**
 * 
 * The Java platform defines a set of APIs spanning major security areas, including cryptography, public key infrastructure,
 *  authentication, secure communication, and access control. These APIs allow developers to easily integrate security mechanisms into their application code. 
 * The Java Cryptography Architecture (JCA) and its Provider Architecture is a core concept of the Java Development Kit (JDK)
 * Java平台定义了一系列跨越主要安全领域的API，包括密码学，公共密钥基础设施，认证，安全通信和访问控制。 这些API允许开发人员将安全机制轻松集成到应用程序代码中。 
 *  Java密码体系结构（JCA）及其提供程序体系结构是Java开发工具包（JDK）的核心概念。
 */
public class JCA_JavaCryptographyArchitecture 
{
    public static void main( String[] args )throws Exception
    {
        
       
        
        //Provider Architecture
        //providers ("Sun", "SunJSSE", "SunJCE", "SunRsaSign") 
        KeyGenerator.getInstance("DES", "SunJCE"); // not recommended
        KeyGenerator  keyGenerator  =  KeyGenerator.getInstance("DES");// recommended
        // algorithm/mode/padding
        // If the mode/padding are omitted, the SunJCE and SunPKCS11 providers use ECB as the 
        // default mode and PKCS5Padding as the default padding for many symmetric ciphers.
        Cipher aes = Cipher.getInstance("DES");
        KeyGenerator keyGen =  KeyGenerator.getInstance("DES");
        keyGen.init(56);
        Key key = keyGen.generateKey();
        aes.init(Cipher.ENCRYPT_MODE,key);
        byte[] input = "hello".getBytes();
        byte[] b = aes.doFinal(input);
        Cipher aesd = Cipher.getInstance("DES");
        aesd.init(Cipher.DECRYPT_MODE, key);
        byte[] bd = aesd.doFinal(b);
        System.out.println(new String(bd));
        
        
        
    }
}
