package org.java.serialize;

import java.io.Serializable;

public class User implements Serializable{

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    
    
    private String userName;


    public String getUserName() {
        return userName;
    }


    public void setUserName(String userName) {
        this.userName = userName;
    }
    
    

}
