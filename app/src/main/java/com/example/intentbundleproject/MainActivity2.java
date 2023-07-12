package com.example.intentbundleproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity2 extends AppCompatActivity implements CompoundButton.OnCheckedChangeListener, View.OnClickListener {
    TextView mkpt,name,year;
    RadioButton pass,fail;
    String result = "";
    Bundle bundle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        mkpt = (TextView) findViewById(R.id.textViewMKPT);
        name = (TextView) findViewById(R.id.textViewName);
        year = (TextView) findViewById(R.id.textViewYear);

        pass = (RadioButton)findViewById(R.id.radioButton4);
        fail = (RadioButton) findViewById(R.id.radioButton3);

        bundle = getIntent().getBundleExtra("BDL");
        mkpt.setText(bundle.getString("MKPT"));
        name.setText(bundle.getString("NAME"));
        year.setText(bundle.getString("YEAR"));

        pass.setOnCheckedChangeListener(this);
        fail.setOnCheckedChangeListener(this);

        Button button = (Button) findViewById(R.id.button2);
        button.setOnClickListener(this);
    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        if ((buttonView.getId() ==  R.id.radioButton4) && isChecked){
            result = pass.getText().toString();
        }
        if ((buttonView.getId() ==  R.id.radioButton4) && isChecked){
            result = fail.getText().toString();
        }
    }

    @Override
    public void onClick(View view) {
        Intent intent = new Intent(MainActivity2.this,MainActivity3.class);
        bundle.putString("RESULT",result);
        intent.putExtra("BDL2",bundle);
    }
}