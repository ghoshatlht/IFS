package com.cognizant.ifs.dataaccess.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import com.cognizant.ifs.dataaccess.dto.IFSSubCategoryItemTO;
import com.cognizant.ifs.dataaccess.dto.IFSCommonTO;

import com.cognizant.ifs.dataaccess.dto.IFSItemTO;

public class IFSItemDAO implements BaseDAO 
{
	Connection con;
	PreparedStatement psmt;
	ResultSet rs;
	
	final static String sql1 = "INSERT INTO ITEM(ITEM_CODE,ITEM_NAME,ITEM_DESC,SERIAL_NO,BATCH_NO,PRICE,IMAGE_ID,QUANTITY,IMAGE_NAME) VALUES(?,?,?,?,?,?,?,?,?)";
	final static String sql2 = "DELETE FROM ITEM WHERE ITEM_CODE = ?";
	final static String sql3 = "UPDATE ITEM SET ITEM_NAME = ? WHERE ITEM_CODE = ?";
	final static String sql4 = "SELECT ITEM.ITEM_CODE,ITEM_NAME,ITEM.IMAGE_NAME,ITEM_DESC,SERIAL_NO,BATCH_NO,PRICE,QUANTITY FROM ITEM,SUB_CATEGORY_ITEM WHERE SUB_CATEGORY_ITEM.ITEM_CODE = ? AND SUB_CATEGORY_ITEM.ITEM_CODE=ITEM.ITEM_CODE";
	final static String sql5 = "SELECT ITEM.ITEM_CODE,ITEM_NAME,ITEM.IMAGE_NAME,ITEM_DESC,SERIAL_NO,BATCH_NO,PRICE,QUANTITY FROM ITEM,SUB_CATEGORY_ITEM WHERE SUB_CATEGORY_ITEM.SUB_CATEGORY_CODE = ? AND SUB_CATEGORY_ITEM.ITEM_CODE=ITEM.ITEM_CODE";
	
	private static Logger logger = Logger.getLogger(IFSItemDAO.class.getName());
	
	public IFSItemDAO()
	{
		con=IFSDAOFactory.createConnection();
	}

	public boolean insert(IFSCommonTO ifsCommonTO)
	{	
		try
		{
		 IFSItemTO ifsItemTOP=(IFSItemTO)ifsCommonTO;
		 psmt = con.prepareStatement(sql1);
		 if(ifsItemTOP!=null)
		 {
		 psmt.setInt(1, ifsItemTOP.getItemCode());
		 psmt.setString(2, ifsItemTOP.getItemName());
		 psmt.setString(3, ifsItemTOP.getItemDesc());
		 psmt.setString(4, ifsItemTOP.getSerialNo());
		 psmt.setString(5, ifsItemTOP.getBatchNo());
		 psmt.setString(6, ifsItemTOP.getPrice());
		 psmt.setInt(7, ifsItemTOP.getImageId());
		 psmt.setInt(8, ifsItemTOP.getQuantity());
		 psmt.setString(9,ifsItemTOP.getImageName());
		 }
         psmt.executeUpdate();
		}
		catch (SQLException s)
		{
			logger.warning("SQL statement is not executed!"+ s.getMessage());
		}
		finally
		{
			try
			     {
			      if(psmt != null)
			          psmt.close();
			      if(con != null)
			          con.close();
			      }
			      catch(SQLException e)
			      {
			    	  logger.warning(e.getMessage());
			      }         	       
		}
		return true;
		}
	
