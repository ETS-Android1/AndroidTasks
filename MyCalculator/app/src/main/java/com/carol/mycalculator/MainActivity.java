package com.carol.mycalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView mainScreen;
    private Button AC, Power, Back, Div, Zero, One, Two, Three, Four, Five, Six, Seven, Eight, Nine, Multiply,Subtract, Add, Point, Ans, Equals;
    private String input, Result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mainScreen=findViewById(R.id.main_screen);
        AC=findViewById(R.id.ac);
        Power=findViewById(R.id.power);
        Back=findViewById(R.id.back);
        Div=findViewById(R.id.div);
        Zero=findViewById(R.id.zero);
        One=findViewById(R.id.one);
        Two=findViewById(R.id.two);
        Three=findViewById(R.id.three);
        Four=findViewById(R.id.four);
        Five=findViewById(R.id.five);
        Six=findViewById(R.id.six);
        Seven=findViewById(R.id.seven);
        Eight=findViewById(R.id.eight);
        Nine=findViewById(R.id.nine);
        Multiply=findViewById(R.id.multiply);
        Subtract=findViewById(R.id.subtract);
        Add=findViewById(R.id.plus);
        Point=findViewById(R.id.point);
        Ans=findViewById(R.id.ans);
        Equals=findViewById(R.id.equals);

    }

    public void ButtonClick(View view){
        Button button=(Button) view;
        String data = button.getText().toString();

        switch (data){
            case "AC":
                input = "";
                break;
            case "ANS":
                input+=Ans;
                break;
            case "*":
                Solve();
               input+="*";
               break;
            case "^":
                Solve();
                input+="^";
                break;
            case "=":
                Solve();
                Result =input;
                break;
            case "⬅":
                String newText =input.substring(0,input.length()-1);
                input=newText;
                break;
            default:
                if (input==null){
                    input="";
                }
                if (data.equals("+")||data.equals("-")||data.equals("/")){
                    Solve();
                }
                input+=data;

        }
        mainScreen.setText(input);
    }
    private void Solve(){

        if(input.split("\\*").length==2){
            String number[]=input.split("\\*");
            double multi = Double.parseDouble(number[0])*Double.parseDouble(number[1]);
            input = multi+"";
        }

        else if(input.split("/").length==2){
            String number[]=input.split("/");
            double div = Double.parseDouble(number[0])/Double.parseDouble(number[1]);
            input = div+"";
        }

        else if(input.split("\\^").length==2){
            String number[]=input.split("\\^");

                double pow = Math.pow( Double.parseDouble(number[0]),Double.parseDouble(number[1]));
                input = pow+"";

        }

        else if(input.split("\\+").length==2){
            String number[]=input.split("\\+");

            double add = Double.parseDouble(number[0])+Double.parseDouble(number[1]);
            input = add+"";

        }

        else if(input.split("-").length>1){
            String number[]=input.split("-");
            if (number[0] == "" && number.length==2){
                number[0]=0+"";
            }

            double sub = 0;
            if (number.length==2) {

                    sub = Double.parseDouble(number[0]) - Double.parseDouble(number[1]);
            }
            else if (number.length==3){
                sub = Double.parseDouble(number[1]) - Double.parseDouble(number[2]);
            }
            input = sub+"";

        }
        String n[]=input.split("\\.");
        if (n.length>1){
            if (n[1].equals(("0"))){
                input=n[0];
            }

        }
        mainScreen.setText(input);

    }
}