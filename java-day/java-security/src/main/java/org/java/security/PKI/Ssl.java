package org.java.security.PKI;

import java.io.File;
import java.io.FileInputStream;
import java.net.URL;
import java.nio.ByteBuffer;
import java.security.KeyStore;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLEngine;

//The following algorithms are available in the SunJSSE provider:
public class Ssl {
	
	
	public static void main(String[] args) throws Exception{
		
		
		String ksfname    = "e:\\sso\\michael.keystore";
		String storePass  = "michaelpwd2";
		String keyPass    = "michaelpwd";
		
		SSLContext sslContext = SSLContext.getInstance("SSLv3");
		KeyManagerFactory keyManagerFacotry = KeyManagerFactory.getInstance("SunX509");
		KeyStore ks  = KeyStore.getInstance("jks");
		File certx = new File(ksfname);
		ks.load(new FileInputStream(certx), storePass.toCharArray());
		keyManagerFacotry.init(ks, keyPass.toCharArray());
		//km  - 认证密钥的来源或null
		//tm  - 对等认证信任决定的来源或null
		sslContext.init(keyManagerFacotry.getKeyManagers(), null, null);
		SSLEngine sslEngine = sslContext.createSSLEngine();
		sslEngine.setUseClientMode(false);
		ByteBuffer buf = ByteBuffer.allocate(1024);
		ByteBuffer dst = ByteBuffer.allocate(1024);
		buf.put("hello".getBytes());
		sslEngine.wrap(buf, dst);
		System.out.println(new String(dst.array()));
		
		https();
	}

	
	 /* At a high level, the <code>SSLEngine</code> appears thus:
		 *
		 * <pre>
		 *                   app data
		 *
		 *                |           ^
		 *                |     |     |
		 *                v     |     |
		 *           +----+-----|-----+----+
		 *           |          |          |
		 *           |       SSL|Engine    |
		 *   wrap()  |          |          |  unwrap()
		 *           | OUTBOUND | INBOUND  |
		 *           |          |          |
		 *           +----+-----|-----+----+
		 *                |     |     ^
		 *                |     |     |
		 *                v           |
		 *
		 *                   net data
		 */
	
	public static void https()throws Exception{
		  URL url = new URL("https://baidu.com");
		  HttpsURLConnection conn =  (HttpsURLConnection) url.openConnection();
		  
		
	}
	
	
}
