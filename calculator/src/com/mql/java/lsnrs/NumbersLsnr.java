package com.mql.java.lsnrs;

import java.awt.event.ActionEvent;

import com.mql.java.panels.ButtonPanel;
import com.mql.java.panels.DisplayPanel;

public class NumbersLsnr extends BtnLsnr{


	public NumbersLsnr(DisplayPanel zone, ButtonPanel btns) {
		super(zone, btns);
	}
	
	public NumbersLsnr(){
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		for (int i=0; i<btns.getBtnCount(); i++){
			String value = btns.getBtn(i).getText();
			if(e.getSource() == btns.getBtn(i)){
				switch(value){
				case "0":
					addNbrToDsp(Integer.parseInt(value));
					break;

				case "1":
					addNbrToDsp(Integer.parseInt(value));
					break;

				case "2":
					addNbrToDsp(Integer.parseInt(value));
					break;

				case "3":
					addNbrToDsp(Integer.parseInt(value));
					break;

				case "4":
					addNbrToDsp(Integer.parseInt(value));
					break;

				case "5":
					addNbrToDsp(Integer.parseInt(value));
					break;

				case "6":
					addNbrToDsp(Integer.parseInt(value));
					break;

				case "7":
					addNbrToDsp(Integer.parseInt(value));
					break;

				case "8":
					addNbrToDsp(Integer.parseInt(value));
					break;

				case "9":
					addNbrToDsp(Integer.parseInt(value));
					break;
				case ",":	
					addDecimalPoint();
					break;
				case "=":
					processEquals();
					break;
				}
			}	
		}
	}
	





	

	void processEquals(){
		double result = 0;
		zone.setOperationZone("");
		if (displayMode != ERROR_MODE){
			try	{
				result = processLastOperator();


				displayResult(getFormattedText(result));
			}

			catch (Exception e){
				displayError("Divied By Zero");
			}

			lastOperator = "0";
		}
	}

	void addDecimalPoint(){
		displayMode = INPUT_MODE;

		if (clearDisplayZone)
			setDisplayString("");

		String inputString = getDisplayString();


		if (inputString.indexOf(".") < 0)
			setDisplayString(new String(inputString + "."));
	}

	


}
