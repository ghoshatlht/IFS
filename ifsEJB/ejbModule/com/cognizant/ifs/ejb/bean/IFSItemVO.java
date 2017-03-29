package com.cognizant.ifs.ejb.bean;

import java.io.Serializable;

public class IFSItemVO implements Serializable 
{
	private int itemCode;
	private int imageId;
    private int quantity;
	private String itemName;
    private String itemDesc;
    private String price;
    private String serialNo;
    private String batchNo;
    private String imageName;
    	
    public IFSItemVO(int itemCode,int imageId,int quantity,String itemName,String itemDesc,String price,String serialNo,String batchNo,String imageName)
	{
		this.itemCode = itemCode;
		this.imageId = imageId;
		this.quantity = quantity;
		this.itemName = itemName;
		this.itemDesc = itemDesc;
		this.price = price;
		this.serialNo=serialNo;
		this.batchNo=batchNo;
		this.imageName=imageName;
	}
    public IFSItemVO(){}

	public int getItemCode()
	{
		return itemCode;
	}
	
	public int getImageId()
	{
		return imageId;
	}
	
	public int getQuantity()
	{
		return quantity;
	}
	
	public String getItemName()
	{
		return itemName;
	}
	
	public String getItemDesc()
	{
		return itemDesc;
	}
	
	public String getPrice()
	{
		return price;
	}
	public String getSerialNo()
	{
		return serialNo;
	}
	public String getBatchNo()
	{
		return batchNo;
	}
	
	public String getImageName()
	{
		return imageName;
	}
	public void setItemCode(int newItemCode)
	{
		this.itemCode=newItemCode;
	}
	public void setImageId(int newImageId)
	{
		this.imageId=newImageId;
	}
	public void setQuantity(int newQuantity)
	{
		this.quantity=newQuantity;
	}
	public void setItemName(String newItemName)
	{
		this.itemName=newItemName;
	}
	public void setItemDesc(String newItemDesc)
	{
		this.itemDesc=newItemDesc;
	}
	public void setPrice(String newPrice)
	{
		this.price=newPrice;
	}
	
	public void setSerialNo(String newSerialNo)
	{
		this.serialNo=newSerialNo;
	}
	public void setBatchNo(String newBatchNo)
	{
		this.batchNo=newBatchNo;
	}
	public void setImageName(String newImageName)
	{
		this.imageName =newImageName;
	}
}
