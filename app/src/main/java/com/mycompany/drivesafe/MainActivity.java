package com.mycompany.drivesafe;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity implements OnClickListener {
ImageButton next;
    Spinner sex;
 String gender;

    EditText weight,time;
    float weight1;
    float time1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sex=(Spinner) findViewById(R.id.spinner_gender);
        weight=(EditText) findViewById(R.id.editText_weight);
        time= (EditText) findViewById(R.id.editText_time);
        //weight1= Float.valueOf(weight.getText().toString());

        //time1=Float.valueOf(time.getText().toString());
        next= (ImageButton) findViewById(R.id.button_next);
        next.setOnClickListener(this);


    }





    @Override
    public void onClick(View v) {
        gender=sex.getSelectedItem().toString();
        try{
            weight1=Float.valueOf(weight.getText().toString());
        }catch (NumberFormatException e){
            e.printStackTrace();
        }

        try{
            time1=Float.valueOf(time.getText().toString());
        }catch (NumberFormatException e){
            e.printStackTrace();
        }
        Intent intent = new Intent(this, Activity2.class);
        Bundle b = new Bundle();
        b.putFloat("weight", weight1);
        b.putFloat("time", time1);
        b.putString("gender",gender);
        intent.putExtras(b);
        startActivity(intent);
        finish();
    }
}
