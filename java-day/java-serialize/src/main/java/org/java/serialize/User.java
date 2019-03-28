package org.java.serialize;

import java.io.IOException;
import java.io.ObjectStreamException;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class User extends SuperUser implements Serializable{

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    
    
    private String userName;
    
    private String password;

    private BigDecimal prices;

    private Date       birth;


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


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}

    public BigDecimal getPrices() {
        return prices;
    }

    public void setPrices(BigDecimal prices) {
        this.prices = prices;
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }
}
