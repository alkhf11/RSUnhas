package com.example.rsunhas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.rsunhas.Tiketantrian.TiketAntrian;

public class MenuAntrian extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_antrian);
    }
    public void kembali(View view) {
        Intent kembali = new Intent(this, Dokter.class);
        startActivity(kembali);
    }
    public void pasienbaru(View view) {
        Intent pasienbaru = new Intent(this, DaftarPoli.class);
        startActivity(pasienbaru);
    }
    public void tiket(View view) {
        Intent tiket = new Intent(this, TiketAntrian.class);
        startActivity(tiket);
    }
}