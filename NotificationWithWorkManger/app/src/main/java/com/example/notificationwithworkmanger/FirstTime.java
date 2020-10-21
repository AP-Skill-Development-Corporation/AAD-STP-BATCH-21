package com.example.notificationwithworkmanger;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.core.app.NotificationCompat;
import androidx.work.Worker;
import androidx.work.WorkerParameters;

import static android.content.Context.NOTIFICATION_SERVICE;

public class FirstTime extends Worker {
    NotificationManager nm;
    NotificationCompat.Builder builder;
    public static final int ID = 13134443;
    public static final String CHANNEL_ID = "muni";
    PendingIntent pi;
    Intent intent;

    public FirstTime(@NonNull Context context, @NonNull WorkerParameters workerParams) {
        super(context, workerParams);
    }

    @NonNull
    @Override
    public Result doWork() {
        nm = (NotificationManager)getApplicationContext(). getSystemService(NOTIFICATION_SERVICE);
        createChannel();
        intent=new Intent(getApplicationContext(),MainActivity.class);
        pi=PendingIntent.getActivity(getApplicationContext(),ID,intent,PendingIntent.FLAG_UPDATE_CURRENT);
        showNotification();
        return Result.success();
    }
    private void createChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel nc = new NotificationChannel(CHANNEL_ID, "apssdc", NotificationManager.IMPORTANCE_HIGH);
            nc.setLightColor(Color.BLUE);
            nc.enableVibration(true);
            nm.createNotificationChannel(nc);
        }

    }
    public void showNotification() {
        builder = new NotificationCompat.Builder(getApplicationContext(), CHANNEL_ID);
        builder.setContentTitle("Apssdc Notification");
        builder.setContentText("Hello Don't sit IDEL in these meeting learn something");
        builder.setSmallIcon(R.drawable.ic_baseline_notifications_24);
        builder.setDefaults(Notification.DEFAULT_ALL);
        builder.setContentIntent(pi);
        builder.addAction(R.drawable.ic_baseline_reply_24,"Reply",pi);
        nm.notify(ID, builder.build());
    }
}
