package com.example.romannumeralconverter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button convertToNumber, convertToRoman;
    EditText editNumber, editRoman;
    TextView numberOutput, romanOutput;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        convertToNumber = (Button) findViewById(R.id.convertToNumber);
        convertToRoman = (Button) findViewById(R.id.convertToRoman);
        editNumber = (EditText) findViewById(R.id.editNumber);
        editRoman = (EditText) findViewById(R.id.editRoman);
        numberOutput = (TextView) findViewById(R.id.numberOutput);
        romanOutput = (TextView) findViewById(R.id.romanOutput);


        convertToRoman.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                NumberConverter nc = new NumberConverter();

                //Number taken from the user
                int number = Integer.parseInt(editNumber.getText().toString());

                //String to send back to user
                String roman = nc.toRoman(number);

                //Output roman numeral to user
                romanOutput.setText(roman);
            }
        });

        convertToNumber.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                NumberConverter nc = new NumberConverter();

                //Numeral taken from the user
                String numeral = editRoman.getText().toString();


                int number = nc.toNumber(numeral);

                numberOutput.setText(String.valueOf(number));
            }
        });

    }
}