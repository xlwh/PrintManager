/*
 * Title:        在线打印系统2014年8月19日
 * Description:  [描述模块的功能、作用、使用方法和注意事项]
 * Copyright:    Copyright (c) 2014
 * Company:      个人项目
 * @author       张洪斌
 * @version      1.0  2014年8月19日
 */
package com.zhang.frame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.zhang.domain.PrintFile;

/**
 * (一句话功能简述)
 * (功能详细描述)
 * @author       张洪斌
 * @see          [相关类,可选,也可多条,对于重要的类或接口建议注释]
 * @since        在线打印系统, 2014年8月19日
 */
public class TablePanel extends JPanel{

	/**
	 * (域的意义,目的,功能)
	 */
	private static final long	serialVersionUID	= 1L;
	private List<PrintFile> printfiles;
	private JButton bt;
	public TablePanel(){intit();};
	public TablePanel(List<PrintFile> printfiles)
	{
		this.printfiles = printfiles;
		intit();
	}
	
	//初始化
	@SuppressWarnings( "serial" )
	public void intit(){
		this.setSize( 500, 1200 );
		
		String[] headers = { "序号", "文件名", "文件格式" ,"文件大小","时间","操作"};
		Object[][] cellData = null;

		DefaultTableModel model = new DefaultTableModel(cellData, headers) {

		  public boolean isCellEditable(int row, int column) {
		    return false;
		  }
		};
		  JTable jtable = new JTable(model);
	      jtable.setSize( 500, 1200 );
	      JScrollPane scrollpane = new JScrollPane(jtable);
	      setData(jtable,printfiles);
	      jtable.setAutoResizeMode( WIDTH );
	      
          this.add( scrollpane);
          JLabel label = new JLabel("总任务数："+printfiles.size());
          this.add( label );
           bt = new JButton("开始打印");
           bt.addActionListener( new ActionListener(){

			public void actionPerformed( ActionEvent e ) {
				bt.setText( "停止打印" );
				
			}} );
           
          this.add( bt );
          
		}
	
	public void setData(JTable table,List<PrintFile> printFiles){
		 DefaultTableModel tableModel = (DefaultTableModel) table
				  .getModel();
				  tableModel.setRowCount(0);// 清除原有行
		  for(int i=0;i<printFiles.size();i++)
		  {
			  String[] arr=new String[5];
			  PrintFile file = printFiles.get( i );
			  arr[0] = ""+i;
			  arr[1] = file.getName();
			  arr[2] = file.getFormat();
			  arr[3] = ""+file.getSize();
			  arr[4] = ""+file.getCreatetime();
			  tableModel.addRow(arr);
		  }
		  table.invalidate();	  
	}
	
	
}
