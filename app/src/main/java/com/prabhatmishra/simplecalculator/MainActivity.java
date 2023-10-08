package com.prabhatmishra.simplecalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
        double firstNum;
        String operation;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button num0 = findViewById(R.id.num0);
        Button num1 = findViewById(R.id.num1);
        Button num2 = findViewById(R.id.num2);
        Button num3 = findViewById(R.id.num3);
        Button num4 = findViewById(R.id.num4);
        Button num5 = findViewById(R.id.num5);
        Button num6 = findViewById(R.id.num6);
        Button num7 = findViewById(R.id.num7);
        Button num8 = findViewById(R.id.num8);
        Button num9 = findViewById(R.id.num9);

        Button add = findViewById(R.id.add);
        Button sub = findViewById(R.id.min);
        Button div = findViewById(R.id.div);
        Button mul = findViewById(R.id.mul);
        Button des = findViewById(R.id.point);
        Button equal= findViewById(R.id.equal);

        Button esc = findViewById(R.id.ac);
        Button clr = findViewById(R.id.del);
        Button on= findViewById(R.id.on);
        Button off = findViewById(R.id.off);

        TextView screen=findViewById(R.id.screen);

        esc.setOnClickListener(view -> {
            firstNum=0;
            screen.setText("0");
        });

        off.setOnClickListener(view -> screen.setVisibility(View.GONE));
        on.setOnClickListener(view -> {
            screen.setVisibility(View.VISIBLE);
            screen.setText("O");
        });

        ArrayList<Button> numbers=new ArrayList<>();
        numbers.add(num0);
        numbers.add(num1);
        numbers.add(num2);
        numbers.add(num3);
        numbers.add(num4);
        numbers.add(num5);
        numbers.add(num6);
        numbers.add(num7);
        numbers.add(num8);
        numbers.add(num9);

        for (Button b:numbers){
            b.setOnClickListener(view -> {
                if(!screen.getText().toString().equals("0")){
                    screen.setText(screen.getText().toString() + b.getText().toString());
                }else {
                    screen.setText(b.getText().toString());
                }
            });
        }
        ArrayList<Button> opers=new ArrayList<>();
        opers.add(div);
        opers.add(mul);
        opers.add(sub);
        opers.add(add);
        for (Button b:opers){
            b.setOnClickListener(view -> {
                firstNum=Double.parseDouble(screen.getText().toString());
                operation=b.getText().toString();
                screen.setText("0");

            });
        }
        clr.setOnClickListener(view -> {
            String num=screen.getText().toString();
            if (num.length()>1){
                screen.setText(num.substring(0,num.length()-1));
            }else if(num.length()==1 && !num.equals("0")){
                screen.setText("0");
            }
        });
        des.setOnClickListener(view -> {
            if(!screen.getText().toString().contains(".")){
                screen.setText(screen.getText().toString() +"_");
            }
        });
        equal.setOnClickListener(view -> {
            double secondNum =Double.parseDouble(screen.getText().toString());
            double result;
            switch (operation){
                case "/":
                    result=firstNum/secondNum;
                    break;
                case "X":
                    result=firstNum*secondNum;
                    break;
                case "+":
                    result=firstNum+secondNum;
                    break;
                case "-":
                    result=firstNum-secondNum;
                    break;
                default:
                    result=firstNum+secondNum;
            }
            screen.setText(String.valueOf(result));
            firstNum=result;
        });
    }
}