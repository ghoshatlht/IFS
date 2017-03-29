package com.cognizant.ifs.ejb.bean;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;


import javax.ejb.EJBException;
import javax.ejb.SessionBean;
import javax.ejb.SessionContext;


import com.cognizant.ifs.dataaccess.dao.IFSSubCategoryDAO;


import com.cognizant.ifs.dataaccess.dto.IFSSubCategoryTO;




public class IFSSubCategoryBean implements SessionBean {
	
	IFSSubCategoryTO sto=new IFSSubCategoryTO();
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

   public List listSubCategories(String para){
		IFSSubCategoryDAO ifsSubCategoryDAO = new IFSSubCategoryDAO();
		IFSSubCategoryTO reqDto = new IFSSubCategoryTO();
		reqDto.setCategoryCode(Integer.parseInt(para));
		
		List<IFSSubCategoryTO> dtos = ifsSubCategoryDAO.search(reqDto);
		List lst = new ArrayList();
		if(dtos!=null)
		{
		for (IFSSubCategoryTO dto: dtos)
		{
			IFSSubCategoryVO vo = new IFSSubCategoryVO();
			vo.setSubCategoryCode(dto.getSubCategoryCode());
			vo.setSubCategoryName(dto.getSubCategoryName());
			vo.setImageName(dto.getImageName());
			lst.add(vo);
		}
		}
		return lst;
	}
   
}
