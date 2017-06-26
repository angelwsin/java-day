package org.java.rmi.remote;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Echo extends Remote{
	
	
	public void sayHello() throws RemoteException;

}
