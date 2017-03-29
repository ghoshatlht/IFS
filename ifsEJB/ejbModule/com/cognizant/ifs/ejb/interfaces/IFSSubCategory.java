package com.cognizant.ifs.ejb.interfaces;

import java.rmi.Remote;
import java.rmi.RemoteException;

import java.util.List;


import javax.ejb.EJBObject;



    public interface IFSSubCategory extends Remote, EJBObject 
    {
    	public List listSubCategories(String para) throws RemoteException;
    }