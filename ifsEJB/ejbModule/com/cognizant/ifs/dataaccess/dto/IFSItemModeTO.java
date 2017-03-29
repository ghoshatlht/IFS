package com.cognizant.ifs.dataaccess.dto;

@SuppressWarnings("serial")
public class IFSItemModeTO extends IFSCommonTO
{

	private int itemModeId;
	private int deliveryModeId;
	private int itemCode;
	

    public IFSItemModeTO(int itemModeId,int deliveryModeId,int itemCode)
		{
			this.itemModeId = itemModeId;
			this.deliveryModeId = deliveryModeId;
			this.itemCode = itemCode;
		}
	public IFSItemModeTO(){}
	
	public int getItemModeId()
	{
		return itemModeId;
	}
	
	public int getDeliveryModeId()
	{
		return deliveryModeId;
	}
	
	public int getItemCode()
	{
		return itemCode;
	}
	
	public void setItemModeId(int newItemModeId)
	{
		this.itemModeId=newItemModeId;
	}
    
	public void setDeliveryModeId(int newDeliveryModeId)
	{
		this.deliveryModeId=newDeliveryModeId;
	}
		
	public void setItemCode(int newItemCode)
	{
		this.itemCode=newItemCode;
	}
	
	
	
	public String toString() 
	{
		StringBuilder builder = new StringBuilder();
		builder.append("itemModeId = " + itemModeId);
		builder.append("; deliveryModeId = " + deliveryModeId);
		builder.append("itemCode = " + itemCode);
		return builder.toString();
	}
}
