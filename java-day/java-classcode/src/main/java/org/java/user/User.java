package org.java.user;

import org.java.classcode.bcel.StatisticsTime;

@StatisticsTime("say")
public class User {
	
	public User() {
	}
	
	
	public int say() {
	 int z = x();
	 return z;
	}
	
	public int x() {
		return 4;
	}
	
	
	public static void main(String[] args) {
		 User user = new User();
		 System.out.println(user.say());
	}

}
