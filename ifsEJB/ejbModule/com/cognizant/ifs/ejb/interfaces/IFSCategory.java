package com.cognizant.ifs.ejb.interfaces;

import java.rmi.Remote;
import java.rmi.RemoteException;

import java.util.List;


import javax.ejb.EJBObject;



public interface IFSCategory extends Remote, EJBObject 
{
	public List listCategories() throws RemoteException;
    
}
