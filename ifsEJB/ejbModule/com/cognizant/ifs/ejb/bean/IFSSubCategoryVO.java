package com.cognizant.ifs.ejb.bean;

import java.io.Serializable;

public class IFSSubCategoryVO implements Serializable
{
	private int subCategoryCode;
	private String subCategoryName;
	private int categoryCode;
	private String imageName; 

	public IFSSubCategoryVO(int subCategoryCode, String subCategoryName,int categoryCode,String imageName)
	{
		this.subCategoryCode = subCategoryCode;
		this.subCategoryName = subCategoryName;
		this.categoryCode=categoryCode;
		this.imageName=imageName;
	}
	public IFSSubCategoryVO(){}

	public int getSubCategoryCode()
	{
		return subCategoryCode;
	}
	
	public String getSubCategoryName()
	{
		return subCategoryName;
	}
	
	public int getCategoryCode()
	{
		return categoryCode;
	}
	
	public String getImageName()
	{
		return imageName;
	}
	public void setSubCategoryCode(int newSubCategoryCode)
	{
		this.subCategoryCode=newSubCategoryCode;
	}
	public void setSubCategoryName(String newSubCategoryName)
	{
		this.subCategoryName=newSubCategoryName;
	}
	
	public void setCategoryCode(int newCategoryCode)
	{
		this.categoryCode=newCategoryCode;
	}
	
	public void setImageName(String newImageName)
	{
		this.imageName=newImageName;
	}
}
