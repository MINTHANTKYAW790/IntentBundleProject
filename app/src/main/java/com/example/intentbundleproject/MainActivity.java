package com.example.intentbundleproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText mkpt,name;
    AutoCompleteTextView year;
    String [] years = {"First","Second","Third","Fourth","Fifth","Master","Ph.D"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mkpt = (EditText) findViewById(R.id.editTextMKPT);
        name = (EditText) findViewById(R.id.editTextName);
        year = (AutoCompleteTextView) findViewById(R.id.autoCompleteTextView);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_dropdown_item_1line,years);
        year.setAdapter(adapter);
        year.setThreshold(1);

        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(MainActivity.this,MainActivity2.class);
                Bundle bundle = new Bundle();
                bundle.putString("MKPT",mkpt.getText().toString());
                bundle.putString("NAME",name.getText().toString());
                bundle.putString("YEAR",year.getText().toString());
                intent.putExtra("BDL",bundle);
                startActivity(intent);
            }
        });
    }
}