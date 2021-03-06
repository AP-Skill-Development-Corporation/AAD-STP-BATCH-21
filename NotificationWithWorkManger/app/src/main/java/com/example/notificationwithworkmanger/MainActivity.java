package com.example.notificationwithworkmanger;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.work.OneTimeWorkRequest;
import androidx.work.PeriodicWorkRequest;
import androidx.work.WorkManager;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.View;

import java.util.concurrent.TimeUnit;

public class MainActivity extends AppCompatActivity {
   /* NotificationManager nm;
    NotificationCompat.Builder builder;
    public static final int ID = 13134443;
    public static final String CHANNEL_ID = "muni";
PendingIntent pi;
Intent intent;*/
   OneTimeWorkRequest onetime;
   PeriodicWorkRequest secondtime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        onetime=new OneTimeWorkRequest.Builder(FirstTime.class).build();
        secondtime=new PeriodicWorkRequest.Builder(SecondTime.class,15, TimeUnit.MINUTES).build();
        /*nm = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        createChannel();
        intent=new Intent(this,MainActivity.class);
        pi=PendingIntent.getActivity(this,ID,intent,PendingIntent.FLAG_UPDATE_CURRENT);*/
    }

    /*private void createChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel nc = new NotificationChannel(CHANNEL_ID, "apssdc", NotificationManager.IMPORTANCE_HIGH);
            nc.setLightColor(Color.BLUE);
            nc.enableVibration(true);
            nm.createNotificationChannel(nc);
        }
    }*/

    public void showNotification(View view) {
        WorkManager.getInstance(this).enqueue(onetime);
        WorkManager.getInstance(this).enqueue(secondtime);
       /* builder = new NotificationCompat.Builder(this, CHANNEL_ID);
        builder.setContentTitle("Apssdc Notification");
        builder.setContentText("Hello Don't sit IDEL in these meeting learn something");
        builder.setSmallIcon(R.drawable.ic_baseline_notifications_24);
        builder.setDefaults(Notification.DEFAULT_ALL);
        builder.setContentIntent(pi);
        builder.addAction(R.drawable.ic_baseline_reply_24,"Reply",pi);
        nm.notify(ID, builder.build());*/
    }
}