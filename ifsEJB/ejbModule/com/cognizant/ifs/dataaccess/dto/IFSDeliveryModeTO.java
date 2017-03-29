package com.cognizant.ifs.dataaccess.dto;

@SuppressWarnings("serial")
public class IFSDeliveryModeTO extends IFSCommonTO
{
	private int deliveryModeId;
	private String deliveryModeName;
	private String description;
	
	public IFSDeliveryModeTO(){}

	public IFSDeliveryModeTO(int deliveryModeId, String deliveryModeName,String description)
	{
		this.deliveryModeId = deliveryModeId;
		this.deliveryModeName = deliveryModeName;
		this.description=description;
	}

	public int getDeliveryModeId()
	{
		return deliveryModeId;
	}

	public String getDeliveryModeName()
	{
		return deliveryModeName;
	}
	public String getDescription()
	{
		return description;
	}

	public void setDeliveryModeId(int newDeliveryModeId)
	{
		this.deliveryModeId=newDeliveryModeId;
	}
	public void setDeliveryModeName(String newDeliveryModeName)
	{
		this.deliveryModeName=newDeliveryModeName;
	}
	
	public void setDescription(String newDescription)
	{
		this.description=newDescription;
	}

	public String toString() 
	{
		StringBuilder builder = new StringBuilder();
		builder.append("deliveryModeId = " + deliveryModeId);
		builder.append("; deliveryModeName = " + deliveryModeName);
		builder.append("; description = " + description);
		return builder.toString();
	}

}
