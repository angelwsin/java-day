package org.java.beans;

public class UserBean {
    
    
    private String userName;
    
    private String password;
    
    private int    age;
    
    private String[] args;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "UserBean [userName=" + userName + ", password=" + password + ", age=" + age + "]";
    }

	public String[] getArgs() {
		return args;
	}
	
	public String getArgs(int i) {
		return args[i];
	}

	public void setArgs(String[] args) {
		this.args = args;
	}
	
	public void setArgs(int i,String args) {
		this.args[i] = args;
	}
    
    
    
    

}
