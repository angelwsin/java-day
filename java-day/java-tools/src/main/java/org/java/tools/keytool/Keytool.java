package org.java.tools.keytool;

public class Keytool {
	
	
	@SuppressWarnings("restriction")
	public static void main(String[] args) {
		try {
			//keytool -genkeypair -alias "test1" -keyalg "RSA" -keystore "test.keystore"
			
			sun.security.tools.keytool.Main.main(args);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
