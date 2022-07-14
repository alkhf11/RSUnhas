package com.example.rsunhas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class DaftarPoli extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daftar_poli);
    }

    public void kembali(View view) {
        Intent kembali = new Intent(this, Dokter.class);
        startActivity(kembali);
    }

    public void poliumum(View view) {
        Intent poliumum = new Intent(this, PoliUmum.class);
        startActivity(poliumum);

    }

    public void poliobgin(View view) {
        Intent poliobgin = new Intent(this, PoliObgin.class);
        startActivity(poliobgin);
    }

    public void politht(View view) {
        Intent politht = new Intent(this, PoliTht.class);
        startActivity(politht);
    }
}