package com.example.zkstp115;

import java.text.DecimalFormat;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends Activity implements OnClickListener {
	private EditText calculatorDisplay;
	Button butt0,butt1,butt2,butt3,butt4,butt5,butt6,butt7,butt8,butt9,
	buttonAdd,buttonSubtract,buttonMultiply,buttonDivide,buttonToggleSign,buttonDecimalPoint,
	buttonEquals,buttonClear,buttonAddToMemory,buttonSubtractFromMemory,buttonSin,buttonCos,buttonInvert,
	buttonSquareRoot,buttonSquare,buttonTan,buttonRecallMemory,buttonSquared,buttonClearMemory;
    private static final String DIGITS = "0123456789.";
    private Boolean userIsInTheMiddleOfTypingANumber = false;
 
    DecimalFormat df = new DecimalFormat("@###########");
    CalculatorBrain brain;
    
    @SuppressLint("NewApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        brain = new CalculatorBrain();
        calculatorDisplay = (EditText) findViewById(R.id.editText1);
        df.setMinimumFractionDigits(0);
        df.setMinimumIntegerDigits(1);
        df.setMaximumIntegerDigits(8);
        buttonCos = (Button)findViewById(R.id.button1);
        buttonTan = (Button)findViewById(R.id.button2);
        buttonAddToMemory = (Button)findViewById(R.id.button3);
        buttonSubtractFromMemory = (Button)findViewById(R.id.button4);
        buttonSin = (Button)findViewById(R.id.button5);
        buttonRecallMemory = (Button)findViewById(R.id.button6);
        buttonClear = (Button)findViewById(R.id.button7);
        buttonSquared = (Button)findViewById(R.id.button8);
        buttonToggleSign= (Button)findViewById(R.id.button9);
        buttonSquareRoot = (Button)findViewById(R.id.button10);
        butt7 = (Button)findViewById(R.id.button11);
        butt8 = (Button)findViewById(R.id.button12);
        butt9 = (Button)findViewById(R.id.button13);
        buttonClearMemory = (Button)findViewById(R.id.button15);
        buttonDivide = (Button)findViewById(R.id.button14);
        butt4 = (Button)findViewById(R.id.button16);
        butt5 = (Button)findViewById(R.id.button17);
        butt6 = (Button)findViewById(R.id.button18);
        buttonMultiply = (Button)findViewById(R.id.button19);
        buttonInvert = (Button)findViewById(R.id.button20);
        butt1 = (Button)findViewById(R.id.button21);
        butt2 = (Button)findViewById(R.id.button22);
        butt3 = (Button)findViewById(R.id.button23);
        buttonSubtract = (Button)findViewById(R.id.button24);
        buttonEquals = (Button)findViewById(R.id.button25);
        butt0 = (Button)findViewById(R.id.button26);
        buttonDecimalPoint = (Button)findViewById(R.id.button27);
        buttonAdd = (Button)findViewById(R.id.button28);
        
        buttonCos.setOnClickListener(this);
        buttonTan.setOnClickListener(this);
        buttonAddToMemory.setOnClickListener(this);
        buttonSubtractFromMemory.setOnClickListener(this);
        buttonSin.setOnClickListener(this);
        buttonRecallMemory.setOnClickListener(this);
        buttonClear.setOnClickListener(this);
        buttonSquared.setOnClickListener(this);
        buttonToggleSign.setOnClickListener(this);
        buttonSquareRoot.setOnClickListener(this);
        butt7.setOnClickListener(this);
        butt8.setOnClickListener(this);
        butt9.setOnClickListener(this);
        buttonClearMemory.setOnClickListener(this);
        buttonDivide.setOnClickListener(this);
        butt4.setOnClickListener(this);
        butt5.setOnClickListener(this);
        butt6.setOnClickListener(this);
        buttonMultiply.setOnClickListener(this);
        buttonInvert.setOnClickListener(this);
        butt1.setOnClickListener(this);
        butt2.setOnClickListener(this);
        butt3.setOnClickListener(this);
        buttonSubtract.setOnClickListener(this);
        buttonEquals.setOnClickListener(this);
        butt0.setOnClickListener(this);
        buttonDecimalPoint.setOnClickListener(this);
        buttonAdd.setOnClickListener(this);
        
        
    }

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		String buttonPressed = ((Button) v).getText().toString();
 
        if (DIGITS.contains(buttonPressed)) {
            if (userIsInTheMiddleOfTypingANumber) {
                calculatorDisplay.append(buttonPressed);
            } else {
                calculatorDisplay.setText(buttonPressed);
                userIsInTheMiddleOfTypingANumber = true;
            }
        	} 
        	else 
        	{
            if (userIsInTheMiddleOfTypingANumber) 
            {
                brain.setOperand(Double.parseDouble(calculatorDisplay.getText().toString()));
                userIsInTheMiddleOfTypingANumber = false;
            }
            brain.performOperation(buttonPressed);
            calculatorDisplay.setText(df.format(brain.getResult()));
 
        }
    }
	
	protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putDouble("OPERAND",brain.getResult());
        outState.putDouble("MEMORY", brain.getMemory());
    }
	
	 @Override
	    protected void onRestoreInstanceState(Bundle savedInstanceState) {
	        super.onRestoreInstanceState(savedInstanceState);
	        brain.setOperand(savedInstanceState.getDouble("OPERAND"));
	        brain.setMemory(savedInstanceState.getDouble("MEMORY"));
	        calculatorDisplay.setText(df.format(brain.getResult()));
	    }
		
}

