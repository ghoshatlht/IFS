package com.cognizant.ifs.ejb.bean;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.ejb.EJBException;
import javax.ejb.SessionBean;
import javax.ejb.SessionContext;

import com.cognizant.ifs.dataaccess.dao.IFSItemDAO;
import com.cognizant.ifs.dataaccess.dto.IFSItemTO;

public class IFSWishlistBean implements SessionBean 
{
    public IFSWishlistBean(){}
	public void setSessionContext(SessionContext arg0) throws EJBException,
			RemoteException
	{
		// TODO Auto-generated method stub

	}

	public void ejbRemove() throws EJBException, RemoteException 
	{
		// TODO Auto-generated method stub

	}

	public void ejbActivate() throws EJBException, RemoteException 
	{
		// TODO Auto-generated method stub

	}

	public void ejbPassivate() throws EJBException, RemoteException 
	{
		// TODO Auto-generated method stub

	}
	public void ejbCreate()
	{
    }
	
	private List items=new ArrayList();

       
    public void addItem(String item) 
    {
        items.add(item);
    }

    public void removeItem(String item)
    {
        items.remove(item);
    }

   /* public List getItems()
    {
        return items;
    }*/

    public List listImage()
    {
    	List lst=new ArrayList();
    	
  		
  		
  		
  		Iterator it=items.iterator();
  		while(it.hasNext())
  		{
  			IFSItemDAO ifsItemDAO=new IFSItemDAO();
  	    	IFSItemTO reqDto = new IFSItemTO();
  			IFSItemVO vo=new IFSItemVO();
  		String code=(String)it.next();
  		System.out.println("5555555555555555code="+code);
  		reqDto.setItemCode(Integer.parseInt(code));	
  		IFSItemTO dto = (IFSItemTO)ifsItemDAO.retrieve(reqDto);
  		vo.setItemCode(dto.getItemCode());
  		vo.setImageName(dto.getImageName());
  		vo.setItemName(dto.getItemName());
  		lst.add(vo);
  		}
  		return lst;
    	
    }
    
    
    

}
