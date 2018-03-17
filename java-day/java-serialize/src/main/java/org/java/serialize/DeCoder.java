package org.java.serialize;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.ObjectInputStream;

public class DeCoder {
	
	
	public static void main(String[] args) throws Exception{
		try(InputStream is = new FileInputStream(new File(new File(System.getProperty("user.dir"))+"/userx.txt"));
				ObjectInputStream in = new ObjectInputStream(is);) {
			User user = (User) in.readObject();
			System.out.println(user.getUserName());
			SuperUser superUser = (SuperUser)user;
			System.out.println(superUser.getUserName());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}

}
