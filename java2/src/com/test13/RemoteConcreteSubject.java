package com.test13;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class RemoteConcreteSubject extends UnicastRemoteObject implements RemoteSubject{
	
	double width,height;
	protected RemoteConcreteSubject() throws RemoteException {
		super();
	}

	public void setHeight(double height) throws RemoteException {
		this.height = height;
		
	}

	public void setWidth(double width) throws RemoteException {
		this.width = width;
		
	}

	public double getArea() throws RemoteException {
		return width*height;
	}

}
