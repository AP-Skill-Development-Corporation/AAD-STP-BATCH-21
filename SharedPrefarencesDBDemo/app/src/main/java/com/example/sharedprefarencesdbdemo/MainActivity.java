package com.example.sharedprefarencesdbdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
EditText name,pass;
SharedPreferences sp;
SharedPreferences.Editor editor;
    String myname;
    String mypass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        name=findViewById(R.id.et_name);
        pass=findViewById(R.id.et_password);
        sp=getSharedPreferences("muni",MODE_PRIVATE);
    }

    public void showData(View view) {
         myname=name.getText().toString();
         mypass=pass.getText().toString();
         editor=sp.edit();
         editor.putString("username",myname);
         editor.putString("password",mypass);
         editor.apply();
        Toast.makeText(this, ""+myname+"\n"+mypass, Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onPause() {
        super.onPause();
        editor=sp.edit();
        editor.putString("username",myname);
        editor.putString("password",mypass);
        editor.apply();
    }

    @Override
    protected void onResume() {
        super.onResume();
        String n=sp.getString("username","");
        String p=sp.getString("password","");
        name.setText(n);
        pass.setText(p);
    }
}