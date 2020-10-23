package com.example.roomdbdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class UpdateActivity extends AppCompatActivity {
EditText n,r;
StudentEntity entity;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);
        n=findViewById(R.id.name_s);
        r=findViewById(R.id.rl);
        Intent intent=getIntent();
        String nn=intent.getStringExtra("name");
        String rr=intent.getStringExtra("rol");
        n.setText(nn);
        r.setText(rr);
        r.setKeyListener(null);

    }

    public void updateDetails(View view) {
        String myName=n.getText().toString();
        String myRoll=r.getText().toString();
        entity=new StudentEntity();
        entity.setName(myName);
        entity.setRollnumber(myRoll);
        MainActivity.dataBase.studentDAO().update(entity);
        Toast.makeText(this, myName +" is updated", Toast.LENGTH_SHORT).show();
        Intent intent=new Intent(this,MainActivity.class);
        startActivity(intent);
    }
}