	public boolean delete(IFSCommonTO ifsCommonTO)
	{
	    try
		{
	    IFSItemTO ifsItemTOP=(IFSItemTO)ifsCommonTO;		
		psmt = con.prepareStatement(sql2);
		if(ifsItemTOP!=null)
		{
			psmt.setInt(1, ifsItemTOP.getItemCode());
		}
		psmt.executeUpdate();
				
		}
		catch (SQLException s)
		{
			logger.warning("SQL statement is not executed!"+s.getMessage());
		}
		finally
		{
			try
			     {
			      if(psmt != null)
			          psmt.close();
			      if(con != null)
			          con.close();
			      }
			      catch(SQLException e)
			      {
			    	  logger.warning(e.getMessage());
			      }         	       
		}	
		return true;	
	}
	
	
	public boolean update(IFSCommonTO ifsCommonTO){
	
		try
		{
		IFSItemTO ifsItemTOP=(IFSItemTO)ifsCommonTO;
		psmt = con.prepareStatement(sql3);
		if(ifsItemTOP!=null)
		{	
			psmt.setString(1,ifsItemTOP.getItemName());
		    psmt.setInt(2,ifsItemTOP.getItemCode()); 
		}
		psmt.executeUpdate();
		
		}
		catch (SQLException s)
		{
			logger.warning("SQL statement is not executed!"+s.getMessage());
		}
		finally
		{
			try
			     {
			      if(psmt != null)
			          psmt.close();
			      if(con != null)
			          con.close();
			      }
			      catch(SQLException e)
			      {
			    	  logger.warning(e.getMessage());  
			      }         	       
		}	
		return true;	
	}
	

	public IFSCommonTO retrieve(IFSCommonTO ifsCommonTO)
	{
		
		IFSItemTO iFSItemTO=null;
		
		try
		{
		IFSItemTO ifsItemTOP=(IFSItemTO)ifsCommonTO;
	
		
		if(ifsItemTOP!=null)
		{
			psmt = con.prepareStatement(sql4);
			psmt.setInt(1, ifsItemTOP.getItemCode());
		    rs=psmt.executeQuery();
		
		while(rs.next())
		{
			iFSItemTO=new IFSItemTO();
			iFSItemTO.setItemCode(rs.getInt(1));
			iFSItemTO.setItemName(rs.getString(2));
			iFSItemTO.setImageName(rs.getString(3));
			iFSItemTO.setItemDesc(rs.getString(4));
			iFSItemTO.setSerialNo(rs.getString(5));
			iFSItemTO.setBatchNo(rs.getString(6));
			iFSItemTO.setPrice(rs.getString(7));
			iFSItemTO.setQuantity(rs.getInt(8));	
		}	
		}	
		
		}
		catch (SQLException s)
		{
			logger.warning("SQL statement is not executed!"+s.getMessage());
		}
		finally
		{
			try
			     {
			      if(rs != null)
			          rs.close();
		          if(psmt != null)
			          psmt.close();
			      if(con != null)
			          con.close();
			      }
			catch(SQLException e)
			{
				logger.warning(e.getMessage());
			}         
		       
		}
		return iFSItemTO;	
	}
	
	
	public List<IFSItemTO> search(IFSCommonTO ifsCommonTO){
		List<IFSItemTO> lst =null;
		try
		{
			IFSSubCategoryItemTO ifsSubCategoryItemTOP=(IFSSubCategoryItemTO)ifsCommonTO;
			
			if(ifsSubCategoryItemTOP!=null)
			{   
				psmt = con.prepareStatement(sql5);
				psmt.setInt(1, ifsSubCategoryItemTOP.getSubCategoryCode());
			
				rs=psmt.executeQuery();
			 lst = new ArrayList<IFSItemTO>();
			while(rs.next())
			{				
     			IFSItemTO  iFSItemTO= new IFSItemTO();
				iFSItemTO.setItemCode(rs.getInt(1));
				iFSItemTO.setItemName(rs.getString(2));
				iFSItemTO.setImageName(rs.getString(3));
				iFSItemTO.setItemDesc(rs.getString(4));
				iFSItemTO.setSerialNo(rs.getString(5));
				iFSItemTO.setBatchNo(rs.getString(6));
				iFSItemTO.setPrice(rs.getString(7));
				iFSItemTO.setQuantity(rs.getInt(8));
				
				lst.add(iFSItemTO);
			}	
			
			}	
	}
	catch(Exception s)
	{
		logger.warning("SQL statement is not executed!"+s.getMessage());
	}
	finally
	{
		try
		     {
		      if(rs != null)
		          rs.close();
	          if(psmt != null)
		          psmt.close();
		      if(con != null)
		          con.close();
		      }
		catch(SQLException e)
		{
			logger.warning(e.getMessage());
		}         
	       
	}
	return lst;
	}
}
