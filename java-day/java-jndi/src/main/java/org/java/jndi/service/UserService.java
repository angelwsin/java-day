package org.java.jndi.service;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface UserService extends Remote{
    
    
    public  void  getUser()throws RemoteException;

}
