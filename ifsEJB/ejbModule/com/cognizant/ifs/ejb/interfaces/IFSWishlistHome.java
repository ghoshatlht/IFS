package com.cognizant.ifs.ejb.interfaces;

import java.rmi.RemoteException;

import javax.ejb.CreateException;
import javax.ejb.EJBHome;

public interface IFSWishlistHome extends EJBHome 
{
    public IFSWishlist create() throws RemoteException, CreateException;

}
