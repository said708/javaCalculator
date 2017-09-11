package com.mql.java.lsnrs;

import java.awt.event.ActionEvent;

import com.mql.java.panels.ButtonPanel;
import com.mql.java.panels.DisplayPanel;

public class OtherLsnr extends BtnLsnr{



	public OtherLsnr(DisplayPanel zone, ButtonPanel btns) {
		super(zone, btns);
		clearAll();
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		for (int i=0; i< btns.getBtnCount(); i++){
			String value = btns.getBtn(i).getText();
			if(e.getSource() == btns.getBtn(i)){
				switch(value){
				case "←":
					processBackSpace();
					//System.out.println(memory);
					break;
				case "CE":	// +/-
					clearExisting();
					break;
				case "C":	// +/-
					clearAll();
					break;

				}
			}

		}
	}





}
