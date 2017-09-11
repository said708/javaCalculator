package com.mql.java.app;



import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;


public class App{


	
	public App() {
		
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					new MainFrame();
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null ,"Error : "+e.getMessage() );
				}

			}
		});
	}



	public static void main(String[] args) {
		new App();
	}

}
