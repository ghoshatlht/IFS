package com.cognizant.ifs.dataaccess.dto;

@SuppressWarnings("serial")
public class IFSImageTO extends IFSCommonTO
{
	private int imageId;
	private String imageName;
	private String imageFolder;

	public IFSImageTO(){}

	public int getImageId()
	{
		return imageId;
	}
	
	public String getImageName()
	{
		return imageName;
	}
	
	public String getImageFolder()
	{
		return imageFolder;
	}
	
	public void setImageId(int newImageId)
	{
		this.imageId=newImageId;
	}
	public void setImageName(String newImageName)
	{
		this.imageName=newImageName;
	}
	
	public void setImageFolder(String newImageFolder)
	{
		this.imageFolder=newImageFolder;
	}
}
