package com.mql.java.panels;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import com.mql.java.containers.VerticalBoxContainer;



@SuppressWarnings("serial")
public class AboutDialog extends JDialog implements ActionListener {
	JButton exitOne;

	public AboutDialog(JFrame parent, String title, boolean modal){
		super(parent, title, modal);
		setBackground(Color.DARK_GRAY);
		
		JPanel p1 = new JPanel(new FlowLayout(FlowLayout.CENTER));

		StringBuffer text = new StringBuffer();
		text.append("Homework calculator\n\n");
		text.append("Developer:	Said Thitah\n");
		text.append("Version:	1.0");
		
		JTextArea jtAreaAbout = new JTextArea(5, 21);
		jtAreaAbout.setText(text.toString());
		jtAreaAbout.setFont(new Font("arial", 1, 14));
		jtAreaAbout.setEditable(false);

		p1.add(jtAreaAbout);
		p1.setBackground(Color.GRAY);
		//getContentPane().add(p1, BorderLayout.CENTER);

		JPanel p2 = new JPanel(new FlowLayout(FlowLayout.CENTER));
		exitOne = new JButton(" OK ");
		exitOne.addActionListener(this);

		p2.add(exitOne);
		
		getContentPane().add(new VerticalBoxContainer(p1,p2));

		setLocation(408, 270);
		setResizable(false);

		addWindowListener(new WindowAdapter() {
				public void windowClosing(WindowEvent e)
				{
					Window aboutDialog = e.getWindow();
					aboutDialog.dispose();
				}
			}
		);

		pack();
	}

	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource() == exitOne)	{
			this.dispose();
		}
	}
	
}