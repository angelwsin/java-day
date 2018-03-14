package org.java.tools.keytool;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.security.Key;
import java.security.KeyStore;
import java.security.PrivateKey;
import java.security.cert.Certificate;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.Date;

import sun.security.tools.keytool.CertAndKeyGen;
import sun.security.x509.X500Name;

public class Keytool {
	
	
	@SuppressWarnings("restriction")
	public static void main(String[] args)throws Exception {
		/*try {
			//keytool -genkeypair -alias "test1" -keyalg "RSA" -keystore "test.keystore"
			
			sun.security.tools.keytool.Main.main(args);
		} catch (Exception e) {
			e.printStackTrace();
		}*/
		
		
		load();
	}
	
	public static void load()throws Exception{
		String ksfname    = "e:\\sso\\michael.keystore";
		String storePass  = "michaelpwd2";
		String alias      = "michaelkey";
		String keyPass    = "michaelpwd";
		String storetype = KeyStore.getDefaultType();
		System.out.println(storetype);
		KeyStore keyStore = KeyStore.getInstance(storetype);
		File ksfile = new File(ksfname);
		InputStream ksStream = new FileInputStream(ksfile);
		keyStore.load(ksStream, storePass.toCharArray());
		Certificate[] chain =  keyStore.getCertificateChain(alias);
		Key key = keyStore.getKey(alias, keyPass.toCharArray());
		System.out.println(key.getAlgorithm());
		System.out.println(chain[0].getPublicKey());
		
	}
	
	public void  store()throws Exception{
		
		//keytool -genkey -alias michaelkey -keyalg RSA -keysize 1024 -keypass michaelpwd -validity 365 -keystore g:\sso\michael.keystore -storepass michaelpwd2
		//命令解析
		//--genkey  -keyalg "RSA"
		String keyAlgName = "RSA";
		String sigAlgName = "SHA256WithRSA";
		String storePass  = "michaelpwd2";
		int    validity   = 365;
		String alias      = "michaelkey";
		String ksfname    = "e:\\sso\\michael.keystore";
		String keyPass    = "michaelpwd";
		String storetype = KeyStore.getDefaultType();
		KeyStore keyStore = KeyStore.getInstance(storetype);
		keyStore.load(null, storePass.toCharArray());
		File ksfile = new File(ksfname);
		OutputStream ksStream = new FileOutputStream(ksfile);
		// Create a certificate factory
		CertificateFactory cf = CertificateFactory.getInstance("X509");
		CertAndKeyGen keypair = new CertAndKeyGen(keyAlgName, sigAlgName, null);
		keypair.generate(2048);
		String name = "CN=country,ST=state,L=Locality,OU=OrganizationUnit,O=Organization"; 
        X500Name x500Name = new X500Name(name);
        PrivateKey privKey = keypair.getPrivateKey();
        X509Certificate[] chain = new X509Certificate[1];
        chain[0] = keypair.getSelfCertificate(
                x500Name, new Date(), validity*24L*60L*60L);
        keyStore.setKeyEntry(alias, privKey, keyPass.toCharArray(), chain);
        keyStore.store(ksStream, storePass.toCharArray());
	}

}
