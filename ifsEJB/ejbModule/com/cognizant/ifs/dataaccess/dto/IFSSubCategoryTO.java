package com.cognizant.ifs.dataaccess.dto;

@SuppressWarnings("serial")
public class IFSSubCategoryTO extends IFSCommonTO
{
	private int subCategoryCode;
	private String subCategoryName;
	private int categoryCode;
	private String imageName; 

	public IFSSubCategoryTO(int subCategoryCode, String subCategoryName,int categoryCode,String imageName)
	{
		this.subCategoryCode = subCategoryCode;
		this.subCategoryName = subCategoryName;
		this.categoryCode=categoryCode;
		this.imageName=imageName;
	}
	public IFSSubCategoryTO(){}

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
	public String toString() 
	{
		StringBuilder builder = new StringBuilder();
		builder.append("subCategoryCode = " + subCategoryCode);
		builder.append("; subCategoryName = " + subCategoryName);
		builder.append("; categoryCode = " + categoryCode);
		builder.append("; imageName = " + imageName);
		return builder.toString();
	}
	
}
