package com.mql.java.lsnrs;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import com.mql.java.panels.DisplayPanel;

public class OpsKeyLsnr extends OpsLsnr implements KeyListener{

	public OpsKeyLsnr(DisplayPanel Dzone) {
		zone=Dzone;
	}


	@Override
	public void keyTyped(KeyEvent e) {

		switch(e.getKeyChar()){
		case '/':
			processOperator("/");
			break;
		case '*':
			processOperator("*");
			break;
		case '-':
			processOperator("-");
			break;
		case '+':
			processOperator("+");
			break;
		case '|':	// +/-
			processSignChange();
			break;
		case 'v':	// CE
			clearExisting();
			break;
		case 'c':	// C
			clearAll();
			break;
		case '%':
			processPourcentage();
			break;
		}



	}
	@Override
	public void keyPressed(KeyEvent e) {
		if ((e.getKeyCode() == KeyEvent.VK_X) && ((e.getModifiers() & KeyEvent.CTRL_MASK) != 0)) {
			System.exit(0);
		}
		else if( e.getKeyChar() == KeyEvent.VK_BACK_SPACE)
			processBackSpace();

	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

}
