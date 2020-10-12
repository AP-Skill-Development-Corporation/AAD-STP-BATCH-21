package com.example.menupickers;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }
    /*Configure Option Menu*/
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        /*inflate menus*/
        getMenuInflater().inflate(R.menu.mymenu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    /*handling Clcick Events*/

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){

            case R.id.settings:
                Toast.makeText(this, item.getTitle(), Toast.LENGTH_SHORT).show();
            break;
            case R.id.call:
                Toast.makeText(this, item.getTitle(), Toast.LENGTH_SHORT).show();
            break;
            case R.id.privacy:
                Toast.makeText(this, item.getTitle(), Toast.LENGTH_SHORT).show();
            break;
        }
        return super.onOptionsItemSelected(item);
    }
}