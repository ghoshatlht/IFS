package com.cognizant.ifs.dataaccess.dao;


import java.util.List;

import com.cognizant.ifs.dataaccess.dto.IFSCommonTO;

public interface BaseDAO 
{
	public boolean insert(IFSCommonTO ifsCommonTO);
	public boolean update(IFSCommonTO ifsCommonTO); 
	public boolean delete(IFSCommonTO ifsCommonTO); 
	public IFSCommonTO retrieve(IFSCommonTO ifsCommonTO);
	public List search(IFSCommonTO ifsCommonTO);
}
