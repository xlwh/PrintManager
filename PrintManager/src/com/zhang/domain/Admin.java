/*
 * Title:        在线打印系统2014年8月11日
 * Description:  管理员对象的抽象和封装
 * Copyright:    Copyright (c) 2014
 * Company:      个人项目
 * @author       张洪斌
 * @version      1.0  2014年8月11日
 */
package com.zhang.domain;


/**
 * 管理员对象的抽象和封装
 * 
 * @author       张洪斌
 * @see          
 * @since        在线打印系统, 2014年8月11日
 */


public class Admin
{
	private int id;
	private String name;
	private String pwd;
	
	
	public int getId()
	{
		return id;
	}
	public void setId( int id )
	{
		this.id = id;
	}
	
	
	public String getName()
	{
		return name;
	}
	public void setName( String name )
	{
		this.name = name;
	}
	
	
	public String getPwd()
	{
		return pwd;
	}
	public void setPwd( String pwd )
	{
		this.pwd = pwd;
	}
	
	
}
