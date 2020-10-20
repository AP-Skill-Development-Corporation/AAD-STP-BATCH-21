package com.example.covid19reports;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Build;
import android.os.Bundle;
import android.widget.Toast;

import com.example.covid19reports.databinding.ActivityMainBinding;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        EndPointInterface pointInterface = CovidInstance.getInstance().create(EndPointInterface.class);
        Call<String> c = pointInterface.getData();
        c.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                JSONArray root_arry= null;
                try {
                    root_arry = new JSONArray(response.body());
                    JSONObject rootobj=root_arry.getJSONObject(root_arry.length()-1);
                    String recountry=rootobj.getString("Country");
                    String date=rootobj.getString("Date");
                    String active=rootobj.getString("Active");
                    String recovered=rootobj.getString("Recovered");
                    String deaths=rootobj.getString("Deaths");
                    String confirmed=rootobj.getString("Confirmed");
                    binding.date.setText("Date: "+date);
                    binding.country.setText("Country :"+recountry);
                    binding.active.setText("Active :"+active);
                    binding.recovered.setText("Recovered :"+recovered);
                    binding.deaths.setText("Deaths :"+deaths);
                    binding.confirmed.setText("Confirmed :"+confirmed);
                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }


            @Override
            public void onFailure(Call<String> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Failed to load data", Toast.LENGTH_SHORT).show();
            }
        });
        /*c.enqueue(new Callback() {
            @RequiresApi(api = Build.VERSION_CODES.KITKAT)
            @Override
            public void onResponse(Call call, Response response) {
             //   Toast.makeText(MainActivity.this, ""+response.body(), Toast.LENGTH_SHORT).show();

                JSONArray root_arry= null;
                try {
                    root_arry = new JSONArray(response.body());
                   JSONObject rootobj=root_arry.getJSONObject(0);
                    String recountry=rootobj.getString("Country");
                    String date=rootobj.getString("Date");
                    String active=rootobj.getString("Active");
                    String recovered=rootobj.getString("Recovered");
                    String deaths=rootobj.getString("Deaths");
                    String confirmed=rootobj.getString("Confirmed");
                    binding.date.setText("Date: "+date);
                    binding.country.setText("Country "+recountry);
                    binding.active.setText("Active "+active);
                    binding.recovered.setText("Recovered "+recovered);
                    binding.deaths.setText("Deaths "+deaths);
                    binding.confirmed.setText("Confirmed "+confirmed);
                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }

            @Override
            public void onFailure(Call call, Throwable t) {
                Toast.makeText(MainActivity.this, "Failed to load data", Toast.LENGTH_SHORT).show();
            }
        });
    }*/
    }
}