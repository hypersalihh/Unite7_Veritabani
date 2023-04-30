package com.example.unite7_veritabani;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    SQLiteDatabase database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        createDB();
        //insertDB();
        //updateDB();
    }

    private void createDB() {
        database = this.openOrCreateDatabase("Urunler",MODE_PRIVATE,null);
        database.execSQL("CREATE TABLE IF NOT EXISTS db (id INTEGER PRIMARY KEY, urunadi TEXT, fiyati DOUBLE, adet INTEGER)");
        System.out.println("geliyor.");
    }

    private void insertDB() {
        SQLiteStatement results = database.compileStatement("INSERT INTO db (urunadi,fiyati,adet) VALUES (?,?,?)");
        results.bindString(1,"Ahmetne ekliyim");
        results.bindDouble(2,1.5);
        results.bindLong(3,1);
        results.execute();
    }

    private void updateDB() {
        SQLiteStatement results = database.compileStatement("UPDATE db SET urunadi = ?, fiyati = ?, adet = ? WHERE id = ?");
        results.bindString(1,"Ahmeth");
        results.bindDouble(2,12.5);
        results.bindLong(3,5);
        results.bindLong(4,1);

    }

    public void Uygulama10Click(View view) {
        Intent tp = new Intent(MainActivity.this,Uyg10Activity.class);
        startActivity(tp);
    }

    public void Uygulama11Click(View view) {
        Intent tp = new Intent(MainActivity.this,Uyg11Activity.class);
        startActivity(tp);
    }

    public void Uygulama8Click(View view) {
        Intent tp = new Intent(MainActivity.this,Uyg8Activity.class);
        startActivity(tp);
    }

    public void Uygulama3Click(View view) {
        Intent tp = new Intent(MainActivity.this,Uyg3Activity.class);
        startActivity(tp);
    }

    public void Uygulama4Click(View view) {
        Intent tp = new Intent(MainActivity.this,Uyg4Activity.class);
        startActivity(tp);
    }

    public void Uygulama2Click(View view) {
        Intent tp = new Intent(MainActivity.this,Uyg2Activity.class);
        startActivity(tp);
    }

    public void SiraSizde(View view) {
        Intent tp = new Intent(MainActivity.this,SiraSizde.class);
        startActivity(tp);
    }

    public void Uygulama6Click(View view) {
        Intent tp = new Intent(MainActivity.this,Uyg6Activity.class);
        startActivity(tp);
    }

    public void Uygulama7Click(View view) {
        Intent tp = new Intent(MainActivity.this,Uyg7Activity.class);
        startActivity(tp);
    }

    public void Uygulama5Click(View view) {
        Intent tp = new Intent(MainActivity.this,Uyg5Activity.class);
        startActivity(tp);
    }

    public void Uygulama9Click(View view) {
        Intent tp = new Intent(MainActivity.this,Uyg9Activity.class);
        startActivity(tp);
    }

    public void Uygulama12Click(View view) {
        Intent tp = new Intent(MainActivity.this,Uyg12Activity.class);
        startActivity(tp);
    }

    public void Uygulama13Click(View view) {
        Intent tp = new Intent(MainActivity.this,Uyg13Activity.class);
        startActivity(tp);
    }

    public void Uygulama1Click(View view) {
        Intent tp = new Intent(MainActivity.this,Uyg1Activity.class);
        startActivity(tp);
    }
}