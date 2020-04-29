package com.example.dell.smartbottle;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class BottleNumber extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bottle_number);
        EditText litre=(EditText)findViewById(R.id.litre);
        final String drank=litre.getText().toString();
        Button next=(Button)findViewById(R.id.next);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String goal=getIntent().getStringExtra("goal");
                String level=getIntent().getStringExtra("level");
                Intent i=new Intent(BottleNumber.this,Dashboard.class);
                i.putExtra("drank",drank);
                i.putExtra("level",level);
                i.putExtra("goal",goal);
                startActivity(i);
            }
        });
    }
}
