package com.cognizant.ifs.ejb.interfaces;

import java.rmi.RemoteException;

import javax.ejb.CreateException;
import javax.ejb.EJBHome;

public interface IFSPreviewHome extends EJBHome
{
  public IFSPreview create() throws RemoteException,CreateException;
}
