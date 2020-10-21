package com.example.notificationwithworkmanger;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    NotificationManager nm;
    NotificationCompat.Builder builder;
    public static final int ID = 13134443;
    public static final String CHANNEL_ID = "muni";
PendingIntent pi;
Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        nm = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        createChannel();
        intent=new Intent(this,MainActivity.class);
        pi=PendingIntent.getActivity(this,ID,intent,PendingIntent.FLAG_UPDATE_CURRENT);
    }

    private void createChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel nc = new NotificationChannel(CHANNEL_ID, "apssdc", NotificationManager.IMPORTANCE_HIGH);
            nc.setLightColor(Color.BLUE);
            nc.enableVibration(true);
            nm.createNotificationChannel(nc);
        }
    }

    public void showNotification(View view) {
        builder = new NotificationCompat.Builder(this, CHANNEL_ID);
        builder.setContentTitle("Apssdc Notification");
        builder.setContentText("Hello Don't sit IDEL in these meeting learn something");
        builder.setSmallIcon(R.drawable.ic_baseline_notifications_24);
        builder.setDefaults(Notification.DEFAULT_ALL);
        builder.setContentIntent(pi);
        builder.addAction(R.drawable.ic_baseline_reply_24,"Reply",pi);
        nm.notify(ID, builder.build());
    }
}