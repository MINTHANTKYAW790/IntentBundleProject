package com.example.intentbundleproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class MainActivity3 extends AppCompatActivity {
    TextView mkpt,name,year,result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        mkpt = (TextView) findViewById(R.id.textViewMKPT);
        year = (TextView) findViewById(R.id.textViewYear);
        name = (TextView) findViewById(R.id.textViewName);
        result = (TextView) findViewById(R.id.textViewResult);

        Bundle bundle = getIntent().getBundleExtra("BDL2");
        mkpt.setText(bundle.getString("MKPT"));
        name.setText(bundle.getString("NAME"));
        year.setText(bundle.getString("YEAR"));
        result.setText(bundle.getString("RESULT"));

    }
}