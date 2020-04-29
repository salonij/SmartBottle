package com.example.dell.smartbottle;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class Exercise extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercise);
        final String name = getIntent().getStringExtra("name");
        final String mass = getIntent().getStringExtra("mass");
        Bundle b = getIntent().getExtras();
        final double weigh_result = b.getDouble("weigh_result");
        ImageButton lazy =(ImageButton) findViewById(R.id.lazy);
        lazy.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                String period="";
                double result = weigh_result * 0.0296;
                int final_result = (int)Math.ceil(result);
                Intent i = new Intent(Exercise.this,Hydration.class);
                Bundle b = new Bundle();
                b.putInt("final_result",final_result);
                i.putExtras(b);
                i.putExtra("name",name);
                i.putExtra("mass",mass);
                i.putExtra("period",period);
                startActivity(i);
            }
        });
        ImageButton active =(ImageButton) findViewById(R.id.active);
        active.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                Intent i = new Intent(Exercise.this,Duration.class);
                Bundle b = new Bundle();
                b.putDouble("weigh_result",weigh_result);
                i.putExtras(b);
                i.putExtra("name",name);
                i.putExtra("mass",mass);
                startActivity(i);
            }
        });
    }
}

