package org.java.security.def;

import java.security.NoSuchAlgorithmException;
import java.security.Provider.Service;
import java.security.Security;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;

import sun.security.jca.GetInstance;
import sun.security.jca.ServiceId;

public class Ext {
	
	
	
	
	
	public static void main(String[] args) {
		
		Security.insertProviderAt(new ProviderDef(), 8);
		Security.
		
		try {
			List<ServiceId> cipherServices = new ArrayList<>(1);
			cipherServices.add(new ServiceId("Cipher", "RSAExt"));
			List<Service> services = GetInstance.getServices(cipherServices);
			Iterator<Service> t =services.iterator();
			while(t.hasNext()){
				 Service s = t.next();
		            
				System.out.println(s.getProvider());
			}
			System.out.println("RSAExt".endsWith(""));
			Cipher.getInstance("RSAExt");
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchPaddingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
