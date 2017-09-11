package com.mql.java.lsnrs;

import java.awt.event.ActionEvent;

import com.mql.java.panels.ButtonPanel;
import com.mql.java.panels.DisplayPanel;

public class MemoryLsnr extends BtnLsnr{

	public MemoryLsnr(DisplayPanel zone, ButtonPanel btns) {
		super(zone, btns);
		clearAll();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		for (int i=0; i< btns.getBtnCount(); i++){
			String value = btns.getBtn(i).getText();
			if(e.getSource() == btns.getBtn(i)){
				switch(value){
				case "M+":
					processMemory("m+");
					//System.out.println(memory);
					break;
				case "M-":
					processMemory("m-");
					//System.out.println(memory);
					break;
				case "MC":
					processMemory("mc");
					//System.out.println(memory);
					break;
				case "MR":
					processMemory("mr");
					//System.out.println(memory);
					break;
				case "MS":
					processMemory("ms");
					//System.out.println(memory);
					break;
				}
			}

		}
	}



	public void processMemory(String mem){
		if (displayMode != ERROR_MODE){

			double numberInDisplay = getNumberInDisplay();
			
			if(mem.equals("ms")){
				memory = numberInDisplay;
			}
			else if(mem.equals("mr")){
				setDisplayString(getFormattedText(memory));
			}
			else if(mem.equals("mc")){
				memory=0;
			}
			else if(mem.equals("m+")){
				memory+=numberInDisplay;

			}
			else if(mem.equals("m-")){
				memory-=numberInDisplay;
			}


		}
	}

}
