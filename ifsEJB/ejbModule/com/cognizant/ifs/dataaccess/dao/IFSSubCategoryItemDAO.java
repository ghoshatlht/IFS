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


public class IFSSubCategoryItemDAO implements BaseDAO
{
	Connection con;
	PreparedStatement psmt;
	ResultSet rs;
	
	final static String sql1 = "INSERT INTO SUB_CATEGORY_ITEM(SUB_CATEGORY_ITEM_CODE,ITEM_CODE,SUB_CATEGORY_CODE) VALUES(?,?,?)";
	final static String sql2 = "DELETE FROM SUB_CATEGORY_ITEM WHERE SUB_CATEGORY_ITEM_CODE = ?";
	final static String sql3 = "UPDATE SUB_CATEGORY_ITEM SET SUB_CATEGORY_CODE = ? WHERE SUB_CATEGORY_ITEM_CODE = ?";
	final static String sql4 = "SELECT * FROM SUB_CATEGORY_ITEM";
	final static String sql5 = "SELECT * FROM SUB_CATEGORY_ITEM WHERE SUB_CATEGORY_ITEM_CODE = ?";
	
	private static Logger logger = Logger.getLogger(IFSSubCategoryItemDAO.class.getName());
	
	public IFSSubCategoryItemDAO()
	{
		con=IFSDAOFactory.createConnection();
	}
	
	public boolean insert(IFSCommonTO ifsCommonTO)
	{
		
		try
		{
		 IFSSubCategoryItemTO ifsCategoryItemSubItemTOP=(IFSSubCategoryItemTO)ifsCommonTO;
		 psmt = con.prepareStatement(sql1);
		 if(ifsCategoryItemSubItemTOP!=null)
			{
				psmt.setInt(1, ifsCategoryItemSubItemTOP.getSubCategoryItemCode());
				psmt.setInt(2, ifsCategoryItemSubItemTOP.getItemCode());
				psmt.setInt(3, ifsCategoryItemSubItemTOP.getSubCategoryCode());
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
	    
	    IFSSubCategoryItemTO ifsCategoryItemSubItemTOP=(IFSSubCategoryItemTO)ifsCommonTO;		
	    //String sql = "DELETE FROM Category_Item_Sub_Item_Table WHERE Category_Code = ?";
		psmt = con.prepareStatement(sql2);
		if(ifsCategoryItemSubItemTOP!=null)
		{
			psmt.setInt(1, ifsCategoryItemSubItemTOP.getSubCategoryItemCode());
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
		
		IFSSubCategoryItemTO ifsCategoryItemSubItemTOP=(IFSSubCategoryItemTO)ifsCommonTO;
		//String sql = "update Category_Item_Sub_Item_Table set Category_Name = '?' where C_I_S_Id = code";
		psmt = con.prepareStatement(sql3);
		if(ifsCategoryItemSubItemTOP!=null)
		{
			psmt.setInt(1, ifsCategoryItemSubItemTOP.getSubCategoryCode());
			psmt.setInt(2, ifsCategoryItemSubItemTOP.getSubCategoryItemCode());
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
		
		IFSSubCategoryItemTO iFSCategoryItemSubItemTO=null;
		try
		{
		//IFSCategoryItemSubItemTO ifsCategoryItemSubItemTOP=(IFSCategoryItemSubItemTO)ifsCommonTO;
		//String sql="select * from Category_Item_Sub_Item_Table";
		psmt = con.prepareStatement(sql4);
		/*if(ifsCategoryItemSubItemTOP!=null)
		{
			psmt.setInt(1, ifsCategoryItemSubItemTOP.getSubCategoryItemCode());
		}*/
		rs=psmt.executeQuery();
		
		while(rs.next())
		{
			iFSCategoryItemSubItemTO=new IFSSubCategoryItemTO();
			iFSCategoryItemSubItemTO.setSubCategoryItemCode(rs.getInt(1));
			iFSCategoryItemSubItemTO.setItemCode(rs.getInt(2));
			iFSCategoryItemSubItemTO.setSubCategoryCode(rs.getInt(3));
						
			//System.out.println(rs.getString(1)+"  "+rs.getString(2)+" "+rs.getString(3)+rs.getString(4)+"  "+rs.getString(5)+" "+rs.getString(6)+"  "+rs.getString(7)+" "+rs.getString(8));
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
		return iFSCategoryItemSubItemTO;
		
	}
	
	public List<IFSSubCategoryItemTO> search(IFSCommonTO ifsCommonTO)
	{
		List<IFSSubCategoryItemTO> lst =null;
		try
		{
			IFSSubCategoryItemTO ifsCategoryItemSubItemTOP=(IFSSubCategoryItemTO)ifsCommonTO;
			//String sql="select * from Category_Item_Sub_Item_Table where C_I_S_Id=?";
			psmt = con.prepareStatement(sql5);
			if(ifsCategoryItemSubItemTOP!=null)
			{
				psmt.setInt(1, ifsCategoryItemSubItemTOP.getSubCategoryItemCode());
			}
				rs=psmt.executeQuery();
			 lst = new ArrayList<IFSSubCategoryItemTO>();
			while(rs.next())
			{
				IFSSubCategoryItemTO  iFSCategoryItemSubItemTO= new IFSSubCategoryItemTO();
				iFSCategoryItemSubItemTO.setSubCategoryItemCode(rs.getInt(1));
				iFSCategoryItemSubItemTO.setItemCode(rs.getInt(2));
				iFSCategoryItemSubItemTO.setSubCategoryCode(rs.getInt(3));
				
				lst.add(iFSCategoryItemSubItemTO);
				
			
				//System.out.println(rs.getString(1)+"  "+rs.getString(2)+" "+rs.getString(3)+rs.getString(4)+"  "+rs.getString(5)+" "+rs.getString(6));
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
