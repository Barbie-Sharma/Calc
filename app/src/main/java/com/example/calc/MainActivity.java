package com.example.calc;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText textfield;
    Button[] numberButtons = new Button[10];
    Button addButton, subButton, mulButton, divButton;
    Button decButton, equButton, delButton, clrButton;
    Button negButton;

    double num1=0, num2=0, result=0;
    char operator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addButton = findViewById(R.id.plus);
        subButton = findViewById(R.id.sub);
        mulButton = findViewById(R.id.mul);
        divButton = findViewById(R.id.div);
        decButton = findViewById(R.id.deci);
        equButton = findViewById(R.id.equ);
        delButton = findViewById(R.id.del);
        clrButton = findViewById(R.id.clear);
        negButton = findViewById(R.id.neg);

        numberButtons[0] = findViewById(R.id.num0);
        numberButtons[1] = findViewById(R.id.num1);
        numberButtons[2] = findViewById(R.id.num2);
        numberButtons[3] = findViewById(R.id.num3);
        numberButtons[4] = findViewById(R.id.num4);
        numberButtons[5] = findViewById(R.id.num5);
        numberButtons[6] = findViewById(R.id.num6);
        numberButtons[7] = findViewById(R.id.num7);
        numberButtons[8] = findViewById(R.id.num8);
        numberButtons[9] = findViewById(R.id.num9);

        for(int i = 0; i<10; i++){
            int temp = i;
            numberButtons[i].setOnClickListener(v -> textfield.setText(String.format("%s%s", textfield.getText(), temp)));
        }

        decButton.setOnClickListener(view -> textfield.setText(String.format("%s%s", textfield.getText(), ".")));

        addButton.setOnClickListener(view -> {
            num1 = Double.parseDouble(String.valueOf(textfield.getText()));
            operator = '+';
            textfield.setText("");
        });

        subButton.setOnClickListener(view -> {
            num1 = Double.parseDouble(String.valueOf(textfield.getText()));
            operator = '-';
            textfield.setText("");
        });

        mulButton.setOnClickListener(view -> {
            num1 = Double.parseDouble(String.valueOf(textfield.getText()));
            operator = '*';
            textfield.setText("");
        });

        mulButton.setOnClickListener(view -> {
            num1 = Double.parseDouble(String.valueOf(textfield.getText()));
            operator = '*';
            textfield.setText("");
        });

        divButton.setOnClickListener(view -> {
            num1 = Double.parseDouble(String.valueOf(textfield.getText()));
            operator = '/';
            textfield.setText("");
        });

        equButton.setOnClickListener(view -> {
            num2 = Double.parseDouble(String.valueOf(textfield.getText()));
            switch(operator) {
                case'+':
                    result = num1 + num2;
                    break;
                case'-':
                    result = num1 - num2;
                    break;
                case'*':
                    result = num1 * num2;
                    break;
                case'/':
                    result = num1 / num2;
                    break;
            }
            textfield.setText(String.valueOf(result));
            num1 = result;
        });

        clrButton.setOnClickListener(view -> textfield.setText(""));

        delButton.setOnClickListener(view -> {
            String string = String.valueOf(textfield.getText());
            textfield.setText("");
            for(int i = 0; i<string.length()-1; i++) {
                textfield.setText(String.format("%s%s", textfield.getText(), string.charAt(i)));
            }
        });

        negButton.setOnClickListener(view -> {
            double temp = Double.parseDouble(String.valueOf(textfield.getText()));
            temp*=-1;
            textfield.setText(String.valueOf(temp));
        });
    }
}