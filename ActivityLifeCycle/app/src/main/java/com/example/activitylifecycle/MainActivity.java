package com.example.activitylifecycle;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv = findViewById(R.id.textview);
        tv.append("onCreate()");
    }

    @Override
    protected void onStart() {
        super.onStart();
        tv.append("onStart()");
    }

    @Override
    protected void onResume() {
        super.onResume();
        tv.append("onResume()");
    }

    @Override
    protected void onPause() {
        super.onPause();
        tv.append("onPause()");
    }

    @Override
    protected void onStop() {
        super.onStop();
        tv.append("onStop()");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        tv.append("onRestart()");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        tv.append("onDestroy()");
    }
}