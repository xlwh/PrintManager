/*
 * Title:        在线打印系统2014年8月15日
 * Description:  管理端负责和服务器进行交互
 * Copyright:    Copyright (c) 2014
 * Company:      个人项目
 * @author       张洪斌
 * @version      1.0  2014年8月15日
 */
package com.zhang.net;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * (一句话功能简述)
 * (功能详细描述)
 * @author       张洪斌
 * @see          [相关类,可选,也可多条,对于重要的类或接口建议注释]
 * @since        在线打印系统, 2014年8月15日
 */
public class NetUtil
{
	public static String getData(String url)
	{
		try
		{
			URL path = new URL(url);
			try
			{
				HttpURLConnection conn = ( HttpURLConnection )path.openConnection();
				//conn.setRequestMethod( "post" );
				
				InputStream in = conn.getInputStream();
				BufferedInputStream bin = new BufferedInputStream(in);
				StringBuffer result = new StringBuffer();
				byte buf[] = new byte[1024];
				while((bin.read( buf ))!=-1)
				{
					bin.read( buf, 0, 100 );
					result.append( new String(buf) );
				}
				
				
				bin.close();
				return result.toString();
				
			}
			catch( IOException e )
			{
				e.printStackTrace();
			}
		}
		catch( MalformedURLException e )
		{
			e.printStackTrace();
		}
		return null;
	}
	
}
