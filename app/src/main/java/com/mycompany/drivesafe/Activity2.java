package com.mycompany.drivesafe;

import android.content.Context;
import android.content.Intent;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

import java.text.DecimalFormat;

public class Activity2 extends AppCompatActivity implements View.OnClickListener{
ImageButton calculate;




    EditText beer,wine,hard,test;
    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);
        beer=(EditText) findViewById(R.id.editText_beer);
        wine= (EditText) findViewById(R.id.editText_wine);
        hard= (EditText) findViewById(R.id.editText_hard);






        //test.setText(beer1);
        calculate= (ImageButton) findViewById(R.id.button_calculate);
        calculate.setOnClickListener(this);

    }




    @Override
    public void onClick(View v) {
        double bace,bacp,bac,x,hour;
        float h;

        String s;
        float beer1=0;
        float wine1=0;
        float hard1=0;
        float weight1;
        float time1;
        double r;
        String gender;
        Intent intent=getIntent();
        weight1=intent.getExtras().getFloat("weight");
        time1=intent.getExtras().getFloat("time");
        gender=intent.getExtras().getString("gender");
        if(gender== "Male")
        {r=0.73;}
        else
        {r=0.66;}

        try{
            beer1=Float.valueOf(beer.getText().toString());
        }catch (NumberFormatException e){
            e.printStackTrace();
        }
        try{
            wine1=Float.valueOf(wine.getText().toString());
        }catch (NumberFormatException e){
            e.printStackTrace();
        }

        try{
            hard1=Float.valueOf(hard.getText().toString());
        }catch (NumberFormatException e){
            e.printStackTrace();
        }
  double A=((beer1*14)+(wine1*14)+(hard1*14));

      bac= A-(14*time1);
        bac=bac/(weight1*454*r);
        bac=bac*100;

        hour = (.0005*weight1*454*r-A+14*time1)/(-14);
        //hour=(0.05*time1)/(bac);
        s=String.format("%.2f", hour);
//DecimalFormat df= new DecimalFormat();
        //df.setMaximumFractionDigits(2);
        //ho=df.format(h);
        //s=Float.toString(h);
 if (bac<0.05){

     Intent i = new Intent(this, Acitivity_pass.class);
     startActivity(i);

 }
        else{

            Intent y = new Intent(this, Activity_Fail.class);
     y.putExtra("s", s);


            startActivity(y);

        }



    }
}
