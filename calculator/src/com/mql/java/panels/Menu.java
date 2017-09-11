package com.mql.java.panels;

import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import com.mql.java.lsnrs.MenuLsnr;



@SuppressWarnings("serial")
public class Menu extends JMenuBar{
	private String folder = "/icons/";
	private String suffix = ".png";
	private JFrame parent;
	public Menu(JFrame parent , String [][]items) {
		this.parent = parent;
		for (int i = 0; i < items.length/*number of rows */; i++) {
			addMenu(items[i]);
		}
	}
	
	public void addMenu(String[] t){
		JMenu m = new JMenu(t[0]);
		
		add(m);
		for (int i = 1; i < t.length; i++) {
			if(t[i].equals("-")){
				m.addSeparator();
			}
			else{
				//get path to image as Stream
				URL img = getClass().getResource(folder+t[i].toLowerCase() + suffix);
				ImageIcon icon = new ImageIcon(img);
				JMenuItem mi = new JMenuItem(t[i] , icon );
				mi.addActionListener(new MenuLsnr(parent));
				m.add(mi);
			}
		}
	}
	
	public int getMenueCount(){
		return getComponentCount();
	}
	
	
	
	

}
