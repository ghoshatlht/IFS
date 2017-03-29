package com.cognizant.ifs.ejb.interfaces;

import java.rmi.RemoteException;

import javax.ejb.CreateException;
import javax.ejb.EJBHome;

public interface IFSSubCategoryHome extends EJBHome 
   {
	
    public IFSSubCategory create() throws RemoteException,CreateException;

     }
