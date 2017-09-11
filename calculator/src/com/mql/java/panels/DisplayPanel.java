package com.mql.java.panels;

import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class DisplayPanel extends JPanel{

	private JTextField displayZone;
	private JTextField OperationZone;
	
	public DisplayPanel(JTextField displayZone , JTextField OperationZone) {
		
		this.displayZone=displayZone;
		this.OperationZone=OperationZone;
		
		this.displayZone.setBackground(Color.white);
		this.OperationZone.setBackground(Color.white);
		this.displayZone.setFont(new Font("arial", Font.BOLD, 18));
		this.displayZone.setOpaque(true);
		this.OperationZone.setFont(new Font("arial", Font.BOLD, 12));
		this.OperationZone.setEditable(false);
		this.displayZone.setEditable(false);
		this.OperationZone.setOpaque(true);
		this.OperationZone.setBorder(BorderFactory.createEmptyBorder());
		this.displayZone.setBorder(BorderFactory.createEmptyBorder());
		this.displayZone.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		this.OperationZone.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		this.displayZone.setOpaque(true);
		this.OperationZone.setOpaque(true);
		this.displayZone.setAlignmentX(0.75f);
		this.OperationZone.setAlignmentX(0.0f);
		
		
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		
		add(this.OperationZone );
		add(this.displayZone );
	}
	
	
	
	

	public String getDisplayZone() {
		return displayZone.getText();
	}

	public void setDisplayZone(String t) {
		this.displayZone.setText(t);
	}

	public String getOperationZone() {
		return OperationZone.getText();
	}

	public void setOperationZone(String t) {
		OperationZone.setText(t);;
	}
	
	public void _setDisplayZone(JTextField fl){
		 displayZone = fl;
	}
	
	
	
	
	

}
