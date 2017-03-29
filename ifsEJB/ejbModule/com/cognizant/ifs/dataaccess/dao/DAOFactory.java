package com.cognizant.ifs.dataaccess.dao;



public abstract class DAOFactory {
	
	public static final int IFS_ORACLE_DAOFACTORY = 1;
	
	 public abstract IFSCategoryDAO getIFSCategoryDAO();
	 public abstract IFSSubCategoryDAO getIFSSubCategoryDAO();
	 public abstract IFSItemDAO getIFSItemDAO();
	 public abstract IFSSubCategoryItemDAO getIFSSubCategoryItemDAO();
	 public abstract IFSImageDAO getIFSImageDAO();
	 public abstract IFSDeliveryModeDAO getDeliveryModeDAO();
	 public abstract IFSItemModeDAO getItemModeDAO();
	 
	 public static IFSDAOFactory getDAOFactory(
		      int whichFactory) {
		  
		    switch (whichFactory) {
		      case IFS_ORACLE_DAOFACTORY: 
		          return new IFSDAOFactory();
		    
		      default: 
		          return null;
		    }
		  }
}



