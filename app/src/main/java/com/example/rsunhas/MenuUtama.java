package com.example.rsunhas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.rsunhas.kamar.Kamar;

public class MenuUtama extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_utama);
    }
    public void kembali(View view) {
        Intent kembali = new Intent(this, MainActivity.class);
        startActivity(kembali);
    }
    public void tentang(View view) {
        Intent tentang = new Intent(this, TentangRS.class);
        startActivity(tentang);
    }
    public void dokter(View view) {
        Intent dokter = new Intent(this, Dokter.class);
        startActivity(dokter);
    }
    public void kamar(View view) {
        Intent kamar = new Intent(this, Kamar.class);
        startActivity(kamar);
    }
}