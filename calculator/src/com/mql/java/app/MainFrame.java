package com.mql.java.app;

import java.awt.BorderLayout;
import java.awt.Color;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JTextField;

import com.mql.java.containers.DisplayContainer;
import com.mql.java.containers.HorizontalBoxContainer;
import com.mql.java.containers.VerticalBoxContainer;
import com.mql.java.lsnrs.BtnLsnr;
import com.mql.java.lsnrs.MemoryLsnr;
import com.mql.java.lsnrs.NumbersKeyLsnr;
import com.mql.java.lsnrs.NumbersLsnr;
import com.mql.java.lsnrs.OpsKeyLsnr;
import com.mql.java.lsnrs.OpsLsnr;
import com.mql.java.lsnrs.OtherLsnr;
import com.mql.java.panels.ButtonPanel;
import com.mql.java.panels.DisplayPanel;
import com.mql.java.panels.Menu;

@SuppressWarnings("serial")
public class MainFrame extends JFrame{
	BtnLsnr lsnr;
	DisplayPanel displayZone;

	public MainFrame() {
		super("Calculator");
		displayZone = new DisplayPanel(new JTextField() , new JTextField());
		setLayout(new BorderLayout());




		URL logoOneUrl = getClass().getResource("/icons/calculator.png");
		ImageIcon logoOne = new ImageIcon(logoOneUrl);
		setIconImage(logoOne.getImage());
		mainMethod();
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(296 , 340);
		setFocusable(true);
		//setResizable(false);
		addKeyListener(new NumbersKeyLsnr(displayZone));
		addKeyListener(new OpsKeyLsnr(displayZone));
		setBackground(Color.BLUE);
		setVisible(true);

	}
	private void  mainMethod(){



		String [][]items = 	{
				{"File","Exit"},	
				{"Help","About Us"}
		};

		Menu m = new Menu(this , items);
		setJMenuBar(m);

		//displayZone.setPreferredSize(new Dimension(this.getPreferredSize().width, 70));
		ButtonPanel nmbs = new ButtonPanel(4,0,"7" , "8" , "9" ,
				"4" , "5" , "6" ,
				"1" , "2" , "3" ,
				"0" , "," ,  "=");

		ButtonPanel ops = new ButtonPanel(4,0,"1/x" , "√",
				"+" , "-" ,
				"*" , "/" ,
				"%" , "+|-");


		ButtonPanel mems = new ButtonPanel(1,12,"M+","M-","MS","MR","MC");

		ButtonPanel others = new ButtonPanel(1, 14, "←","CE","C");

		lsnr = new MemoryLsnr(displayZone, mems);
		for (int i = 0; i < mems.getBtnCount(); i++) {
			mems.getBtn(i).addActionListener(lsnr);
		}


		lsnr = new OtherLsnr(displayZone, others);
		for (int i = 0; i < others.getBtnCount(); i++) {
			others.getBtn(i).addActionListener(lsnr);
		}

		nmbs.setZone(displayZone , Color.WHITE);
		lsnr = new NumbersLsnr(displayZone , nmbs);
		for (int i = 0; i < nmbs.getBtnCount(); i++) {
			nmbs.getBtn(i).addActionListener(lsnr);
		}

		lsnr=new OpsLsnr(displayZone, ops);
		for (int i = 0; i < ops.getBtnCount(); i++) {

			ops.getBtn(i).addActionListener(lsnr);
		}

		add(new VerticalBoxContainer(mems ,others, new HorizontalBoxContainer(nmbs , ops) )  , BorderLayout.CENTER);
		add(new DisplayContainer(displayZone) , BorderLayout.NORTH);

	}
}
