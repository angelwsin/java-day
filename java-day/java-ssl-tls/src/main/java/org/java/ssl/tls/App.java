package org.java.ssl.tls;

import java.security.KeyStore;

import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLEngine;
import javax.net.ssl.TrustManagerFactory;

/**
 * 查看 java-security
 *
 */
public class App 
{
    public static void main( String[] args )throws  Exception
    {
      //jdk 提供工具 keytool.exe
        //ssl/tsl
        SSLContext ssLContext =   SSLContext.getDefault();
        //客户端 使用公钥 对密码(或证书)加密 发送服务端
        KeyStore keyStore = KeyStore.getInstance("");
        /*CertificateFactory certFactory = CertificateFactory.getInstance("");
        certFactory.generateCertificate(inStream)
        keyStore.setCertificateEntry(alias, cert);*/
        keyStore.load(stream, password);
        KeyManagerFactory factory =  KeyManagerFactory.getInstance("");
        factory.init(keyStore, password);
        //服务端 使用私密 解密密码 以后通讯就使用这个密码加密
        TrustManagerFactory trustManager = TrustManagerFactory.getInstance("");
        trustManager.init(keyStore);
        ssLContext.init(factory.getKeyManagers(), trustManager.getTrustManagers(), null);
        ssLContext.getSocketFactory();
        SSLEngine  engine =  ssLContext.createSSLEngine();
    }
}
