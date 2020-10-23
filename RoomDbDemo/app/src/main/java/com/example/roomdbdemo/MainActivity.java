package com.example.roomdbdemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.room.Room;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.roomdbdemo.databinding.ActivityMainBinding;
import com.google.android.material.textfield.TextInputEditText;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;
    //static StudentDataBase dataBase;
    StudentEntity entity;
    List<StudentEntity> list;
StudentAdapter adapter;
static StudentViewModel viewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
            /*dataBase = Room.databaseBuilder(this, StudentDataBase.class, "ap")
                    .allowMainThreadQueries().build();*/
       viewModel= ViewModelProviders.of(MainActivity.this).get(StudentViewModel.class);
       viewModel.listLiveData().observe(MainActivity.this, new Observer<List<StudentEntity>>() {
           @Override
           public void onChanged(List<StudentEntity> studentEntities) {
               Toast.makeText(MainActivity.this, "Total Records are "+studentEntities.size(), Toast.LENGTH_SHORT).show();
               adapter=new StudentAdapter(MainActivity.this,studentEntities);
               binding.recycler.setLayoutManager(new LinearLayoutManager(MainActivity.this));
               binding.recycler.setAdapter(adapter);
           }
       });
        binding.saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                entity = new StudentEntity();
                String n = binding.etSname.getText().toString();
                String r = binding.rollnumber.getText().toString();
                entity.setName(n);
                entity.setRollnumber(r);
               // dataBase.studentDAO().insert(entity);
                MainActivity.viewModel.insert(entity);
                Toast.makeText(MainActivity.this, " insert success " + binding.etSname.getText().toString(), Toast.LENGTH_SHORT).show();
            }
        });
       /* binding.retriveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                list=dataBase.studentDAO().getdata();
                Toast.makeText(MainActivity.this, "Total Records are "+list.size(), Toast.LENGTH_SHORT).show();
                adapter=new StudentAdapter(MainActivity.this,list);
                binding.recycler.setLayoutManager(new LinearLayoutManager(MainActivity.this));
                binding.recycler.setAdapter(adapter);
            }
        });*/
    }
}