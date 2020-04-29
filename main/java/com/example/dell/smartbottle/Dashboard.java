package com.example.dell.smartbottle;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.NotificationCompat;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class Dashboard extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        final android.support.v4.app.NotificationCompat.Builder builder = new android.support.v4.app.NotificationCompat.Builder(Dashboard.this);
        builder.setAutoCancel(true);
        final int uniqueID=6878;
        Button fetch=(Button)findViewById(R.id.fetch);
        final TextView invi1=(TextView)findViewById(R.id.invi1);
        final TextView invi2=(TextView)findViewById(R.id.invi2);
        final TextView invi3=(TextView)findViewById(R.id.invi3);
        final TextView invi4=(TextView)findViewById(R.id.invi4);
        fetch.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v) {
                String goal = getIntent().getStringExtra("goal");
                String level = getIntent().getStringExtra("level");

                //shared preferences
               /* SharedPreferences pref =getSharedPreferences("def",MODE_PRIVATE);
                SharedPreferences.Editor edit=pref.edit();
                edit.putString("goal",goal);
                edit.putString("level",level);
                Log.i("pref commit",edit.commit()+"");*/

                if (level.equals("0")) {
                    builder.setSmallIcon(R.drawable.emptybottle);
                    builder.setContentTitle("Your bottle is empty");
                    builder.setContentText("Fill the bottle with water fully and start drinking water to stay hydrated");

                    Intent intent = new Intent(Dashboard.this, Dashboard.class);
                    PendingIntent pi = PendingIntent.getActivity(Dashboard.this, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);
                    builder.setContentIntent(pi);

                    NotificationManager nm = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
                    nm.notify(uniqueID, builder.build());

                }

                double goal123 = 0;
                double level123 = 0;

                invi1.setVisibility(View.VISIBLE);
                invi2.setVisibility(View.VISIBLE);
                invi3.setVisibility(View.VISIBLE);
                invi4.setVisibility(View.VISIBLE);
                try {
                    goal123 = Double.parseDouble(goal);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                goal123 = goal123 * 1000;
                try {
                    level123 = Double.parseDouble(level);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                level123 = 100 - level123;
                double xyz = (level123 / 100) * 1000;
                double left = goal123 - xyz;
                String leftfinal = Double.toString(left);
                SharedPreferences pref = getSharedPreferences("def", MODE_PRIVATE);
                SharedPreferences.Editor edit = pref.edit();
                edit.putString("left", leftfinal);

                // edit.putString("level",level);
                double result = (left * 100) / goal123;
                String result123 = Double.toString(result);
                TextView intake = (TextView) findViewById(R.id.llqq);
                intake.setText(String.format("%.2f", result));


                /*SharedPreferences pref = getSharedPreferences("def",MODE_PRIVATE);
                SharedPreferences.Editor edit = pref.edit();
                */

                String ss = pref.getString("left", "");

                if (left > 0) {
                    try {

                        //Create a new PendingIntent and add it to the AlarmManager
                        Intent intent = new Intent(Dashboard.this, RingAlarm.class);
                        //  intent.putExtra("left",String.format("%.2f",result));
                        PendingIntent pendingIntent = PendingIntent.getActivity(Dashboard.this,
                                12345, intent, PendingIntent.FLAG_CANCEL_CURRENT);
                        AlarmManager am =
                                (AlarmManager) getSystemService(Activity.ALARM_SERVICE);
                        am.setRepeating(AlarmManager.ELAPSED_REALTIME, SystemClock.elapsedRealtime(),
                                60* 60 * 60, pendingIntent);

                    } catch (Exception e) {
                    }

                }
            }
        });
    }

}
