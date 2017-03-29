package com.cognizant.ifs.ejb.bean;

import java.rmi.RemoteException;
import java.util.ArrayList;

import java.util.List;


import javax.ejb.EJBException;
import javax.ejb.SessionBean;
import javax.ejb.SessionContext;

import com.cognizant.ifs.dataaccess.dao.IFSItemDAO;

import com.cognizant.ifs.dataaccess.dto.IFSSubCategoryItemTO;

import com.cognizant.ifs.dataaccess.dto.IFSItemTO;

public class IFSItemBean implements SessionBean   
{
	//IFSItemTO sto=new IFSItemTO();
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

             public void ejbCreate(){}
             
                            
                      public List listItems(String para){
                    		IFSItemDAO ifsItemDAO = new IFSItemDAO();
                    		IFSSubCategoryItemTO reqDto = new IFSSubCategoryItemTO();
                    		reqDto.setSubCategoryCode(Integer.parseInt(para));
                    		List<IFSItemTO> dtos = ifsItemDAO.search(reqDto);
                    		List lst=new ArrayList();
                    		
                    		for (IFSItemTO dto: dtos) {
                    			IFSItemVO vo = new IFSItemVO();
                    			vo.setItemCode(dto.getItemCode());
                      		  	vo.setItemName(dto.getItemName());
                      		  	vo.setImageName(dto.getImageName());
                      		  	lst.add(vo);
                    		}
                    			
                    		return lst;
                    	}
           }
	