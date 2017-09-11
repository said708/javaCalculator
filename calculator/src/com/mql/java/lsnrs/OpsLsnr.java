package com.mql.java.lsnrs;

import java.awt.event.ActionEvent;

import com.mql.java.panels.ButtonPanel;
import com.mql.java.panels.DisplayPanel;

public class OpsLsnr extends BtnLsnr {



	public OpsLsnr(){

	}

	public OpsLsnr(DisplayPanel zone, ButtonPanel btns) {
		super(zone, btns);
		clearAll();
	}


	public void actionPerformed(ActionEvent e) {
		for (int i=0; i< btns.getBtnCount(); i++){
			String value = btns.getBtn(i).getText();
			if(e.getSource() == btns.getBtn(i)){
				switch(value){
				case "/":
					processOperator("/");
					break;
				case "*":
					processOperator("*");
					break;
				case "-":
					processOperator("-");
					break;
				case "+":
					processOperator("+");
					break;
				case "+|-":	// +/-
					processSignChange();
					break;
				case "√":
					processOtherOperator("√");
					//System.out.println(memory);
					break;
				case "1/x":
					processOtherOperator("1/x");
					break;
				case "%":
					processPourcentage();
					break;
				}
			}
		}
	}



	void processPourcentage(){
		double result = getNumberInDisplay();
		if (displayMode != ERROR_MODE){
			try	{
				double ds  = result/ 100;
				displayResult(ds+"");
			}

			catch(Exception ex)	{
				displayError("Invalid input for function!");
				displayMode = ERROR_MODE;
			}
		}
	}


	void processOperator(String op) {
		if (displayMode != ERROR_MODE){

			double numberInDisplay = getNumberInDisplay();

			if (!lastOperator.equals("0"))	{
				try{
					double result = processLastOperator();

					displayResult(getFormattedText(result));
					lastNumber = result;

				}

				catch (Exception e){}
			}

			else{
				lastNumber = numberInDisplay;
			}

			zone.setOperationZone(getFormattedText(lastNumber)+op);
			clearDisplayZone = true;
			lastOperator = op;
			//System.out.println(clearOnNextDigit);
		}
	}




	private void processOtherOperator(String other){
		if (displayMode != ERROR_MODE){
			double result=0;
			double numberInDisplay = getNumberInDisplay();

			if(other.equals("√")){
				try
				{
					if (Double.parseDouble(getDisplayString()) < 0)
						throw new Exception("Invalid Number");

					result = Math.sqrt(numberInDisplay);
					displayResult(getFormattedText(result));
					zone.setOperationZone(other+getFormattedText(numberInDisplay));
				}catch(Exception ex){
					displayError(ex.getMessage());
					displayMode = ERROR_MODE;
				}
			}
			else if(other.equals("1/x")){
				try{
					if (numberInDisplay == 0)
						throw new Exception("dividing By Zero");
					zone.setOperationZone("1/"+getFormattedText(numberInDisplay));
					result = 1 / numberInDisplay;
					displayResult(getFormattedText(result));

				}catch(Exception ex){
					displayError(ex.getMessage());
					displayMode = ERROR_MODE;
				}
			}
			


		}

	}





	void processSignChange(){
		if (displayMode == INPUT_MODE)
		{
			String input = getDisplayString();

			if (input.length() > 0 && !input.equals("0"))
			{
				if (input.indexOf("-") == 0)
					setDisplayString(input.substring(1));

				else
					setDisplayString("-" + input);
			}

		}

		else if (displayMode == RESULT_MODE)
		{
			double numberInDisplay = getNumberInDisplay();

			if (numberInDisplay != 0)
				displayResult(getFormattedText(-numberInDisplay));
		}
	}


}
