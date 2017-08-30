package org.java.security;

import java.security.AlgorithmParameterGenerator;
import java.security.AlgorithmParameterGeneratorSpi;
import java.security.KeyStore;
import java.util.Base64;
import java.util.Base64.Encoder;

import javax.crypto.Cipher;
import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLEngine;
import javax.net.ssl.TrustManagerFactory;

import sun.security.jca.GetInstance;


//http://docs.oracle.com/javase/8/docs/technotes/guides/security/SunProviders.html#Introduction

//http://hubingforever.blog.163.com/blog/static/17104057920118981219705/
public class SecurityAlgorithm {
    
    /// built in knowledge of the engine types shipped as part of the JDK
    /*static {
        knownEngines = new HashMap<String,EngineDescription>();
        // JCA
        addEngine("AlgorithmParameterGenerator",        false, null);
        addEngine("AlgorithmParameters",                false, null);
        addEngine("KeyFactory",                         false, null);
        addEngine("KeyPairGenerator",                   false, null);
        addEngine("KeyStore",                           false, null);
        addEngine("MessageDigest",                      false, null);
        addEngine("SecureRandom",                       false, null);
        addEngine("Signature",                          true,  null);
        addEngine("CertificateFactory",                 false, null);
        addEngine("CertPathBuilder",                    false, null);
        addEngine("CertPathValidator",                  false, null);
        addEngine("CertStore",                          false,
                            "java.security.cert.CertStoreParameters");
        // JCE
        addEngine("Cipher",                             true,  null);
        addEngine("ExemptionMechanism",                 false, null);
        addEngine("Mac",                                true,  null);
        addEngine("KeyAgreement",                       true,  null);
        addEngine("KeyGenerator",                       false, null);
        addEngine("SecretKeyFactory",                   false, null);
        // JSSE
        addEngine("KeyManagerFactory",                  false, null);
        addEngine("SSLContext",                         false, null);
        addEngine("TrustManagerFactory",                false, null);
        // JGSS
        addEngine("GssApiMechanism",                    false, null);
        // SASL
        addEngine("SaslClientFactory",                  false, null);
        addEngine("SaslServerFactory",                  false, null);
        // POLICY
        addEngine("Policy",                             false,
                            "java.security.Policy$Parameters");
        // CONFIGURATION
        addEngine("Configuration",                      false,
                            "javax.security.auth.login.Configuration$Parameters");
        // XML DSig
        addEngine("XMLSignatureFactory",                false, null);
        addEngine("KeyInfoFactory",                     false, null);
        addEngine("TransformService",                   false, null);
        // Smart Card I/O
        addEngine("TerminalFactory",                    false,
                            "java.lang.Object");
    }*/
    
    
    public static void main(String[] args) throws Exception{
        
        //algorithm 算法的名称
        
        //type Engines
        // spiClass
        // algorithm或协议等
       //如 RSA 
        GetInstance.getInstance("KeyFactory", AlgorithmParameterGeneratorSpi.class, "RSA");
        AlgorithmParameterGenerator.getInstance("RSA");
        
        //查找算法的提供者 Providers.getProviderList()
        //jre\lib\security\java.security 中配置
        //遍历 Provider 得到 算法Service
        // Service  重要的两个属性
        //s.type = type;  Engine 引擎  可以为空
        //s.algorithm = stdAlg; 算法
        
        
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
        
        SSLEngine  engine =  ssLContext.createSSLEngine();
        
        
        
        Cipher cipher =  Cipher.getInstance("AES");
        
       
        
        
        
        
        
       
    }

    
    
    //ServiceMap  type.algorithm(protocol)
    
//    put("KeyFactory.RSA",
//            "sun.security.rsa.RSAKeyFactory");
//        put("Alg.Alias.KeyFactory.1.2.840.113549.1.1", "RSA");
//        put("Alg.Alias.KeyFactory.OID.1.2.840.113549.1.1", "RSA");
//
//        put("KeyPairGenerator.RSA",
//            "sun.security.rsa.RSAKeyPairGenerator");
//        put("Alg.Alias.KeyPairGenerator.1.2.840.113549.1.1", "RSA");
//        put("Alg.Alias.KeyPairGenerator.OID.1.2.840.113549.1.1", "RSA");
//
//        put("Signature.MD2withRSA",
//            "sun.security.rsa.RSASignature$MD2withRSA");
//        put("Alg.Alias.Signature.1.2.840.113549.1.1.2", "MD2withRSA");
//        put("Alg.Alias.Signature.OID.1.2.840.113549.1.1.2",
//            "MD2withRSA");
//
//        put("Signature.MD5withRSA",
//            "sun.security.rsa.RSASignature$MD5withRSA");
//        put("Alg.Alias.Signature.1.2.840.113549.1.1.4", "MD5withRSA");
//        put("Alg.Alias.Signature.OID.1.2.840.113549.1.1.4",
//            "MD5withRSA");
//
//        put("Signature.SHA1withRSA",
//            "sun.security.rsa.RSASignature$SHA1withRSA");
//        put("Alg.Alias.Signature.1.2.840.113549.1.1.5", "SHA1withRSA");
//        put("Alg.Alias.Signature.OID.1.2.840.113549.1.1.5",
//            "SHA1withRSA");
//        put("Alg.Alias.Signature.1.3.14.3.2.29", "SHA1withRSA");
//        put("Alg.Alias.Signature.OID.1.3.14.3.2.29", "SHA1withRSA");
//
//    }
//    put("Signature.MD5andSHA1withRSA",
//        "sun.security.ssl.RSASignature");
//
//    put("KeyManagerFactory.SunX509",
//        "sun.security.ssl.KeyManagerFactoryImpl$SunX509");
//    put("KeyManagerFactory.NewSunX509",
//        "sun.security.ssl.KeyManagerFactoryImpl$X509");
//    put("Alg.Alias.KeyManagerFactory.PKIX", "NewSunX509");
//
//    put("TrustManagerFactory.SunX509",
//        "sun.security.ssl.TrustManagerFactoryImpl$SimpleFactory");
//    put("TrustManagerFactory.PKIX",
//        "sun.security.ssl.TrustManagerFactoryImpl$PKIXFactory");
//    put("Alg.Alias.TrustManagerFactory.SunPKIX", "PKIX");
//    put("Alg.Alias.TrustManagerFactory.X509", "PKIX");
//    put("Alg.Alias.TrustManagerFactory.X.509", "PKIX");
//
//    put("SSLContext.TLSv1",
//        "sun.security.ssl.SSLContextImpl$TLS10Context");
//    put("SSLContext.TLSv1.1",
//        "sun.security.ssl.SSLContextImpl$TLS11Context");
//    put("SSLContext.TLSv1.2",
//        "sun.security.ssl.SSLContextImpl$TLS12Context");
//    put("SSLContext.TLS",
//        "sun.security.ssl.SSLContextImpl$TLSContext");
//    if (isfips == false) {
//        put("Alg.Alias.SSLContext.SSL", "TLS");
//        put("Alg.Alias.SSLContext.SSLv3", "TLSv1");
//    }
//
//    put("SSLContext.Default",
//        "sun.security.ssl.SSLContextImpl$DefaultSSLContext");
//
//    /*
//     * KeyStore
//     */
//    put("KeyStore.PKCS12",
//        "sun.security.pkcs12.PKCS12KeyStore");
}
