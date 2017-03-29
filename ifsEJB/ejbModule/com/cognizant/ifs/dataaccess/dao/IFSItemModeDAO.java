package com.cognizant.ifs.dataaccess.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import com.cognizant.ifs.dataaccess.dto.IFSCommonTO;
import com.cognizant.ifs.dataaccess.dto.IFSItemModeTO;


public class IFSItemModeDAO implements BaseDAO
{  
	Connection con;
	PreparedStatement psmt;
	ResultSet rs;
	final static String sql1 ="INSERT INTO ITEM_MODE(ITEM_MODE_ID,DELIVERY_MODE_ID,ITEM_CODE) VALUES(?,?,?)";
	final static String sql2 ="DELETE FROM ITEM_MODE WHERE ITEM_MODE_ID = ?";
	final static String sql3 ="UPDATE ITEM_MODE SET DELIVERY_MODE_ID = ? WHERE ITEM_MODE_ID = ?";
	final static String sql4 ="SELECT ITEM_MODE_ID,DELIVERY_MODE_ID,ITEM_CODE FROM ITEM_MODE";
	final static String sql5 ="SELECT * FROM ITEM_MODE WHERE ITEM_MODE_ID = ?";
	
	private static Logger logger = Logger.getLogger(IFSCategoryDAO.class.getName());
	
	public IFSItemModeDAO()
	{
		con=IFSDAOFactory.createConnection();
	}

	public boolean insert(IFSCommonTO ifsCommonTO) {

		try
		{
		 IFSItemModeTO ifsItemModeTOP	=(IFSItemModeTO)ifsCommonTO;
		 psmt = con.prepareStatement(sql1);
		 if(ifsItemModeTOP!=null)
		 {
				psmt.setInt(1, ifsItemModeTOP.getItemModeId());
				psmt.setInt(2, ifsItemModeTOP.getDeliveryModeId());
				psmt.setInt(3, ifsItemModeTOP.getItemCode());
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

	public boolean delete(IFSCommonTO ifsCommonTO) {
		try
		{
			IFSItemModeTO ifsItemModeTOP	=(IFSItemModeTO)ifsCommonTO;		
	   // String sql = "DELETE FROM Sales_Category_Table WHERE Category_Code = ?";
		psmt = con.prepareStatement(sql2);
		if(ifsItemModeTOP!=null)
		{
			psmt.setInt(1, ifsItemModeTOP.getItemModeId());
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

	public boolean update(IFSCommonTO ifsCommonTO) 
	{
		try
		{
			IFSItemModeTO ifsItemModeTOP	=(IFSItemModeTO)ifsCommonTO;
		   // String sql = "update Sales_Category_Table set Category_Name = ? where Category_Code = ?";
		    psmt = con.prepareStatement(sql3);
		    if(ifsItemModeTOP!=null)
		    {
				psmt.setInt(1, ifsItemModeTOP.getDeliveryModeId());
				psmt.setInt(2, ifsItemModeTOP.getItemModeId());
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
	
	public IFSCommonTO retrieve(IFSCommonTO ifsCommonTO) {
		IFSItemModeTO  iFSItemModeTO =null;
		try
		{
		//IFSSalesCategoryTO ifsSalesCategoryTOP	=(IFSSalesCategoryTO)ifsCommonTO;	
		psmt = con.prepareStatement(sql4);
		/*if(ifsSalesCategoryTOP!=null)
		{
		psmt.setInt(1, ifsSalesCategoryTOP.getCategoryCode());
		}*/
		rs=psmt.executeQuery();
		
		while(rs.next())
		{
			iFSItemModeTO= new IFSItemModeTO();
			iFSItemModeTO.setItemModeId(rs.getInt(1));
			iFSItemModeTO.setDeliveryModeId(rs.getInt(2));
			iFSItemModeTO.setItemCode(rs.getInt(3));			
			
			//System.out.println(rs.getString(1)+"  "+rs.getString(2)+" "+rs.getString(3)+rs.getString(4)+"  "+rs.getString(5)+" "+rs.getString(6));
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
		return iFSItemModeTO;
	}

	public List<IFSItemModeTO> search(IFSCommonTO ifsCommonTO)
	{
		List<IFSItemModeTO> lst =null;
		try
		{
			IFSItemModeTO ifsItemModeTOP	=(IFSItemModeTO)ifsCommonTO;
			//String sql="select * from Sales_Category_Table where Category_Code=?";
			psmt = con.prepareStatement(sql5);
			if(ifsItemModeTOP!=null)
			{
			psmt.setInt(1, ifsItemModeTOP.getItemModeId());
			}
			rs=psmt.executeQuery();
			 lst = new ArrayList<IFSItemModeTO>();
			while(rs.next())
			{
				IFSItemModeTO  iFSItemModeTO= new IFSItemModeTO();
				iFSItemModeTO.setItemModeId(rs.getInt(1));
				iFSItemModeTO.setDeliveryModeId(rs.getInt(2));
				iFSItemModeTO.setItemCode(rs.getInt(3));
				lst.add(iFSItemModeTO);
				
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
