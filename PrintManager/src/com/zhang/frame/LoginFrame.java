/*
 * Title:        在线打印系统2014年8月15日
 * Description:  在线打印系统管理员登录框
 * Copyright:    Copyright (c) 2014
 * Company:      个人项目
 * @author       张洪斌
 * @version      1.0  2014年8月15日
 */
package com.zhang.frame;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import com.zhang.net.NetUtil;

import net.sf.json.JSONObject;

/**
 * (一句话功能简述)
 * (功能详细描述)
 * @author       张洪斌
 * @see          [相关类,可选,也可多条,对于重要的类或接口建议注释]
 * @since        在线打印系统, 2014年8月15日
 */
public class LoginFrame extends JFrame
{

	/**
	 * (域的意义,目的,功能)
	 */
	private static final long	serialVersionUID	= 1L;
	private JLabel label1,label2;
	private JTextField text1;
	private JButton bt1,bt2;
	private JPasswordField pass;
	public LoginFrame()
	{
		try
		{
			UIManager.setLookAndFeel( UIManager.getSystemLookAndFeelClassName() );
		}
		catch( ClassNotFoundException e )
		{
			e.printStackTrace();
		}
		catch( InstantiationException e )
		{
			e.printStackTrace();
		}
		catch( IllegalAccessException e )
		{
			e.printStackTrace();
		}
		catch( UnsupportedLookAndFeelException e )
		{
			e.printStackTrace();
		}
		
		
		this.setSize( 400, 220 );
		this.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		this.setResizable( false );
		this.setTitle( "登录" );
		Image img = this.getToolkit().createImage( "images/user.png" );
		this.setIconImage( img );
		
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		
	   this.setLocation( screenSize.width/2-150, screenSize.height/2-140 );	
	   
	    buildCompont(this.getContentPane());
	}
	
	
	/*
	 * 添加组件
	 */
	
	private void buildCompont(Container container)
	{
		label1 = new JLabel("账号：");
		label1.setBounds( 80, 40, 100, 20);
		
		label2 = new JLabel("密码：");
		label2.setBounds( 80, 80, 100, 20 );
		
		text1 = new JTextField();
		text1.setBounds( 120, 40, 200, 20 );
		
		
		pass = new JPasswordField();
		pass.setBounds( 120, 80, 200,20 );
		
		bt1 = new JButton("登录");
		bt1.setBounds( 220, 120, 60, 20 );
		bt1.addActionListener( new LoginClickListener() );
		
		bt2 = new JButton("重置");
		bt2.setBounds( 290, 120, 60, 20 );
		container.setLayout( null );
		
		container.add( label1 );
		container.add( label2 );
		container.add( text1 );
		container.add( pass );
		container.add( bt1 );
		container.add( bt2 );
	}
	
	private class LoginClickListener implements ActionListener{

		/**
		 * 覆盖方法/实现方法(选择其一)
		 * (功能详细描述)
		 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
		 * @author       张洪斌
		 * @see          相关函数,对于重要的函数建议注释
		 * @since        在线打印系统, 2014年8月18日
		 * @param e
		 */
		public void actionPerformed( ActionEvent e ) {
			String name = text1.getText();
			@SuppressWarnings( "deprecation" )
			String pwd = pass.getText();
			
			if(name!=null && !(pwd.equals( "" )))
			{
				if(null!=pwd &&!(pwd.equals( "" )))
				{
					int result = dologin(name,pwd);
					
					switch(result)
					{
						case -1:{
							JOptionPane.showMessageDialog( null, "请求错误，青检查重试！" );
						};break;
						case 0:{
							JOptionPane.showMessageDialog( null, "对不起，账号不存在！" );
						};break;
						case 1:{
							JOptionPane.showMessageDialog( null, "对不起，密码错误！" );
						};break;
						case 2:{
							loginSuccess();
							
						};break;
					}
					
				}
				else
				{
				
					JOptionPane.showMessageDialog( null, "请输入密码！" );
					
				}
			}
			else
			{
				
				JOptionPane.showMessageDialog( null, "请输入用户名！" );
			}
			
		}
		
	}
	
	private void loginSuccess(){
		this.setVisible( false );
		new MainFrame().setVisible( true );
	}
	
	public int dologin(String name,String pwd)
	{
		JSONObject obj = new JSONObject();
		obj.put( "name", name );
		obj.put( "pwd", pwd );
		String url = "http://localhost/PrintSystem/adminlogin?json="+obj.toString()+"";
		System.out.println(url);
		
		String response = NetUtil.getData( url );
		JSONObject bj = JSONObject.fromObject( response );
		JSONObject b = bj.getJSONObject( "result" );
		
		System.out.println("返回数据："+response);
	/*	int result = Integer.parseInt( response );*/
		
		
		return b.getInt( "state" );
	}

}
