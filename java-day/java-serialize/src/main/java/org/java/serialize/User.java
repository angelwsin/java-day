package org.java.serialize;

import java.io.IOException;
import java.io.ObjectStreamException;
import java.io.Serializable;

public class User extends SuperUser implements Serializable{

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    
    
    private String userName;
    
    //private String password;


    public String getUserName() {
        return userName;
    }


    public void setUserName(String userName) {
        this.userName = userName;
    }
    
    
   /* private void writeObject(java.io.ObjectOutputStream out)throws IOException{
    	System.out.println("out");
    }
    
    private void readObject(java.io.ObjectInputStream in)throws IOException, ClassNotFoundException{
    	System.out.println("in");
    }*/
    
    /*private void readObjectNoData()throws ObjectStreamException{
    	System.out.println("nodata");
    }*/


	/*public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}*/
    
    
    

}
