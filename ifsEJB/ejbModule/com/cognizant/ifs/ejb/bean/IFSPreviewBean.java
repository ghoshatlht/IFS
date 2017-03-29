package com.cognizant.ifs.ejb.bean;

import java.rmi.RemoteException;

import javax.ejb.EJBException;
import javax.ejb.SessionBean;
import javax.ejb.SessionContext;

import com.cognizant.ifs.dataaccess.dao.IFSDeliveryModeDAO;
import com.cognizant.ifs.dataaccess.dao.IFSItemDAO;


import com.cognizant.ifs.dataaccess.dto.IFSDeliveryModeTO;
import com.cognizant.ifs.dataaccess.dto.IFSItemModeTO;
import com.cognizant.ifs.dataaccess.dto.IFSItemTO;

public class IFSPreviewBean implements SessionBean 
{

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
	
	
	public IFSDeliveryModeVO deliveryMode(String para)
	{
		IFSDeliveryModeDAO dao=new IFSDeliveryModeDAO();
		IFSItemModeTO reqDTO=new IFSItemModeTO();
		reqDTO.setItemCode(Integer.parseInt(para));
		IFSDeliveryModeTO dto=(IFSDeliveryModeTO)dao.retrieve(reqDTO);
		IFSDeliveryModeVO vo=new IFSDeliveryModeVO();
		vo.setDeliveryModeName(dto.getDeliveryModeName());
		vo.setDescription(dto.getDescription());
		return vo;
		
	}
	
	public IFSItemVO listAll(String para)
	{
		IFSItemDAO ifsItemDAO = new IFSItemDAO();
		IFSItemTO reqDto = new IFSItemTO();
  		reqDto.setItemCode(Integer.parseInt(para));
  		IFSItemTO dto = (IFSItemTO)ifsItemDAO.retrieve(reqDto);
  		IFSItemVO vo=new IFSItemVO();
  		vo.setItemCode(dto.getItemCode());
  		vo.setQuantity(dto.getQuantity());
  		vo.setPrice(dto.getPrice());
  		vo.setItemDesc(dto.getItemDesc());
  		vo.setImageName(dto.getImageName());
  		return vo;
	}
}
