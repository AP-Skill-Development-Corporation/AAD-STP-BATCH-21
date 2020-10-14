package com.example.imagebuttons_eventhandings;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
ImageView imge;
ImageButton imag_button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imge=findViewById(R.id.iv);
        imag_button=findViewById(R.id.iv_btn);
        imge.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imge.setImageResource(R.drawable.image_resourses);
            }
        });
        imag_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imag_button.setImageResource(R.drawable.image_resourses);
            }
        });
    }
}