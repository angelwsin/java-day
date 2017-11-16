package org.java.security.key.Generator;

import java.io.File;
import java.io.FileOutputStream;
import java.security.KeyPairGenerator;
import java.security.KeyStore;
import java.security.PrivateKey;

public class Key_Generator {
	
	
	public static void main(String[] args) throws Exception{
		KeyPairGenerator  keyGenerator  =  KeyPairGenerator.getInstance("RSA");
		keyGenerator.initialize(1024);
		
		KeyStore store = KeyStore.getInstance("JKS");
		store.load(null, "hello".toCharArray());
		KeyStore.ProtectionParameter protParam = new KeyStore.PasswordProtection("helloworld".toCharArray());
				     // get my private key
				    /* KeyStore.PrivateKeyEntry pkEntry = (KeyStore.PrivateKeyEntry)
				    		 store.getEntry("privateKeyAlias", protParam);
				     PrivateKey myPrivateKey = pkEntry.getPrivateKey();*/
				 
				     // save my secret key
				     javax.crypto.SecretKey mySecretKey = keyGenerator.generateKeyPair();
				     KeyStore.SecretKeyEntry skEntry =
				         new KeyStore.SecretKeyEntry(mySecretKey);
				     store.setEntry("secretKeyAlias", skEntry, protParam);
		//store.setKeyEntry("keys", keyGenerator.generateKey(), "helloworld".toCharArray(), null);
		FileOutputStream out = new FileOutputStream(new File(System.getProperty("user.dir")+"/rsa"));
		store.store(out, "hello".toCharArray());
		
		
	}

}
