package com.example.rsunhas.Tiketantrian;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.rsunhas.API.APIRequestData;
import com.example.rsunhas.API.RetroServer;
import com.example.rsunhas.Adapter.AdapterObgin;
import com.example.rsunhas.MenuUtama;
import com.example.rsunhas.Model.DataModel3;
import com.example.rsunhas.Model.ResponseModel3;
import com.example.rsunhas.R;

import java.util.ArrayList;
import java.util.List;

public class TiketAntrianObgin extends AppCompatActivity {
    private RecyclerView rvObgin;
    private RecyclerView.Adapter adObgin;
    private RecyclerView.LayoutManager lmObgin;

    private List<DataModel3> listData3 = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tiket_antrian_obgin);


        rvObgin = findViewById(R.id.rv_obgin);
        lmObgin = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        rvObgin.setLayoutManager(lmObgin);
        retrieveObgin();

    }

    public void retrieveObgin() {
        APIRequestData ardObgin = RetroServer.konekRetrofit().create(APIRequestData.class);
        retrofit2.Call<ResponseModel3> tampilObgin = ardObgin.ardRetrieveObgin();
        tampilObgin.enqueue(new retrofit2.Callback<ResponseModel3>() {
            @Override
            public void onResponse(retrofit2.Call<ResponseModel3> call, retrofit2.Response<ResponseModel3> response) {
                int kode1 = response.body().getKode1();
                String pesan = response.body().getPesan();

                Toast.makeText(TiketAntrianObgin.this, "Kode : " + kode1 + "| Pesan : " + pesan, Toast.LENGTH_SHORT).show();

                listData3 = response.body().getData();
                adObgin = new AdapterObgin(TiketAntrianObgin.this, listData3);
                rvObgin.setAdapter(adObgin);
                adObgin.notifyDataSetChanged();

            }

            @Override
            public void onFailure(retrofit2.Call<ResponseModel3> call, Throwable t) {
                Toast.makeText(TiketAntrianObgin.this, "Gagal Terhubung ke Server" + t.getMessage(), Toast.LENGTH_SHORT).show();

            }
        });
    }

    public void kembali(View view) {
        Intent kembali = new Intent(this, MenuUtama.class);
        startActivity(kembali);

    }



}