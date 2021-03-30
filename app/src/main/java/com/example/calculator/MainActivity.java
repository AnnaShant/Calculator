package com.example.calculator;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.math.RoundingMode;
import java.text.DecimalFormat;

/**
 *
 */
public class MainActivity extends AppCompatActivity {

 //Кнопки
 Button mBtn0;
 Button mBtn1;
 Button mBtn2;
 Button mBtn3;
 Button mBtn4;
 Button mBtn5;
 Button mBtn6;
 Button mBtn7;
 Button mBtn8;
 Button mBtn9;

 Button mBtnAddition;
 Button mBtnMultiplication;
 Button mBtnSubtraction;
 Button mBtnDivision;

 Button mBtnC;
 Button mBtnBack;
 Button mBtnPlusMinus;
 Button mBtnComma;
 Button mBtnEqually;

 TextView mField;

 float mValue = 0;
 String mOperator = "";

 @Override
 protected void onCreate(@Nullable Bundle savedInstanceState) {
  super.onCreate(savedInstanceState);
  setContentView(R.layout.activity_main);

  mBtn0 = findViewById(R.id.btn0);
  mBtn1 = findViewById(R.id.btn1);
  mBtn2 = findViewById(R.id.btn2);
  mBtn3 = findViewById(R.id.btn3);
  mBtn4 = findViewById(R.id.btn4);
  mBtn5 = findViewById(R.id.btn5);
  mBtn6 = findViewById(R.id.btn6);
  mBtn7 = findViewById(R.id.btn7);
  mBtn8 = findViewById(R.id.btn8);
  mBtn9 = findViewById(R.id.btn9);

  mBtnAddition = findViewById(R.id.btnAddition);
  mBtnMultiplication = findViewById(R.id.btnMultiplication);
  mBtnSubtraction = findViewById(R.id.btnSubtraction);
  mBtnDivision = findViewById(R.id.btnDivision);
  mBtnEqually = findViewById(R.id.btnEqually);

  mBtnC = findViewById(R.id.btnC);
  mBtnBack = findViewById(R.id.btnBack);
  mBtnPlusMinus = findViewById(R.id.btnPlusMinus);
  mBtnComma = findViewById(R.id.btnComma);

  mField = findViewById(R.id.field);


  View.OnClickListener numberListener = new View.OnClickListener() {
   @Override
   public void onClick(View v) {
    onNumberClick(v);
   }

   public void onNumberClick(View button) {
    String number = ((Button) button).getText().toString();
    String field = mField.getText().toString();

    if (field.equals("0"))
     field = number;
    else
     field += number;

    mField.setText(field);
   }
  };

  //Подписки
  mBtn0.setOnClickListener(numberListener);
  mBtn1.setOnClickListener(numberListener);
  mBtn2.setOnClickListener(numberListener);
  mBtn3.setOnClickListener(numberListener);
  mBtn4.setOnClickListener(numberListener);
  mBtn5.setOnClickListener(numberListener);
  mBtn6.setOnClickListener(numberListener);
  mBtn7.setOnClickListener(numberListener);
  mBtn8.setOnClickListener(numberListener);
  mBtn9.setOnClickListener(numberListener);

  View.OnClickListener operatorListener = new View.OnClickListener() {
   @Override
   public void onClick(View v) {
    onOperatorListener(v);
   }

   public void onOperatorListener(View button) {
    //1
    String operator = ((Button) button).getText().toString();
    mOperator = operator;

    //2
    String field = mField.getText().toString();
    mValue = Float.parseFloat(field);

    //3
    mField.setText("0");
   }
  };

  mBtnAddition.setOnClickListener(operatorListener);
  mBtnMultiplication.setOnClickListener(operatorListener);
  mBtnSubtraction.setOnClickListener(operatorListener);
  mBtnDivision.setOnClickListener(operatorListener);

  View.OnClickListener resultListener = new View.OnClickListener() {

   @Override
   public void onClick(View v) {
    onResultListener(v);
   }

   public void onResultListener(View button) {
    //1
    String display = mField.getText().toString();
    float value = Float.parseFloat(display);
    boolean i = true;
    //2
    float result = value;
    //3
    switch (mOperator) {
     case "+": {
      result = value + mValue;
      break;
     }
     case "-": {
      result = mValue - value;
      break;
     }
     case "*": {
      result = mValue * value;
      break;
     }
     case "/": {
      if (value == 0) {
       i = true;
      } else {
       i = false;
       result = mValue / value;
      }
      break;
     }
    }
    //4
    DecimalFormat format = new DecimalFormat("0.######");
    format.setRoundingMode(RoundingMode.DOWN);
    String resultText = format.format(result);

    //5
    mField.setText(resultText);
    //6
    mValue = result;
    //7
    mOperator = "";
   }
  };
    mBtnEqually.setOnClickListener(resultListener);
  }
 }



