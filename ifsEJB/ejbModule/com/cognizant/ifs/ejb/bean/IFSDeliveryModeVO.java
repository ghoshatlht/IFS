package com.cognizant.ifs.ejb.bean;

import java.io.Serializable;

public class IFSDeliveryModeVO implements Serializable 
{
	private int deliveryModeId;
	private String deliveryModeName;
	private String description;
	
	public IFSDeliveryModeVO(){}

	public IFSDeliveryModeVO(int deliveryModeId, String deliveryModeName,String description)
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
}
