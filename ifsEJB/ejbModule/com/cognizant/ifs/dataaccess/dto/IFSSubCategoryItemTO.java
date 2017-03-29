package com.cognizant.ifs.dataaccess.dto;


@SuppressWarnings("serial")
public class IFSSubCategoryItemTO extends IFSCommonTO
{
	
	private int subCategoryItemCode;
	private int itemCode;
	private int subCategoryCode;

	  public IFSSubCategoryItemTO(int subCategoryItemCode,int itemCode,int subCategoryCode)
		{
			this.subCategoryItemCode = subCategoryItemCode;
			this.itemCode = itemCode;
			this.subCategoryCode = subCategoryCode;
		}
	public IFSSubCategoryItemTO(){}
	
	public int getSubCategoryItemCode()
	{
		return subCategoryItemCode;
	}
	
	public int getItemCode()
	{
		return itemCode;
	}
	
	public int getSubCategoryCode()
	{
		return subCategoryCode;
	}

	public void setSubCategoryItemCode(int newSubCategoryItemCode)
	{
		this.subCategoryItemCode=newSubCategoryItemCode;
	}

		
	public void setItemCode(int newItemCode)
	{
		this.itemCode=newItemCode;
	}
	
	public void setSubCategoryCode(int newSubCategoryCode)
	{
		this.subCategoryCode=newSubCategoryCode;
	}
	
	public String toString() 
	{
		StringBuilder builder = new StringBuilder();
		builder.append("subCategoryItemCode = " + subCategoryItemCode);
		builder.append("itemCode = " + itemCode);
		builder.append("; subCategoryCode = " + subCategoryCode);
		return builder.toString();
	}
	
}
