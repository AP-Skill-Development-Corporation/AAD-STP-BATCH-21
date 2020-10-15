package com.example.userregistrationform;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;
import android.view.View;

import com.example.userregistrationform.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
ActivityMainBinding binding;
String gender,laung;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= DataBindingUtil.setContentView(this,R.layout.activity_main);
        binding.submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (binding.male.isChecked()){
                    gender="Male";
                }else {
                    gender="Female";
                }
                if (binding.cLang.isChecked()){
                    laung="C-Lang";
                }else if (binding.python.isChecked()){
                    laung="python";
                }
                else if (binding.java.isChecked()){
                    laung=laung+"Java";
                }

                binding.tvResult.setText(binding.etUsername.getText().toString()+"\n"+
                        binding.etEmail.getText().toString()+"\n"+
                        binding.etMobile.getText().toString()+"\n"+
                        binding.spinQulification.getSelectedItem().toString()+"\n"+
                       gender+"\n"+laung );
            }
        });
    }
}