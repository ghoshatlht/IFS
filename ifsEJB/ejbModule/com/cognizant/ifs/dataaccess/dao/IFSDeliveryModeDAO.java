package com.cognizant.ifs.dataaccess.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;


import com.cognizant.ifs.dataaccess.dto.IFSCommonTO;
import com.cognizant.ifs.dataaccess.dto.IFSDeliveryModeTO;
import com.cognizant.ifs.dataaccess.dto.IFSItemModeTO;



public class IFSDeliveryModeDAO implements BaseDAO 
{

	Connection con;
	PreparedStatement psmt;
	ResultSet rs;
	final static String sql1 ="INSERT INTO DELIVERY_MODE(DELIVERY_MODE_ID,DELIVERY_MODE_NAME,DESCRIPTION) VALUES(?,?,?)";
	final static String sql2 = "DELETE FROM DELIVERY_MODE WHERE DELIVERY_MODE_ID = ?";
	final static String sql3 = "UPDATE DELIVERY_MODE SET DELIVERY_MODE_NAME = ? WHERE DELIVERY_MODE_ID = ?";
	final static String sql4 ="SELECT DELIVERY_MODE_NAME,DESCRIPTION FROM ITEM_MODE,DELIVERY_MODE WHERE ITEM_MODE.ITEM_CODE= ? AND ITEM_MODE.DELIVERY_MODE_ID=DELIVERY_MODE.DELIVERY_MODE_ID";
	final static String sql5 ="SELECT * FROM DELIVERY_MODE WHERE DELIVERY_MODE_ID= ?";
	
	
	private static Logger logger = Logger.getLogger(IFSCategoryDAO.class.getName());
	
	public IFSDeliveryModeDAO()
	{
		con=IFSDAOFactory.createConnection();
	}
	
	public boolean insert(IFSCommonTO ifsCommonTO) 
	{
		try
		{
		 IFSDeliveryModeTO ifsDeliveryModeTOP	=(IFSDeliveryModeTO)ifsCommonTO;
		 psmt = con.prepareStatement(sql1);
		 if(ifsDeliveryModeTOP!=null)
		 {
				psmt.setInt(1, ifsDeliveryModeTOP.getDeliveryModeId());
				psmt.setString(2, ifsDeliveryModeTOP.getDeliveryModeName());
				psmt.setString(3, ifsDeliveryModeTOP.getDescription());
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

	public boolean delete(IFSCommonTO ifsCommonTO)
	{
		try
		{
		IFSDeliveryModeTO ifsDeliveryModeTOP	=(IFSDeliveryModeTO)ifsCommonTO;		
		psmt = con.prepareStatement(sql2);
		if(ifsDeliveryModeTOP!=null)
		{
			psmt.setInt(1, ifsDeliveryModeTOP.getDeliveryModeId());
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
	
	public boolean update(IFSCommonTO ifsCommonTO) 
	{
		try
		{
			IFSDeliveryModeTO ifsDeliveryModeTOP	=(IFSDeliveryModeTO)ifsCommonTO;
		    psmt = con.prepareStatement(sql3);
		    if(ifsDeliveryModeTOP!=null)
		    {
				psmt.setString(1, ifsDeliveryModeTOP.getDeliveryModeName());
				psmt.setInt(2, ifsDeliveryModeTOP.getDeliveryModeId());
		    }
		    psmt.executeUpdate();
		    //List<IFSSalesCategoryTO> lst=search(ifsCommonTO);
		    //IFSSalesCategoryTO xx= lst.get(1);
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
		IFSDeliveryModeTO  iFSDeliveryModeTO =null;
		try
		{
		IFSItemModeTO ifsItemModeTOP=(IFSItemModeTO)ifsCommonTO;	
	
		if(ifsItemModeTOP!=null)
		{
		psmt = con.prepareStatement(sql4);
		psmt.setInt(1, ifsItemModeTOP.getItemCode());
		rs=psmt.executeQuery();
		
		while(rs.next())
		{
			iFSDeliveryModeTO= new IFSDeliveryModeTO();
			iFSDeliveryModeTO.setDeliveryModeName(rs.getString(1));
			iFSDeliveryModeTO.setDescription(rs.getString(2));
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
		return iFSDeliveryModeTO;
	}

	public List<IFSDeliveryModeTO> search(IFSCommonTO ifsCommonTO) 
	{
		List<IFSDeliveryModeTO> lst =null;
		try
		{
			IFSDeliveryModeTO ifsDeliveryModeTOP	=(IFSDeliveryModeTO)ifsCommonTO;
			
			if(ifsDeliveryModeTOP!=null)
			{
			psmt = con.prepareStatement(sql5);
			psmt.setInt(1, ifsDeliveryModeTOP.getDeliveryModeId());
			
			rs=psmt.executeQuery();
			 lst = new ArrayList<IFSDeliveryModeTO>();
			while(rs.next())
			{
				IFSDeliveryModeTO  iFSDeliveryModeTO= new IFSDeliveryModeTO();
				iFSDeliveryModeTO.setDeliveryModeId(rs.getInt(1));
				iFSDeliveryModeTO.setDeliveryModeName(rs.getString(2));
				iFSDeliveryModeTO.setDescription(rs.getString(3));
				lst.add(iFSDeliveryModeTO);
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
