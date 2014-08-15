/*
 * Title:        在线打印系统2014年8月15日
 * Description:  管理员相关业务逻辑
 * Copyright:    Copyright (c) 2014
 * Company:      个人项目
 * @author       张洪斌
 * @version      1.0  2014年8月15日
 */
package com.zhang.service;

import com.zhang.net.NetUtil;

import net.sf.json.JSONObject;

/**
 * (一句话功能简述)
 * (功能详细描述)
 * @author       张洪斌
 * @see          [相关类,可选,也可多条,对于重要的类或接口建议注释]
 * @since        在线打印系统, 2014年8月15日
 */
public class AdminService
{
    /*
     * 管理员登录验证
     */
	
	public int login(String name,String pwd)
	{
		JSONObject obj = new JSONObject();
		obj.put( "name", name );
		obj.put( "pwd", pwd );
		String url = "http://localhost/PrintSystem/adminlogin?json="+obj.toString()+"";
		System.out.println(url);
		String result = NetUtil.getData( url );
		System.out.println(result);
		return 0;
	}
	
	
	public static void main(String[]args)
	{
		new AdminService().login( "scott", "tiger" );
	}
	
}
