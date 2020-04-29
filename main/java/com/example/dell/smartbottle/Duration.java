package com.example.dell.smartbottle;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Duration extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_duration);
        final String name = getIntent().getStringExtra("name");
        final String mass = getIntent().getStringExtra("mass");
        Bundle b = getIntent().getExtras();
        final double weigh_result = b.getDouble("weigh_result");
        final EditText duration= (EditText)findViewById(R.id.duration);
        final Button durabut = (Button)findViewById(R.id.durabut);
        durabut.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                if(duration.getText().toString().equals(""))
                {
                    Toast.makeText(Duration.this,"Enter duration",Toast.LENGTH_SHORT).show();
                }
                else
                {

                    int dura;
                    dura = 0;
                    int dura_time;
                    dura_time = 0;
                    double dura_time1;
                    try
                    {
                        dura=Integer.parseInt(duration.getText().toString());
                    }catch(Exception e)
                    {
                    }
                    dura_time=((dura/30)*12);
                    dura_time1=(double)dura_time;
                    final double hydra_result= dura_time1+weigh_result;
                    final double result = hydra_result * 0.0296;
                    int final_result = (int) Math.ceil(result);
                    Intent i= new Intent(Duration.this,Hydration.class);
                    Bundle b = new Bundle();
                    b.putInt("final_result",final_result);
                    i.putExtras(b);
                    i.putExtra("name",name);
                    i.putExtra("mass",mass);
                    i.putExtra("period",duration.getText().toString());
                    startActivity(i);
                }
            }
        });
    }
}

