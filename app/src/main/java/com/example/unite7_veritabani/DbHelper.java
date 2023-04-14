package com.example.unite7_veritabani;

public class DbHelper {
    public String kadi;
    public String pass;
    public String text;

    public DbHelper(String kadi, String pass) {
        this.kadi = kadi;
        this.pass = pass;
    }

    public DbHelper(String text) {
        this.text = text;
    }

    public DbHelper(String kadi, String pass, String text) {
        this.kadi = kadi;
        this.pass = pass;
        this.text = text;
    }

    private int textFilter() {

        return 12;
    }
}
