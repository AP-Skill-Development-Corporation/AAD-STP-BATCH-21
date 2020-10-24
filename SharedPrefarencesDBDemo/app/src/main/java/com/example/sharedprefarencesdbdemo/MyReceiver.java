package com.example.sharedprefarencesdbdemo;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class MyReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        // TODO: This method is called when the BroadcastReceiver is receiving
        // an Intent broadcast.
        //throw new UnsupportedOperationException("Not yet implemented");
        String action=intent.getAction();
        switch (action){
            case Intent.ACTION_POWER_CONNECTED:
                Toast.makeText(context, "boss your mobile is charginG", Toast.LENGTH_SHORT).show();
                break;
            case Intent.ACTION_POWER_DISCONNECTED:
                Toast.makeText(context, "boss your mobile is not charginG", Toast.LENGTH_SHORT).show();
                break;
            case Intent.ACTION_AIRPLANE_MODE_CHANGED:
                Toast.makeText(context, "boss now your flyinG without signals", Toast.LENGTH_SHORT).show();
                break;

        }
    }
}
