package com.cognizant.ifs.dataaccess.dao;

import java.sql.Connection;

import java.sql.*;

public class IFSDAOFactory extends DAOFactory {
	
	  public static Connection createConnection() 
	  {
		  Connection con=null;
		  try
			{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con=DriverManager.getConnection("jdbc:oracle:thin:@10.227.16.96:1521:wyndham","SOURAV","SOURAV");
			}
			catch(Exception e){e.printStackTrace();
			}
		  return con;
	  }

	  public IFSCategoryDAO getIFSCategoryDAO() {
		    return new IFSCategoryDAO();
	  }
      public IFSSubCategoryDAO getIFSSubCategoryDAO() {
			    return new IFSSubCategoryDAO();
      }
      public IFSItemDAO getIFSItemDAO() {
		    return new IFSItemDAO();
      }
      public IFSSubCategoryItemDAO getIFSSubCategoryItemDAO() {
		    return new IFSSubCategoryItemDAO();
      }
      public IFSImageDAO getIFSImageDAO()
      {
		    return new IFSImageDAO();
      }
	  public IFSDeliveryModeDAO getDeliveryModeDAO() 
	  {	
		    return new IFSDeliveryModeDAO();
	  }
	  public IFSItemModeDAO getItemModeDAO() 
	  {
		    return new IFSItemModeDAO();
	  }
}
