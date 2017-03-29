package com.cognizant.ifs.ejb.interfaces;

import java.rmi.Remote;
import java.rmi.RemoteException;


import javax.ejb.EJBObject;

import com.cognizant.ifs.ejb.bean.IFSDeliveryModeVO;
import com.cognizant.ifs.ejb.bean.IFSItemVO;

public interface IFSPreview extends EJBObject, Remote 
{
	public IFSDeliveryModeVO deliveryMode(String para) throws RemoteException;
	public IFSItemVO listAll(String para) throws RemoteException;
}
