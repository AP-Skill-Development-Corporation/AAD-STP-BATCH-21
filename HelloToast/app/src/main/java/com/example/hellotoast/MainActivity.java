package com.example.hellotoast;


import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    Button b1;
    TextView tv;
    int a = 0;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        b1 = findViewById(R.id.countINC);
        tv = findViewById(R.id.textCount);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Implement Action
                a++;
                tv.setText(""+a);
            }
        });

    }

    public void message(View view) {
        // Apply your own Action
        Toast.makeText(this,"Welcome To Android"
                ,Toast.LENGTH_SHORT).show();
    }


}