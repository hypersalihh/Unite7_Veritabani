package com.example.unite7_veritabani;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.DownloadManager;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Uyg3KayitveDuzenleme extends AppCompatActivity {
    EditText urunAdi, urunFiyati, urunAdedi;
    public boolean islem = false;
    SQLiteDatabase database;
    private void init() {
        urunAdi = findViewById(R.id.urunAdiTxt);
        urunFiyati = findViewById(R.id.urunFiyatiTxt);
        urunAdedi = findViewById(R.id.urunAdediTxt);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_uyg3_kayitve_duzenleme);
        init();
        database = this.openOrCreateDatabase("Urunler",MODE_PRIVATE,null);
        Intent i = getIntent();
        String islems = i.getStringExtra("islem");
        if (islems.equals("duzenle")) {
            islem = true;
            String urunadi = i.getStringExtra("urunadi");
            Double urunfiyati = i.getDoubleExtra("urunfiyat",0);
            Integer urunadeti = i.getIntExtra("urunadet",0);
            urunAdi.setText(urunadi);
            urunFiyati.setText(urunfiyati.toString());
            urunAdedi.setText(urunadeti.toString());
            urunAdi.setEnabled(false);
        }
        else islem = false;
    }

    public void btnBack(View view) {
        Intent i = new Intent(Uyg3KayitveDuzenleme.this,Uyg3Activity.class);
        startActivity(i);
    }

    public void KaydetIslem(View view) {
        String Uadi = urunAdi.getText().toString();
        Double Ufiyat = Double.parseDouble(urunFiyati.getText().toString());
        Integer Uadet = Integer.parseInt(urunAdedi.getText().toString());
        if (!islem) {
            try {
                Cursor cs = database.rawQuery("SELECT * FROM db", null);
                if (cs != null && cs.moveToFirst()) {
                    do {
                        @SuppressLint("Range") String urunadi = cs.getString(cs.getColumnIndex("urunadi"));
                        if (urunadi.equals(Uadi)) {
                            Toast.makeText(this, "Bu ürün adı zaten kullanılıyor.", Toast.LENGTH_SHORT).show();
                            return;
                        }
                    } while (cs.moveToNext());
                }
                cs.close();
                SQLiteStatement statement = database.compileStatement("INSERT INTO db (urunadi, fiyati, adet) VALUES (?,?,?)");
                statement.bindString(1, Uadi);
                statement.bindDouble(2, Ufiyat);
                statement.bindLong(3, Uadet);
                statement.execute();
                Toast.makeText(this, "Başarıyla Ürün eklendi!", Toast.LENGTH_SHORT).show();
            } catch (Exception e) {
                Toast.makeText(this, "Hata oluştu. Hata Kodu: " + e, Toast.LENGTH_SHORT).show();
                Log.e("Error","Error Code: " + e);
            }
        }
        else {
            try {
                SQLiteStatement statement = database.compileStatement("UPDATE db SET fiyati = ?, adet = ? WHERE urunadi = ?");
                statement.bindDouble(1,Ufiyat);
                statement.bindLong(2,Uadet);
                statement.bindString(3,Uadi);
                statement.execute();
                Toast.makeText(this, "Başarıyla " + Uadi + " isimli ürün güncellendi.", Toast.LENGTH_LONG).show();
            }
            catch (Exception e) {
                Toast.makeText(this, "Hata oluştu. Hata Kodu: " + e, Toast.LENGTH_SHORT).show();
            }
        }
    }
}