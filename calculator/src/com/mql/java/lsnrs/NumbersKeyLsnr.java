package com.mql.java.lsnrs;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import com.mql.java.panels.DisplayPanel;

public class NumbersKeyLsnr extends NumbersLsnr implements KeyListener{

	public NumbersKeyLsnr(DisplayPanel displayZone) {
		this.zone = displayZone;
	}

	@Override
    public void keyTyped(KeyEvent e) {
		
			switch(e.getKeyChar()){
			case '0':
				addNbrToDsp(0);
				break;

			case '1':
				addNbrToDsp(1);
				break;

			case '2':
				addNbrToDsp(2);
				break;

			case '3':
				addNbrToDsp(3);
				break;

			case '4':
				addNbrToDsp(4);
				break;

			case '5':
				addNbrToDsp(5);
				break;

			case '6':
				addNbrToDsp(6);
				break;

			case '7':
				addNbrToDsp(7);
				break;

			case '8':
				addNbrToDsp(8);
				break;

			case '9':
				addNbrToDsp(9);
				break;
			case '.':	
				addDecimalPoint();
				break;
			case '=':
				processEquals();
				break;
			case KeyEvent.VK_ENTER:
				processEquals();
				break;
			}
		}
        


    @Override
    public void keyPressed(KeyEvent e) {

        

    }

    @Override
    public void keyReleased(KeyEvent e) {
       
    }

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	

	
}
