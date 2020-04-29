package com.example.dell.smartbottle;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class NameActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_name);
        final EditText name=(EditText) findViewById(R.id.name);
        final Button namebut=(Button)findViewById(R.id.namebut);
        namebut.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                if(name.getText().toString().equals(""))
                {
                    Toast.makeText(NameActivity.this,"Enter name",Toast.LENGTH_SHORT).show();
                }
                else
                {

                    Intent i=new Intent(NameActivity.this, WeightActivity.class);
                    i.putExtra("name",name.getText().toString());
                    startActivity(i);
                }

            }
        });


    }
}

