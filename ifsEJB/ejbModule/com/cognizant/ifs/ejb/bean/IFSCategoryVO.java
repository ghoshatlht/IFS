package com.cognizant.ifs.ejb.bean;

import java.io.Serializable;

@SuppressWarnings("serial")
public class IFSCategoryVO implements Serializable 
{
	private int categoryCode;
	private String categoryName;
	private String imageName;
	public IFSCategoryVO(){}

	public IFSCategoryVO(int categoryCode, String categoryName,String imageName)
	{
		this.categoryCode = categoryCode;
		this.categoryName = categoryName;
		this.imageName=imageName;
	}

	public int getCategoryCode()
	{
		return categoryCode;
	}

	public String getCategoryName()
	{
		return categoryName;
	}

	public String getImageName()
	{
		return imageName;
	}

	public void setCategoryCode(int newCategoryCode)
	{
		this.categoryCode=newCategoryCode;
	}
	public void setCategoryName(String newCategoryName)
	{
		this.categoryName=newCategoryName;
	}

	public void setImageName(String newImageName)
	{
		this.imageName=newImageName;
	}
	
}
