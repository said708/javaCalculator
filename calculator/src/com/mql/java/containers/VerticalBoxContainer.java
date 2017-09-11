package com.mql.java.containers;

import javax.swing.BoxLayout;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class VerticalBoxContainer extends JPanel{
	
		public VerticalBoxContainer(JPanel ...panels) {
			setLayout(new BoxLayout(this , BoxLayout.Y_AXIS));
			for (JPanel jPanel : panels) {
				add(jPanel);
			}
			
			
			
		
	}

}
