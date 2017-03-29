package com.cognizant.ifs.ejb.bean;

import java.rmi.RemoteException;
import java.util.ArrayList;

import java.util.List;


import javax.ejb.EJBException;
import javax.ejb.SessionBean;
import javax.ejb.SessionContext;

import com.cognizant.ifs.dataaccess.dao.IFSCategoryDAO;
import com.cognizant.ifs.dataaccess.dto.IFSCategoryTO;

public class IFSCategoryBean implements SessionBean {

	public void setSessionContext(SessionContext arg0) throws EJBException,
			RemoteException {
		// TODO Auto-generated method stub

	}

	public void ejbRemove() throws EJBException, RemoteException {
		// TODO Auto-generated method stub

	}

	public void ejbActivate() throws EJBException, RemoteException {
		// TODO Auto-generated method stub

	}

	public void ejbPassivate() throws EJBException, RemoteException {
		// TODO Auto-generated method stub

	}
	
	public void ejbCreate() {}
	
	
	public List listCategories()
	{
		
		IFSCategoryDAO ifsCategoryDAO = new IFSCategoryDAO();
		List<IFSCategoryTO> dtos = ifsCategoryDAO.search(null);
		List lst=new ArrayList();
		for (IFSCategoryTO dto: dtos) 
		{
			IFSCategoryVO vo = new IFSCategoryVO();
		    vo.setCategoryCode(dto.getCategoryCode());
			vo.setCategoryName(dto.getCategoryName());
			vo.setImageName(dto.getImageName());
			lst.add(vo);
		}
		return lst;
	}
}
