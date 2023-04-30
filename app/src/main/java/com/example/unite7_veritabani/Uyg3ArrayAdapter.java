package com.example.unite7_veritabani;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Uyg3ArrayAdapter extends BaseAdapter {
    ArrayList<Uyg3Urunler> liste;
    Context context;
    public Uyg3ArrayAdapter(ArrayList<Uyg3Urunler> liste, Context context) {
        this.liste = liste;
        this.context = context;
    }
    @Override
    public int getCount() {
        return liste.size();
    }
    @Override
    public Object getItem(int i) {
        return liste.get(i);
    }
    @Override
    public long getItemId(int i) {
        return i;
    }
    @Override
    public View getView(int i, View view, ViewGroup parent) {
        TextView Uadi, Ufiyat, Uadet;
        Uyg3Urunler urun = liste.get(i);
        if(view == null){
            view = LayoutInflater.from(context).inflate(R.layout.activity_uyg3listview,parent,false);
        }
        Uadi = view.findViewById(R.id.urunAdi);
        Ufiyat = view.findViewById(R.id.urunFiyati);
        Uadet = view.findViewById(R.id.urunAdedi);
        Uadi.setText(urun.getUrunadi());
        Ufiyat.setText(String.format("%.02f",urun.getUrunfiyat()) + " TL");
        Uadet.setText(urun.getUrunmiktar() + "");
        return view;
    }
}
