package org.java.security.cryptography;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.security.Key;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.MessageDigest;
import java.security.PrivateKey;
import java.security.Signature;
import java.security.cert.Certificate;
import java.security.cert.CertificateFactory;
import java.security.spec.PKCS8EncodedKeySpec;
import java.util.Base64;
import java.util.Date;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;

import sun.security.x509.AlgorithmId;
import sun.security.x509.CertificateAlgorithmId;
import sun.security.x509.CertificateSerialNumber;
import sun.security.x509.CertificateValidity;
import sun.security.x509.CertificateVersion;
import sun.security.x509.CertificateX509Key;
import sun.security.x509.X500Name;
import sun.security.x509.X509CertImpl;
import sun.security.x509.X509CertInfo;

//java中密码的使用Cipher
public class Cryptography {

	
	public static void main(String[] args)throws Exception {
		// algorithm/mode/padding
        // If the mode/padding are omitted, the SunJCE and SunPKCS11 providers use ECB as the 
        // default mode and PKCS5Padding as the default padding for many symmetric ciphers.
		//DES 加密 解密
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
        
        
        
        //RSA
        Cipher rsa =  Cipher.getInstance("RSA");
        KeyPairGenerator keyPair = KeyPairGenerator.getInstance("RSA");
        keyPair.initialize(1024);
        KeyPair keyP = keyPair.generateKeyPair();
        System.out.println(Base64.getEncoder().encodeToString(keyP.getPrivate().getEncoded()));
        rsa.init(Cipher.ENCRYPT_MODE, keyP.getPrivate());
        byte[] inputx = "hello".getBytes();
        byte[] bx = rsa.doFinal(inputx);
        Cipher rsax =  Cipher.getInstance("RSA");
        rsax.init(Cipher.DECRYPT_MODE, keyP.getPublic());
        byte[] bdx = rsax.doFinal(bx);
        System.out.println(new String(bdx));
        
        
        //摘要 ,签名 防止被篡改
        MessageDigest msgDig = MessageDigest.getInstance("MD5");
        byte[] ms =  msgDig.digest("hello".getBytes());
        System.out.println(toHex(ms));
        System.out.println(Base64.getEncoder().encodeToString(ms));
        
        //RSA 也可以用于签名
        Signature sign = Signature.getInstance("MD5withRSA");
        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
        PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(keyP.getPrivate().getEncoded());  
        PrivateKey pri = keyFactory.generatePrivate(keySpec);
        sign.initSign(pri);
        sign.update("hello".getBytes());
        System.out.println(Base64.getEncoder().encodeToString(sign.sign()));
        
        //证书
        //http://lujin55.iteye.com/blog/1436758
        CertificateFactory certFactory = CertificateFactory.getInstance("X.509");
       // FileInputStream  is = new FileInputStream(new File(System.getProperty("user.dir")+"/cert"));
        //ByteArrayInputStream certInput= new ByteArrayInputStream(keyP.getPrivate().getEncoded());
        /*证书信息
        Version：证书版本号 
        SerialNumber：序列号 
        algorithm_Id：签名算法 
        subject：主体名 
        key：公钥 
        issuer：签发者 
        */
        //X509就是数字证书的标准
        //CertAndKeyGen certAndKeyGen = new CertAndKeyGen("RSA", "MD5withRSA");
       // certAndKeyGen.getSelfCertificate(arg0, arg1, arg2)  查看此方法可以看到 keytool中证书的生成
        String name = "CN=country,ST=state,L=Locality,OU=OrganizationUnit,O=Organization"; 
        X500Name x500Name = new X500Name(name);
        X509CertInfo x509  = new X509CertInfo();
        x509.set(X509CertInfo.VERSION, new CertificateVersion(CertificateVersion.V3));
        x509.set(X509CertInfo.SERIAL_NUMBER, new CertificateSerialNumber((int) (System.currentTimeMillis() / 1000L))); 
        AlgorithmId algID = AlgorithmId.get("MD5WithRSA"); 
        x509.set(X509CertInfo.ALGORITHM_ID, new CertificateAlgorithmId(algID));  
        x509.set(X509CertInfo.SUBJECT, x500Name);  
        x509.set(X509CertInfo.KEY, new CertificateX509Key(keyP.getPublic()));  
        CertificateValidity interval = new CertificateValidity(new Date(), new Date(System.currentTimeMillis() + 365000000000L));  
        x509.set(X509CertInfo.VALIDITY, interval);  
        x509.set(X509CertInfo.ISSUER, x500Name);  
        X509CertImpl x509CertImpl = new X509CertImpl(x509);  
        x509CertImpl.sign(keyP.getPrivate(), "MD5WithRSA");  
        File certx = new File(System.getProperty("user.dir")+"/certx");
        x509CertImpl.encode(new FileOutputStream(certx));
        
        //加载证书
        Certificate cerx =  certFactory.generateCertificate(new FileInputStream(certx));
        System.out.println(cerx.getPublicKey());
        
        
        
        
    
        
	}
	
	/** 
     * 将16位byte[] 转换为32位String 
     *  
     * @param buffer 
     * @return 
     */  
    private static String toHex(byte buffer[]) {  
        StringBuffer sb = new StringBuffer(buffer.length * 2);  
        for (int i = 0; i < buffer.length; i++) {  
            sb.append(Character.forDigit((buffer[i] & 240) >> 4, 16));  
            sb.append(Character.forDigit(buffer[i] & 15, 16));  
        }  
  
        return sb.toString();  
    }  
}
