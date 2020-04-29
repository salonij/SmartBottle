package com.example.dell.smartbottle;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.TaskStackBuilder;
/**
 * Created by Dell on 10/5/2017.
 */

public class NotifReceive  extends BroadcastReceiver{
    @Override
    public void onReceive(Context context, Intent intent) {

        NotificationManager notificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        Intent repeat= new Intent(context,Notification.class);
        TaskStackBuilder stackBuilder = TaskStackBuilder.create(context);
        stackBuilder.addParentStack(Notification.class);
        stackBuilder.addNextIntent(repeat);
        PendingIntent pendingIntent =  stackBuilder.getPendingIntent(100,PendingIntent.FLAG_UPDATE_CURRENT);
        NotificationCompat.Builder builder =  new NotificationCompat.Builder(context)
                .setContentIntent(pendingIntent)
                .setSmallIcon(R.mipmap.ic_launcher)
                .setContentTitle("Time to drink water")
                .setContentText("Time to drink water")
                .setAutoCancel(true);
        notificationManager.notify(100,builder.build());

    }
}



