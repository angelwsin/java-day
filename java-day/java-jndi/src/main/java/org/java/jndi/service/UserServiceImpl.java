package org.java.jndi.service;

import java.rmi.RemoteException;

public class UserServiceImpl implements UserService{

    public void getUser()throws RemoteException {
        System.out.println(" getUser invoker ");
    }

}
