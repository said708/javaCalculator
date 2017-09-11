package com.mql.java.lsnrs;

import java.awt.event.ActionListener;

import com.mql.java.panels.ButtonPanel;
import com.mql.java.panels.DisplayPanel;

public abstract class BtnLsnr implements ActionListener{

	final int MAX_INPUT_LENGTH = 20;
	final int INPUT_MODE = 0;
	final int RESULT_MODE = 1;
	final int  ERROR_MODE = 2;
	protected double memory = 0;

	protected static double lastNumber;
	protected static String lastOperator;
	protected static int displayMode;
	protected static boolean clearDisplayZone;


	protected DisplayPanel zone;
	protected ButtonPanel btns;



	public BtnLsnr(DisplayPanel zone , ButtonPanel btns) {
		this.zone = zone;
		this.btns = btns;
	}
	public BtnLsnr(){

	}
	void addNbrToDsp(int digit){
		if (clearDisplayZone)
			setDisplayString("");

		String inputString = getDisplayString();

		if (inputString.indexOf("0") == 0){
			inputString = inputString.substring(1);
		}

		if ((!inputString.equals("0") || digit > 0)  && inputString.length() < MAX_INPUT_LENGTH){
			setDisplayString(inputString + digit);
		}


		displayMode = INPUT_MODE;
		clearDisplayZone = false;
	}







	void setDisplayString(String s){
		zone.setDisplayZone(s);
	}


	String getDisplayString (){
		return zone.getDisplayZone();
	}


	double getNumberInDisplay()	{
		return Double.parseDouble(getDisplayString ());
	}




	// print error on the screen
	void displayError(String errorMessage){
		setDisplayString(errorMessage);
		lastNumber = 0;
		displayMode = ERROR_MODE;
		clearDisplayZone = true;
	}


	// print the result  on the screen
	void displayResult(String result){
		setDisplayString(result);
		lastNumber = Double.parseDouble(result);
		displayMode = RESULT_MODE;
		clearDisplayZone = true;
	}

	//clear the  screen 
	public void clearAll()	{
		setDisplayString("0");
		lastOperator = "0";
		lastNumber = 0;
		zone.setOperationZone("");
		displayMode = INPUT_MODE;
		clearDisplayZone = true;
	}

	//clear the  result screen 
	void clearExisting(){
		setDisplayString("0");
		clearDisplayZone = true;
		displayMode = INPUT_MODE;
	}


	// remove the .0  when numbr is an integer
	static String getFormattedText(double temp)  {  
		String text = ".0";
		String res = String.valueOf(temp);
		int length = text.length();

		if (res.length() > length){
			res = res.substring((res.length() - length), res.length()).equals(text)
					? res.substring(0, (res.length() - length)) : res;
		}

		return res; 
	}



	double processLastOperator() throws Exception {
		double result = 0;
		double numberInDisplay = getNumberInDisplay();

		if (lastOperator.equals("/")){
			if (numberInDisplay == 0)
				throw (new Exception());

			result = lastNumber / numberInDisplay;
		}

		else if (lastOperator.equals("*"))
			result = lastNumber * numberInDisplay;

		else if (lastOperator.equals("-"))
			result = lastNumber - numberInDisplay;

		else if (lastOperator.equals("+"))
			result = lastNumber + numberInDisplay;
		return result;
	}

	public void processBackSpace(){
		setDisplayString(getDisplayString().substring(0,getDisplayString().length() - 1));

		if (getDisplayString().length() < 1)
			setDisplayString("0");
	}






}
