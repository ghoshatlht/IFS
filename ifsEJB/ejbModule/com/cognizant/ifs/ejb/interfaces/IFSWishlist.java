package com.cognizant.ifs.ejb.interfaces;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import javax.ejb.EJBObject;



public interface IFSWishlist extends Remote, EJBObject 
{
	public void addItem(String item) throws RemoteException;
    public void removeItem(String para) throws RemoteException;
    public List listImage() throws RemoteException;
}
