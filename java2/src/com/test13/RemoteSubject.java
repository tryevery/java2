package com.test13;

import java.rmi.RemoteException;

public interface RemoteSubject {
	public void setHeight(double height) throws RemoteException;
	public void setWidth(double width) throws RemoteException;
	public double getArea() throws RemoteException;
}
