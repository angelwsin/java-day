package org.java.rmi.remote.impl;

import java.rmi.RemoteException;

import org.java.rmi.remote.Echo;

public class EchoImpl implements Echo{

	public void sayHello() throws RemoteException {
		System.out.println("say hello ");
		
	}

}
