package com.example.intents;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText et1,et2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et1 = findViewById(R.id.phonenumber);
        et2 = findViewById(R.id.personname);

    }

    /* Implicit Intent*/
    public void openDial(View view) {
        /*Getting Data From Edit Text*/
        String number = et1.getText().toString();

        /*Creating URI*/
        Uri uri = Uri.parse("tel:"+number);

        /*Create Intent*/
        Intent i = new Intent(Intent.ACTION_DIAL,uri);
        startActivity(i);

    }

    /*Explicit Intent*/
    public void next(View view) {

    }
}