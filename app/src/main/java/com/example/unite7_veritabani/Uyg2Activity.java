package com.example.unite7_veritabani;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.Layout;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class Uyg2Activity extends AppCompatActivity {

    RadioButton rdOpenTheme, rdDarkTheme;
    private void init() {
        rdOpenTheme = findViewById(R.id.Uyg2AcikRd);
        rdDarkTheme = findViewById(R.id.Uyg2KapaliRd);
    }
    public void degistir(String kim) {
        if (kim == "acik")
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_uyg2);
        init();
        SharedPreferences sharedPreferences = this.getPreferences(Context.MODE_PRIVATE);
        boolean data = sharedPreferences.getBoolean("theme",false);
        if(data) { rdDarkTheme.setChecked(true); AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES); }
        else { rdOpenTheme.setChecked(true); AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO); }
        RadioGroup radioGroup = (RadioGroup) findViewById(R.id.RadioGroup);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
        {

            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if(checkedId == 2131230738) {
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
                    SharedPreferences sharedPreferences1 = this.
                    degistir
                }
                else {

                }
            }
        });
    }

    /* AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
                SharedPreferences data3 = this.getPreferences(Context.MODE_PRIVATE);
                SharedPreferences.Editor edit2 = data3.edit();
                edit2.putBoolean("theme",true); edit2.apply();*/
}