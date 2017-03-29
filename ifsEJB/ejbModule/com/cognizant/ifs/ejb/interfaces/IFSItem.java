package com.cognizant.ifs.ejb.interfaces;

import java.rmi.Remote;
import java.rmi.RemoteException;

import java.util.List;


import javax.ejb.EJBObject;



public interface IFSItem extends Remote, EJBObject 
{
	public List listItems(String para) throws RemoteException; 
}
