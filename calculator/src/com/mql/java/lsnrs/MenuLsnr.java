package com.mql.java.lsnrs;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JDialog;
import javax.swing.JFrame;

import com.mql.java.panels.AboutDialog;

public class MenuLsnr implements ActionListener {

	private JFrame parent;
	
	public  MenuLsnr(JFrame parent) {
		this.parent = parent;
	}
    

	@Override
	public void actionPerformed(ActionEvent e) {
		String val = e.getActionCommand().toLowerCase();
		
		switch(val){
		case "exit":
			System.exit(0);
			break;
		case "about us":
			//JOptionPane.showMessageDialog(parent, "salam");
			JDialog dlgAbout = new AboutDialog(parent, "About Us", true);
			dlgAbout.setVisible(true);
			break;
		
		}
		
	}
}
