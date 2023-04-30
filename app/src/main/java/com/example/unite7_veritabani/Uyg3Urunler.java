package com.example.unite7_veritabani;

import android.graphics.Bitmap;

public class Uyg3Urunler {
    public int id;
    public String urunadi;
    public Double urunfiyat;
    public int urunmiktar;
    public Uyg3Urunler(int id, String urunadi, Double urunfiyat, int urunmiktar) {
        this.id = id;
        this.urunadi = urunadi;
        this.urunfiyat = urunfiyat;
        this.urunmiktar = urunmiktar;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUrunadi() {
        return urunadi;
    }

    public void setUrunadi(String urunadi) {
        this.urunadi = urunadi;
    }

    public Double getUrunfiyat() {
        return urunfiyat;
    }

    public void setUrunfiyat(Double urunfiyat) {
        this.urunfiyat = urunfiyat;
    }

    public int getUrunmiktar() {
        return urunmiktar;
    }

    public void setUrunmiktar(int urunmiktar) {
        this.urunmiktar = urunmiktar;
    }
}
