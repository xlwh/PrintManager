package com.zhang.file;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import com.zhang.modal.FileItem;

public class ViewFile
{
	@SuppressWarnings( "unused" )
	private String path;
	
	
	
	public List<FileItem> getFileList(String path)
	{
		List<FileItem> lst = new ArrayList<FileItem>();
		File file = new File(path);
		
		//如果是一个文件夹
		if(file.isDirectory())
		{
			
			String[] names = file.list();
			for(int i=0;i<names.length;i++)
			{
				FileItem item = new FileItem();
				item.setName( names[i] );
				item.setType( FileItem.TYPE_DIR );
				
				lst.add( item );
			}
			
		}
		
		//如果是一个文件
		else
		{
			String[] names = file.list();
			for(int i=0;i<names.length;i++)
			{
				FileItem item = new FileItem();
				item.setName( names[i] );
				item.setType( FileItem.TYPE_FILE);
				
				lst.add( item );
			}
			
		}
		
		return lst;
	}
	
	
	

}
