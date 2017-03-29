package com.cognizant.ifs.dataaccess.dao;


import java.sql.*;
import java.util.ArrayList;

import java.util.List;

import java.util.logging.Logger;

import com.cognizant.ifs.dataaccess.dto.IFSCommonTO;
import com.cognizant.ifs.dataaccess.dto.IFSCategoryTO;

public class IFSCategoryDAO implements BaseDAO
{
	Connection con;
	PreparedStatement psmt;
	ResultSet rs;
	final static String sql1 ="INSERT INTO CATEGORY(CATEGORY_CODE,CATEGORY_NAME,IMAGE_NAME) VALUES(?,?,?)";
	final static String sql2 ="DELETE FROM CATEGORY WHERE CATEGORY_CODE = ?";
	final static String sql3 ="UPDATE CATEGORY SET CATEGORY_NAME = ? WHERE CATEGORY_CODE = ?";
	final static String sql4 ="SELECT CATEGORY_CODE,CATEGORY_NAME,IMAGE_NAME FROM CATEGORY";
	final static String sql5 ="SELECT * FROM CATEGORY WHERE CATEGORY_CODE= ?";
	
	private static Logger logger = Logger.getLogger(IFSCategoryDAO.class.getName());
	
	public IFSCategoryDAO()
	{
		con=IFSDAOFactory.createConnection();
	}
	
	public boolean insert(IFSCommonTO ifsCommonTO)
	{
	
		try
		{
		 IFSCategoryTO ifsCategoryTOP	=(IFSCategoryTO)ifsCommonTO;
		 psmt = con.prepareStatement(sql1);
		 if(ifsCategoryTOP!=null)
		 {
				psmt.setInt(1, ifsCategoryTOP.getCategoryCode());
				psmt.setString(2, ifsCategoryTOP.getCategoryName());
				psmt.setString(3,ifsCategoryTOP.getImageName());
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
	    IFSCategoryTO ifsCategoryTOP	=(IFSCategoryTO)ifsCommonTO;		
		psmt = con.prepareStatement(sql2);
		if(ifsCategoryTOP!=null)
		{
			psmt.setInt(1, ifsCategoryTOP.getCategoryCode());
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
			IFSCategoryTO ifsCategoryTOP	=(IFSCategoryTO)ifsCommonTO;
		    psmt = con.prepareStatement(sql3);
		    if(ifsCategoryTOP!=null)
		    {
				psmt.setString(1, ifsCategoryTOP.getCategoryName());
				psmt.setInt(2, ifsCategoryTOP.getCategoryCode());
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
		IFSCategoryTO  iFSCategoryTO =null;
		try
		{
		IFSCategoryTO ifsCategoryTOP	=(IFSCategoryTO)ifsCommonTO;	
		psmt = con.prepareStatement(sql4);
		if(ifsCategoryTOP!=null)
		{
		psmt.setInt(1, ifsCategoryTOP.getCategoryCode());
		}
		rs=psmt.executeQuery();
		
		while(rs.next())
		{
			iFSCategoryTO= new IFSCategoryTO();
			iFSCategoryTO.setCategoryCode(rs.getInt(1));
			iFSCategoryTO.setCategoryName(rs.getString(2));
			iFSCategoryTO.setImageName(rs.getString(3));
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
		return iFSCategoryTO;
	}
	
	public List<IFSCategoryTO> search(IFSCommonTO ifsCommonTO)
	{
		List<IFSCategoryTO> lst =null;
		try
		{
			IFSCategoryTO ifsCategoryTOP	=(IFSCategoryTO)ifsCommonTO;
			psmt = con.prepareStatement(sql4);
			if(ifsCategoryTOP!=null)
			{
			psmt.setInt(1, ifsCategoryTOP.getCategoryCode());
			}
			rs=psmt.executeQuery();
			 lst = new ArrayList<IFSCategoryTO>();
			while(rs.next())
			{
				IFSCategoryTO  iFSCategoryTO= new IFSCategoryTO();
				iFSCategoryTO.setCategoryCode(rs.getInt(1));
				iFSCategoryTO.setCategoryName(rs.getString(2));
				iFSCategoryTO.setImageName(rs.getString(3));
				lst.add(iFSCategoryTO);
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



