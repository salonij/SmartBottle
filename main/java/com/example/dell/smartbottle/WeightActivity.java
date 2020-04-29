package com.example.dell.smartbottle;

import android.content.Intent;
import android.icu.text.DecimalFormat;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.ParseException;


public class WeightActivity extends AppCompatActivity {

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weight);
        final EditText weight = (EditText) findViewById(R.id.weight);
        final Button weightbut = (Button) findViewById(R.id.weighbut);
        final String name = getIntent().getStringExtra("name");
        weightbut.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (weight.getText().toString().equals("")) {
                    Toast.makeText(WeightActivity.this, "Enter weight", Toast.LENGTH_SHORT).show();
                } else {

                    double weigh = 0;
                    String s=weight.getText().toString();
                    double lbs=0;
                    try
                    {
                        weigh = Double.parseDouble(s);
                    }catch(Exception e) {
                        e.printStackTrace();
                    }
                    lbs = weigh / 0.45359237;
                    final double weigh_result = lbs*0.5;
                    Intent i = new Intent(WeightActivity.this, Exercise.class);
                    Bundle b = new Bundle();
                    b.putDouble("weigh_result", weigh_result);
                    i.putExtras(b);
                    i.putExtra("name",name);
                    i.putExtra("mass",weight.getText().toString());
                    startActivity(i);
                }
            }
        });
    }
}

