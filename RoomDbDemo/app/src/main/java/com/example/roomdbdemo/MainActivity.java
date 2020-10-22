package com.example.roomdbdemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.room.Room;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.roomdbdemo.databinding.ActivityMainBinding;
import com.google.android.material.textfield.TextInputEditText;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;
    static StudentDataBase dataBase;
    StudentEntity entity;
    List<StudentEntity> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        dataBase = Room.databaseBuilder(this, StudentDataBase.class, "ap")
                .allowMainThreadQueries().build();
        binding.saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                entity = new StudentEntity();
                String n = binding.etSname.getText().toString();
                String r = binding.rollnumber.getText().toString();
                entity.setName(n);
                entity.setRollnumber(r);
                dataBase.studentDAO().insert(entity);
                Toast.makeText(MainActivity.this, " insert success " + binding.etSname.getText().toString(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}