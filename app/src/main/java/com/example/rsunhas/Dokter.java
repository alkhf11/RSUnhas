package com.example.rsunhas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;


public class Dokter extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dokter);
    }

    public void kembali(View view) {
        Intent kembali = new Intent(this, MenuUtama.class);
        startActivity(kembali);
    }
    public void daftarantrian(View view) {
        Intent daftarantrian = new Intent(this, DaftarPoli.class);
        startActivity(daftarantrian);
    }
}