package com.cognizant.ifs.dataaccess.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import com.cognizant.ifs.dataaccess.dto.IFSCommonTO;


import com.cognizant.ifs.dataaccess.dto.IFSSubCategoryTO;

public class IFSSubCategoryDAO implements BaseDAO 
{
	 
	Connection con;
	PreparedStatement psmt;
	ResultSet rs;
	
	final static String sql1 = "INSERT INTO SUB_CATEGORY(SUB_CATEGORY_CODE,SUB_CATEGORY_NAME,CATEGORY_CODE,IMAGE_NAME) VALUES(?,?,?,?)";
	final static String sql2 = "DELETE FROM SUB_CATEGORY WHERE SUB_CATEGORY_CODE = ?";
	final static String sql3 = "UPDATE SUB_CATEGORY SET SUB_CATEGORY_NAME = ? WHERE SUB_CATEGORY_CODE = ?";
	final static String sql4 = "SELECT SUB_CATEGORY_CODE,SUB_CATEGORY_NAME,CATEGORY_CODE,IMAGE_NAME FROM SUB_CATEGORY WHERE SUB_CATEGORY_CODE=?";
	final static String sql5 = "SELECT SUB_CATEGORY_CODE,SUB_CATEGORY_NAME,CATEGORY_CODE,IMAGE_NAME FROM SUB_CATEGORY  WHERE CATEGORY_CODE= ?";
	
	private static Logger logger = Logger.getLogger(IFSSubCategoryDAO.class.getName());
	
	public IFSSubCategoryDAO()
	{
		con=IFSDAOFactory.createConnection();
	}
	

	public boolean insert(IFSCommonTO ifsCommonTO)
	{
		
		try
		{
		 IFSSubCategoryTO ifsSubCategoryTOP	=(IFSSubCategoryTO)ifsCommonTO;	
		 psmt = con.prepareStatement(sql1);
		 if(ifsSubCategoryTOP!=null)
		 {
				psmt.setInt(1,ifsSubCategoryTOP.getSubCategoryCode());
		        psmt.setString(2, ifsSubCategoryTOP.getSubCategoryName());
		        psmt.setInt(3,ifsSubCategoryTOP.getCategoryCode());
		        psmt.setString(4,ifsSubCategoryTOP.getImageName());
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
	    IFSSubCategoryTO ifsSubCategoryTOP	=(IFSSubCategoryTO)ifsCommonTO;		
		psmt = con.prepareStatement(sql2);
		if(ifsSubCategoryTOP!=null)
		{
			psmt.setInt(1,ifsSubCategoryTOP.getSubCategoryCode());
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
		
		IFSSubCategoryTO ifsSubCategoryTOP	=(IFSSubCategoryTO)ifsCommonTO;
		psmt = con.prepareStatement(sql3);
		if(ifsSubCategoryTOP!=null)
		{
			psmt.setString(1,ifsSubCategoryTOP.getSubCategoryName());
			psmt.setInt(2,ifsSubCategoryTOP.getSubCategoryCode());
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
		IFSSubCategoryTO iFSSubCategoryTO=null;
		
		try
		{
		
		IFSSubCategoryTO ifsSubCategoryTOP	=(IFSSubCategoryTO)ifsCommonTO;
		
		
		if(ifsSubCategoryTOP!=null)
		{
		psmt = con.prepareStatement(sql4);
		psmt.setInt(1,ifsSubCategoryTOP.getSubCategoryCode());
		rs=psmt.executeQuery();
	
		while(rs.next())
		{
			iFSSubCategoryTO= new IFSSubCategoryTO();
			iFSSubCategoryTO.setSubCategoryCode(rs.getInt(1));
			iFSSubCategoryTO.setSubCategoryName(rs.getString(2));
			iFSSubCategoryTO.setCategoryCode(rs.getInt(3));
			iFSSubCategoryTO.setImageName(rs.getString(4));
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
		return iFSSubCategoryTO;
	}
	
	
	public List<IFSSubCategoryTO> search(IFSCommonTO ifsCommonTO)
	{
		List<IFSSubCategoryTO> lst =null;
		try
		{
			IFSSubCategoryTO ifsSubCategoryTOP	=(IFSSubCategoryTO)ifsCommonTO;

			if(ifsSubCategoryTOP!=null)
			{
			  psmt = con.prepareStatement(sql5);
			  psmt.setInt(1,ifsSubCategoryTOP.getCategoryCode());
			
			  rs=psmt.executeQuery();
			  lst = new ArrayList<IFSSubCategoryTO>();
			while(rs.next())
			{
				IFSSubCategoryTO  iFSSubCategoryTO= new IFSSubCategoryTO();
				iFSSubCategoryTO.setSubCategoryCode(rs.getInt(1));
				iFSSubCategoryTO.setSubCategoryName(rs.getString(2));
				iFSSubCategoryTO.setCategoryCode(rs.getInt(3));
				iFSSubCategoryTO.setImageName(rs.getString(4));
				lst.add(iFSSubCategoryTO);
				
			}
				
			}	
			
			System.out.println(lst);	
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
