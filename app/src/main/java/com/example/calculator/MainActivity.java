package com.example.calculator;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.math.RoundingMode;
import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

 //Кнопки с числами
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

 //Кнопки операторов
 Button mBtnAddition;
 Button mBtnMultiplication;
 Button mBtnSubtraction;
 Button mBtnDivision;
 //Кнопка равно
 Button mBtnEqually;

 //Кнопка очистки
 Button mBtnC;
 //Кнопка удаления последнего символа
 Button mBtnBack;
 //Кнопка "+/-"
 Button mBtnPlusMinus;
 //Кнопка с точкой
 Button mBtnComma;

 //Поле ввода
 TextView mField;

 float mValue = 0;
 String mOperator = "";

 @Override
 protected void onCreate(@Nullable Bundle savedInstanceState) {
  super.onCreate(savedInstanceState);
  setContentView(R.layout.activity_main);

  //Кнопки с числами
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

  //Кнопки операторов
  mBtnAddition = findViewById(R.id.btnAddition);
  mBtnMultiplication = findViewById(R.id.btnMultiplication);
  mBtnSubtraction = findViewById(R.id.btnSubtraction);
  mBtnDivision = findViewById(R.id.btnDivision);
  //Кнопка равно
  mBtnEqually = findViewById(R.id.btnEqually);

  //Кнопка очистки
  mBtnC = findViewById(R.id.btnC);
  //Кнопка удаления последнего символа
  mBtnBack = findViewById(R.id.btnBack);
  //Кнопка "+/-"
  mBtnPlusMinus = findViewById(R.id.btnPlusMinus);
  //Кнопка с точкой
  mBtnComma = findViewById(R.id.btnComma);

  //Поле ввода
  mField = findViewById(R.id.field);

  /**
   Обработка кнопок с числами
   * */
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
    String operator = ((Button) button).getText().toString();
    mOperator = operator;

    String field = mField.getText().toString();
    mValue = Float.parseFloat(field);

    mField.setText("0");
   }
  };

  //Подписки
  mBtnAddition.setOnClickListener(operatorListener);
  mBtnMultiplication.setOnClickListener(operatorListener);
  mBtnSubtraction.setOnClickListener(operatorListener);
  mBtnDivision.setOnClickListener(operatorListener);

  /**
   Обработка кнопок с операторами и кнопки равно
   * */
  View.OnClickListener resultListener = new View.OnClickListener() {
   @Override
   public void onClick(View v) {
    onResultListener(v);
   }
   public void onResultListener(View button) {
    String field = mField.getText().toString();
    float value = Float.parseFloat(field);
    boolean i = true;
    float result = value;

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
    DecimalFormat format = new DecimalFormat("0.######");
    format.setRoundingMode(RoundingMode.DOWN);
    String resultText = format.format(result);

    mField.setText(resultText);
    mValue = result;
    mOperator = "";
   }
  };
  //Подписки
  mBtnEqually.setOnClickListener(resultListener);

  /**
   Обработка кнопки с "+/-"
   * */
  View.OnClickListener plusMinusListener = new View.OnClickListener() {
   @Override
   public void onClick(View v) {
    onPlusMinusListener(v);
   }
   public void onPlusMinusListener(View button) {
    String display = mField.getText().toString();
    float value = Float.parseFloat(display);
    value = value*-1;

    DecimalFormat format = new DecimalFormat("0.######");
    format.setRoundingMode(RoundingMode.DOWN);
    String resultText = format.format(value);

    mField.setText(String.valueOf(resultText));
   }
  };
  //Подписки
  mBtnPlusMinus.setOnClickListener(plusMinusListener);

  /**
   Обработка кнопки очистки поля
   * */
  View.OnClickListener clearListener = new View.OnClickListener() {
   @Override
   public void onClick(View v) {
    onClearListener(v);
   }
   public void onClearListener(View button) {
    mValue = 0;
    mOperator = "";
    mField.setText("0");
   }
  };
  //Подписки
  mBtnC.setOnClickListener(clearListener);

  /**
   Обработка кнопки удаления последнего символа
   * */
  View.OnClickListener backListener = new View.OnClickListener() {
   @Override
   public void onClick(View v) {
    onBackListener(v);
   }
   public void onBackListener(View button) {
    String field = mField.getText().toString();
    if (field.length() >1 ) {
     field = field.substring(0, field.length() - 1);
     mField.setText(field);
    }
    else if (field.length() <=1 ) {
     mField.setText("0");
    }
   }
  };
  //Подписки
  mBtnBack.setOnClickListener(backListener);

  /**
   Обработка кнопки с точкой
   * */
  View.OnClickListener commaListener = new View.OnClickListener() {
   @Override
   public void onClick(View v) {
    onCommaListener(v);
   }
   public void onCommaListener(View button) {
    String field = mField.getText().toString();
    String display = field + ".";
    mField.setText(display);
   }
  };
  //Подписки
   mBtnComma.setOnClickListener(commaListener);
 }
}

