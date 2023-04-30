package com.example.unite7_veritabani;

import static android.widget.Toast.*;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class Uyg3Activity extends AppCompatActivity {

    SQLiteDatabase database;
    ListView listW;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_uyg3);
        listW = findViewById(R.id.Uyg3ListView);
        database = this.openOrCreateDatabase("Urunler",MODE_PRIVATE,null);
        guncelle();
        listW.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                makeText(Uyg3Activity.this, "Çalıştı", LENGTH_SHORT).show();
                Uyg3Urunler secilenUrun = (Uyg3Urunler) parent.getItemAtPosition(position);
                Intent i = new Intent(Uyg3Activity.this,Uyg3KayitveDuzenleme.class);
                i.putExtra("islem","duzenle");
                i.putExtra("urunadi",secilenUrun.getUrunadi());
                i.putExtra("urunfiyat",secilenUrun.getUrunfiyat());
                i.putExtra("urunadet",secilenUrun.getUrunmiktar());
                startActivity(i);
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        guncelle();
    }

    private void guncelle() {
        ArrayList urunlerList = new ArrayList<>();
        Cursor cs = database.rawQuery("SELECT * FROM db", null);
        if (cs != null && cs.moveToFirst()) {
            do {
                @SuppressLint("Range") Integer urunid = cs.getInt(cs.getColumnIndex("id"));
                @SuppressLint("Range") String urunadi = cs.getString(cs.getColumnIndex("urunadi"));
                @SuppressLint("Range") Double urunfiyati = cs.getDouble(cs.getColumnIndex("fiyati"));
                @SuppressLint("Range") Integer urunmiktari = cs.getInt(cs.getColumnIndex("adet"));
                urunlerList.add(new Uyg3Urunler(urunid,urunadi,urunfiyati,urunmiktari));
            } while (cs.moveToNext());
        }
        cs.close();
        Uyg3ArrayAdapter adapter = new Uyg3ArrayAdapter(urunlerList,this);
        adapter.notifyDataSetChanged();
        listW.setAdapter(adapter);
    }

    public void EkleClick(View view) {
        Intent i = new Intent(Uyg3Activity.this,Uyg3KayitveDuzenleme.class);
        i.putExtra("islem","ekle");
        startActivity(i);
    }
}