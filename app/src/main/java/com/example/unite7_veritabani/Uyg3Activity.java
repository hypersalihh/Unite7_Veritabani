package com.example.unite7_veritabani;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;

public class Uyg3Activity extends AppCompatActivity {

    SQLiteDatabase database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_uyg3);
    }

    public void EkleClick(View view) {
        Intent i = new Intent(Uyg3Activity.this,Uyg3KayitveDuzenleme.class);
        i.putExtra("islem","ekle");
        startActivity(i);
    }
}