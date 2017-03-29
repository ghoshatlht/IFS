package com.cognizant.ifs.dataaccess.dao;

//import com.cognizant.dao.daoFactory.IFSDAOFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import com.cognizant.ifs.dataaccess.dto.IFSCommonTO;
import com.cognizant.ifs.dataaccess.dto.IFSImageTO;


public class IFSImageDAO implements BaseDAO 
{
	Connection con;
	PreparedStatement psmt;
	ResultSet rs;
	
	final static String sql1 = "INSERT into Image_Table " +  "values(?,?,?,?,?,?)";
	final static String sql2 = "DELETE FROM Image_Table WHERE Image_Id = ?";
	final static String sql3 = "UPDATE Image_Table SET Image_Name = ? WHERE Image_Id = ?";
	final static String sql4 = "SELECT * FROM Image_Table";
	final static String sql5 = "SELECT * FROM Image_Table WHERE Image_Id = ?";
	
	private static Logger logger = Logger.getLogger(IFSImageDAO.class.getName());
	
	public IFSImageDAO()
	{
		con=IFSDAOFactory.createConnection();
	}
	public boolean insert(IFSCommonTO ifsCommonTO)
	{
		
		try
		{
		 IFSImageTO ifsImageTOP=(IFSImageTO)ifsCommonTO;
		 psmt = con.prepareStatement(sql1);
		 if(ifsImageTOP!=null)
		 {
				psmt.setInt(1,ifsImageTOP.getImageId());
				psmt.setString(2, ifsImageTOP.getImageFolder());
				psmt.setString(3, ifsImageTOP.getImageName());
		 }
		 psmt.executeUpdate();
		
		}
		catch (SQLException s)
		{
	        //System.out.println("SQL statement is not executed!");
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
		
	    IFSImageTO ifsImageTOP=(IFSImageTO)ifsCommonTO;
	    //String sql = "DELETE FROM Image_Table WHERE Image_Id = ?";
		psmt = con.prepareStatement(sql2);
		if(ifsImageTOP!=null)
		{
			psmt.setInt(1,ifsImageTOP.getImageId());
		}
		psmt.executeUpdate();
				
		}
		catch (SQLException s)
		{
	        //System.out.println("SQL statement is not executed!");
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
		IFSImageTO ifsImageTOP=(IFSImageTO)ifsCommonTO;
		//String sql = "update Image_Table set Image_Name = '?' where Image_Id = code";
		psmt = con.prepareStatement(sql3);
		if(ifsImageTOP!=null)
		{
			psmt.setInt(1,ifsImageTOP.getImageId());
		}
		psmt.executeUpdate();
		
		}
		catch (SQLException s)
		{
	        //System.out.println("SQL statement is not executed!");
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
		IFSImageTO iFSImageTO=null;	
		try{
		IFSImageTO ifsImageTOP=(IFSImageTO)ifsCommonTO;
		//String sql="select * from Image_Table";
		psmt = con.prepareStatement(sql4);
		if(ifsImageTOP!=null)
		{
			psmt.setInt(1,ifsImageTOP.getImageId());
		}
		rs=psmt.executeQuery();
		
		while(rs.next())
		{
			iFSImageTO=new IFSImageTO();
			/*iFSImageTO.setImageId(rs.getInt(1));
			iFSImageTO.setImageFolder(rs.getString(2));
			iFSImageTO.setImageName(rs.getString(3));
			lst.add(iFSImageTO);*/
			System.out.println(rs.getString(1)+"  "+rs.getString(2)+" "+rs.getString(3)+rs.getString(4)+"  "+rs.getString(5)+" "+rs.getString(6)+" "+rs.getString(7));
			
		}	
		
		}
		
		catch (SQLException s)
		{
	        //System.out.println("SQL statement is not executed!");
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
		return iFSImageTO;
		
	}
	
	public List<IFSImageTO> search(IFSCommonTO ifsCommonTO)
	{
		List<IFSImageTO> lst =null;
		try
		{
			IFSImageTO ifsImageTOP=(IFSImageTO)ifsCommonTO;
			//String sql="select * from Image_Table where Image_Id=?";
			psmt = con.prepareStatement(sql5);
			if(ifsImageTOP!=null)
			{
				psmt.setInt(1,ifsImageTOP.getImageId());
			}
			
				rs=psmt.executeQuery();
			 lst = new ArrayList<IFSImageTO>();
			while(rs.next())
			{
				IFSImageTO  iFSImageTO= new IFSImageTO();
				iFSImageTO.setImageId(rs.getInt(1));
				iFSImageTO.setImageFolder(rs.getString(2));
				iFSImageTO.setImageName(rs.getString(3));
				lst.add(iFSImageTO);
				
			
				System.out.println(rs.getString(1)+"  "+rs.getString(2)+" "+rs.getString(3)+rs.getString(4)+"  "+rs.getString(5)+" "+rs.getString(6));
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
