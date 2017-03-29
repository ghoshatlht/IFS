package com.cognizant.ifs.ejb.interfaces;

import java.rmi.RemoteException;

import javax.ejb.CreateException;
import javax.ejb.EJBHome;

public interface IFSItemHome extends EJBHome 
   {
	
    public IFSItem create() throws RemoteException,         CreateException;

     }
