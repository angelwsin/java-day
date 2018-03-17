package org.java.serialize;

import java.io.Serializable;

/**
 * java Serializable 序列化机制 从子类一直往上找父类，直到遇到第一个属性结束
 * 如果父类和子类的属性名称一样，则值只序列化子类的
 * 父类的desc会序列化到二进制中，但值不会
 * @author wu.qiang
 *
 */
public class SuperUser implements Serializable {

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
