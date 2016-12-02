package com.mycompany.drivesafe;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.TextView;
import android.net.Uri;

public class Activity_Fail extends AppCompatActivity implements OnClickListener {
double hour;
    ImageButton button;
    TextView textview;
    String s;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity__fail);
        textview=(TextView) findViewById(R.id.textView3);
        button=(ImageButton) findViewById(R.id.imageButton);
        Intent intent=getIntent();
        //Bundle b=getIntent();
        //hour=intent.getSt("hour");
        //s=Double.toString(hour);
        s=intent.getStringExtra("s");
        textview.setText(s);
        button.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_VIEW);
        intent.addCategory(Intent.CATEGORY_BROWSABLE);
        intent.setData(Uri.parse("https://www.google.com/search?site=&source=hp&ei=y69IVt_yBcGzeM3OqugG&q=taxi+service+near+me+&oq=taxi+service+near+me+&gs_l=mobile-gws-hp.3..0l4j0i22i30.16141.23610.0.24353.18.18.0.11.11.0.260.2367.1j14j2.17.23624....0...1c.1j4j5.64.mobile-gws-hp..1.17.1059.0.C9BTQrpxXME#"));
        startActivity(intent);
        this.finish();
    }
}
