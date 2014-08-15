package com.zhang.modal;

public class FileItem
{
	private String name;
	private String type;
	public static final String TYPE_FILE = "file";
	public static final String TYPE_DIR = "dir";
	public String getName()
	{
		return name;
	}
	public void setName( String name )
	{
		this.name = name;
	}
	public String getType()
	{
		return type;
	}
	public void setType( String type )
	{
		this.type = type;
	}
	
	
	
}
