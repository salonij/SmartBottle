package com.example.dell.smartbottle;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Hydration extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hydration);

        Bundle b = getIntent().getExtras();

        TextView tc = (TextView) findViewById(R.id.hydragoal);
        String xyz = Integer.toString(b.getInt("final_result"));
        tc.setText(xyz + " litres");

        TextView tf = (TextView) findViewById(R.id.textViewwww);
        tf.setText(getIntent().getStringExtra("name"));

    }
    public void storeValue(View view)
    {
        Bundle b = getIntent().getExtras();
        String name = getIntent().getStringExtra("name");
        String mass = getIntent().getStringExtra("mass");
        String period = getIntent().getStringExtra("period");
        int final_result = b.getInt("final_result");
        String goal = String.valueOf(final_result);

       /* String method = "register";
        Background background = new Background(this);
        background.execute(method,name,mass,period,goal);
        finish(); */

        Intent intent=new Intent(Hydration.this,MainActivity.class);
        intent.putExtra("goal",goal);
        startActivity(intent);

    }


}

