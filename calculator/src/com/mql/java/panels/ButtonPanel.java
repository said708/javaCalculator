package com.mql.java.panels;


import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

@SuppressWarnings("serial")
public class ButtonPanel extends JPanel{

	private JButton btn;
	private DisplayPanel zone;



	public ButtonPanel(int numberOfContent ,int taille, String ...label) {
		setBorder(new EmptyBorder(4,4,4,4));
		setLayout(new GridLayout(numberOfContent,getComponentCount(),3,3));
		for (int i = 0; i < label.length; i++) {

			btn = new JButton(label[i]);
			btn.setFocusable(false);//resolve probleme  when button clicked keyListener not working
			if( btn.getText().contains("←")|| btn.getText().contains("M")){
				btn.setFont(new Font("time new roman", Font.BOLD, taille));
				btn.setForeground(Color.RED);
			}

			else if(btn.getText().contains("C")){
				//btn.setFont(new Font("arial", Font.BOLD, taille));
				btn.setForeground(Color.BLUE);
			}
			else if(btn.getText().contains("+") || btn.getText().contains("-") ||btn.getText().contains("/")
					|| btn.getText().contains("*") ||btn.getText().contains("+|-")|| btn.getText().contains("%")
					|| btn.getText().contains("=") ||btn.getText().contains("√")
					){
				btn.setFont(new Font("time new roman", Font.BOLD, 14));
				btn.setForeground(Color.RED);
			}
			else{
				btn.setFont(new Font("arial", Font.BOLD, 18));
				btn.setForeground(Color.DARK_GRAY);
			}

			btn.setBackground(Color.LIGHT_GRAY);
			add(btn);
		}
	}

	public JButton getBtn(int index){
		return (JButton)getComponent(index);
	}



	public DisplayPanel getZone() {
		return zone;
	}

	public void setZone(DisplayPanel zone , Color color) {
		zone.setBorder(new LineBorder(Color.GRAY, 2, true)); //10 is the radius
		zone.setBackground(Color.WHITE);
		zone.setForeground(Color.GRAY);
		this.zone = zone;


	}

	public int getBtnCount(){
		return getComponentCount();
	}

}
/*package com.mql.java.panels;


import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

public class ButtonPanel extends JPanel{

	JButton btn;
	JLabel zone;

	public ButtonPanel() {
		setBorder(new EmptyBorder(4,4,4,4));
		setLayout(new GridBagLayout());
		setSize(100 , 100);
	}

	public ButtonPanel(int colN , String ...label) {
		this();
		GridBagConstraints gc = new GridBagConstraints();

		gc.weighty = 0;
		gc.insets = new Insets(2, 2, 2, 2);
		gc.gridx = 0;
		gc.gridy = 0;
		for (int i = 0; i < label.length; i++) {
			gc.gridx++;

			if (i % colN == 0) {
				gc.gridx = 0;
				gc.gridy++;	
				gc.weightx = i;
			}
			if(label[i].equals("0")){
				gc.fill = GridBagConstraints.BOTH;
				gc.gridwidth = 3;
			}


			btn = new JButton(label[i]);
			if(label[i].equals("+/-")){
				btn.setFont(new Font("monospaced", Font.ITALIC, 16));
			}
			else{
			btn.setFont(new Font("monospaced", Font.ITALIC, 16));
			}
			btn.setForeground(Color.DARK_GRAY);
			btn.setBackground(Color.LIGHT_GRAY);


			add(btn , gc);


		}
	}

	public JButton getBtn(int index){
		return (JButton)getComponent(index);
	}



	String getDisplayString() {
		return zone.getText();
	}

	public JLabel getZone() {
		return zone;
	}

	public void setZone(JLabel zone) {
		this.zone = zone;
	}
	public int getBtnCount(){
		return getComponentCount();
	}

}

 */