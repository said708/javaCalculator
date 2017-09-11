package com.mql.java.containers;

import javax.swing.BoxLayout;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class HorizontalBoxContainer extends JPanel {
	
	public HorizontalBoxContainer(JPanel ...panels) {
		setLayout(new BoxLayout(this , BoxLayout.X_AXIS));
		for (JPanel jPanel : panels) {
			add(jPanel);
		}




	}
}
