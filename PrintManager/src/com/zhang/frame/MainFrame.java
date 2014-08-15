package com.zhang.frame;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import com.zhang.domain.PrintFile;

public class MainFrame extends JFrame {

	private String				title				= "在线打印管理系统";
	private float				screenWidth;
	private float				screenHeight;
	private JFileChooser		jChooser;

	private Container			container;

	/**
	 * (域的意义,目的,功能)
	 */
	private static final long	serialVersionUID	= 1L;

	// 系统初始化

	public MainFrame() {
		init();
	}

	public void init() {
		this.setTitle( title );

		this.setVisible( true );
		this.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		this.setResizable( false );

		// 获取屏幕大小
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		screenWidth = screenSize.width;
		screenHeight = screenSize.height;

		// 设置尺寸和图标
		this.setSize( 500, ( int )screenHeight - 100 );
		this.setLocation( 400, 10 );
		Image img = this.getToolkit().createImage( "images/logo.jpg" );
		this.setIconImage( img );

		// 获取屏幕容器
		container = this.getContentPane();
		intitMain();

	}

	public void intitMain() {

		List<PrintFile> lst = new ArrayList<PrintFile>();
		for(int i=0;i<100;i++)
		{
			PrintFile file = new PrintFile();
			file.setCreatetime( "08/19 11:18" );
			file.setName( "测试" );
			file.setFormat( "doc" );
			file.setSize( 20 );
			lst.add( file );
		}
		
		TablePanel panel = new TablePanel(lst);
		container.add( panel ,BorderLayout.CENTER);
		container.setLayout( null );
		JMenuBar mb = new JMenuBar();

		this.setJMenuBar( mb );

		JMenu menu1 = new JMenu( "文件" );
		JMenu menu2 = new JMenu( "编辑" );
		JMenu menu3 = new JMenu( "设置" );
		JMenu menu4 = new JMenu( "打印任务" );
		JMenu menu5 = new JMenu( "打印历史" );
		JMenu menu6 = new JMenu( "帮助" );
		JMenu menu7 = new JMenu( "关于系统" );
		JMenu menu8 = new JMenu( "退出" );
		JMenu menu9 = new JMenu( "管理员添加" );

		JMenuItem open = new JMenuItem( "打开" );

		// ImageIcon icon = new ImageIcon("images/icon_folder-open_alt.png");

		// open.setIcon( icon );

		// ImageIcon exporticon = new ImageIcon("images/doc_export.png");
		JMenuItem export = new JMenuItem( "导出" );
		export.setSize( 32, 32 );
		// export.setIcon( exporticon );

		menu1.add( open );
		menu1.add( export );

		mb.add( menu1 );
		mb.add( menu2 );

		JMenuItem copy = new JMenuItem( "复制" );
		JMenuItem pas = new JMenuItem( "粘贴" );

		menu2.add( copy );
		menu2.add( pas );

		mb.add( menu3 );
		JMenuItem printset = new JMenuItem( "打印机设置" );
		menu3.add( printset );

		mb.add( menu4 );
		mb.add( menu5 );
		mb.add( menu9 );
		mb.add( menu6 );
		mb.add( menu7 );
		mb.add( menu8 );

		// 给所有菜单设置事件监听以及处理

		// 文件打开事件监听处理
		open.addActionListener( new ActionListener() {

			public void actionPerformed( ActionEvent e ) {
				jChooser = new JFileChooser();
				jChooser.setCurrentDirectory( new File( "e:/" ) );
				jChooser.setFileSelectionMode( JFileChooser.CUSTOM_DIALOG );
				int index = jChooser.showDialog( null, "打开文件" );
				if( index == JFileChooser.APPROVE_OPTION )
				{
					String path = jChooser.getSelectedFile().getAbsolutePath();
					System.out.println( "选中的文件路径：" + path );

				}

			}
		} );

		// 文件导出
		export.addActionListener( new ActionListener() {

			public void actionPerformed( ActionEvent e ) {
				jChooser = new JFileChooser();
				jChooser.setCurrentDirectory( new File( "e:/" ) );
				jChooser.setFileSelectionMode( JFileChooser.CUSTOM_DIALOG );
				int index = jChooser.showDialog( null, "打开文件" );
				if( index == JFileChooser.APPROVE_OPTION )
				{
					String path = jChooser.getSelectedFile().getAbsolutePath();
					System.out.println( "选中的文件路径：" + path );

				}

			}
		} );

		// 文件复制

		copy.addActionListener( new ActionListener() {

			public void actionPerformed( ActionEvent e ) {
				System.out.println( "复制" );

			}
		} );

		// 粘贴
		pas.addActionListener( new ActionListener() {

			public void actionPerformed( ActionEvent e ) {
				System.out.println( "复制" );

			}
		} );

		// 打印机设置
		printset.addActionListener( new ActionListener() {

			public void actionPerformed( ActionEvent e ) {
				System.out.println( "打印机设置" );

			}
		} );

		// 打印任务
		menu4.addActionListener( new ActionListener() {

			public void actionPerformed( ActionEvent e ) {
				System.out.println( "打印任务" );

			}
		} );

		// 打印历史
		menu5.addActionListener( new ActionListener() {

			public void actionPerformed( ActionEvent e ) {
				System.out.println( "打印历史" );

			}
		} );

		// 帮助
		menu6.addActionListener( new ActionListener() {

			public void actionPerformed( ActionEvent e ) {
				System.out.println( "帮助" );

			}
		} );

		// 关于系统
		menu7.addActionListener( new ActionListener() {

			public void actionPerformed( ActionEvent e ) {
				System.out.println( "关于系统" );

			}
		} );

		// 退出
		menu8.addActionListener( new ActionListener() {

			public void actionPerformed( ActionEvent e ) {
				System.out.println( "退出" );
				System.exit( 0 );

			}
		} );

		// 设置管理员
		menu9.addActionListener( new ActionListener() {

			public void actionPerformed( ActionEvent e ) {
				System.out.println( "设置管理员" );

			}
		} );

	}

	public static void main( String[] args ) {
		LoginFrame login = new LoginFrame();
		login.setVisible( true );

	}

}
