/*
 * Title:        南京邮电大学物联网学院科学技术协会网站2014年8月18日
 * Description:  [描述模块的功能、作用、使用方法和注意事项]
 * Copyright:    Copyright (c) 2014
 * Company:      个人项目
 * @author       张洪斌
 * @version      1.0  2014年8月18日
 */
package com.zhang.service;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import net.sf.json.JSONObject;

import com.sun.jmx.snmp.tasks.Task;
import com.zhang.domain.PrintFile;
import com.zhang.net.NetUtil;

/**
 * (一句话功能简述)
 * (功能详细描述)
 * @author       张洪斌
 * @see          [相关类,可选,也可多条,对于重要的类或接口建议注释]
 * @since        南京邮电大学物联网学院科学技术协会网站, 2014年8月18日
 */
public class FileService {
	/*
	 * 获取所有的没有被打印的打印任务
	 */
	
	public List<Task> getTaskToPrint()
	{
		
		
		return null;
	}
	
	
	
	
	@SuppressWarnings( "unused" )
	public static  List<PrintFile> parseTaskFromJSON(String url){
		List<PrintFile> lst = new ArrayList<PrintFile>();
		String response = NetUtil.getData( url );
		System.out.println("读取到的文件数据："+response);
		return lst;
	}
	
	
	/*
	 * 上传文件：
	 * 
	 * 
	 * 
	 */
	
	public void upload(){
		File file = new File("");
		PrintFile printfile = new PrintFile();
		printfile.setName( file.getName()  );
		JSONObject obj = new JSONObject();
		
	}
	
	
	public static void main(String[] args)
	{
		String url = "http://localhost/PrintSystem/gettasktoprint";
		FileService.parseTaskFromJSON( url );
	}
	
}
