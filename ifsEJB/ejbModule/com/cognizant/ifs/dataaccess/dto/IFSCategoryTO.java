package com.cognizant.ifs.dataaccess.dto;


@SuppressWarnings("serial")
public class IFSCategoryTO extends IFSCommonTO
{
	
private int categoryCode;
private String categoryName;
private String imageName;

public IFSCategoryTO(){}

public IFSCategoryTO(int categoryCode, String categoryName,String imageName)
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

public String toString() 
{
	StringBuilder builder = new StringBuilder();
	builder.append("categoryName = " + categoryName);
	builder.append("; categoryCode = " + categoryCode);
	builder.append(";imageName = " + imageName);
	return builder.toString();
}

}
