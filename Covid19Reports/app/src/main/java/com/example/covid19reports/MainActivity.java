package com.example.covid19reports;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.widget.CompoundButton;
import android.widget.Toast;

import com.example.covid19reports.databinding.ActivityMainBinding;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.Locale;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
ActivityMainBinding binding;
    private SharedPreferences preferences;
    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR1)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setAppLocale("te");
        setLocale("te");
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        EndPointInterface pointInterface = CovidInstance.getInstance().create(EndPointInterface.class);
        preferences=getSharedPreferences("PREF_NAME", Context.MODE_PRIVATE);
        binding.tg.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR1)
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    /*SharedPreferences.Editor editor=preferences.edit();
                    editor.putString("LANG","te");
                    editor.apply();*/
                    setLocale("te");
                }else {
                   /* SharedPreferences.Editor editor=preferences.edit();
                    editor.putString("LANG","en");
                    editor.apply();*/
                    setLocale("en");

                }
            }
        });

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
                   /* binding.date.setText(R.string.date+"\t"+date);
                    binding.country.setText(R.string.country+"\t"+recountry);
                    binding.active.setText(R.string.active+"\t"+active);
                    binding.recovered.setText(R.string.recovered+"\t"+recovered);
                    binding.deaths.setText(R.string.deaths+"\t"+deaths);
                    binding.confirmed.setText(R.string.confirmed+"\t"+confirmed);*/
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
    public void setLocale(String lang) {
        Locale myLocale = new Locale(lang);
        Resources res = getResources();
        DisplayMetrics dm = res.getDisplayMetrics();
        Configuration conf = res.getConfiguration();
        conf.locale = myLocale;
        res.updateConfiguration(conf, dm);

    }
    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR1)
    private void setAppLocale(String localeCode){
        Resources resources = getResources();
        DisplayMetrics displayMetrics = resources.getDisplayMetrics();
        Configuration configuration = resources.getConfiguration();
        configuration.setLocale(new Locale(localeCode.toLowerCase()));
        resources.updateConfiguration(configuration, displayMetrics);
        configuration.locale = new Locale(localeCode.toLowerCase());
        resources.updateConfiguration(configuration, displayMetrics);
    }
}