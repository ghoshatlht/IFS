package com.cognizant.ifs.ejb.interfaces;

import java.rmi.RemoteException;

import javax.ejb.CreateException;
import javax.ejb.EJBHome;

public interface IFSCategoryHome extends EJBHome 
{

    public IFSCategory create() throws RemoteException, CreateException;

}
