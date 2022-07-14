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
import com.example.rsunhas.Adapter.AdapterTht;
import com.example.rsunhas.MenuUtama;
import com.example.rsunhas.Model.DataModel5;
import com.example.rsunhas.Model.ResponseModel5;
import com.example.rsunhas.R;

import java.util.ArrayList;
import java.util.List;

public class TiketAntrianTht extends AppCompatActivity {
    private RecyclerView rvTht;
    private RecyclerView.Adapter adTht;
    private RecyclerView.LayoutManager lmTht;

    private List<DataModel5> listData5 = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tiket_antrian_tht);


        rvTht = findViewById(R.id.rv_tht);
        lmTht = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        rvTht.setLayoutManager(lmTht);
        retrieveTht();

    }

    public void retrieveTht() {
        APIRequestData ardTht = RetroServer.konekRetrofit().create(APIRequestData.class);
        retrofit2.Call<ResponseModel5> tampilTht = ardTht.ardRetrieveTht();
        tampilTht.enqueue(new retrofit2.Callback<ResponseModel5>() {
            @Override
            public void onResponse(retrofit2.Call<ResponseModel5> call, retrofit2.Response<ResponseModel5> response) {
                int kode = response.body().getKode();
                String pesan = response.body().getPesan();

                Toast.makeText(TiketAntrianTht.this, "Kode : " + kode + "| Pesan : " + pesan, Toast.LENGTH_SHORT).show();

                listData5 = response.body().getData();
                adTht = new AdapterTht (TiketAntrianTht.this, listData5);
                rvTht.setAdapter(adTht);
                adTht.notifyDataSetChanged();

            }

            @Override
            public void onFailure(retrofit2.Call<ResponseModel5> call, Throwable t) {
                Toast.makeText(TiketAntrianTht.this, "Gagal Terhubung ke Server" + t.getMessage(), Toast.LENGTH_SHORT).show();

            }
        });
    }

    public void kembali(View view) {
        Intent kembali = new Intent(this, MenuUtama.class);
        startActivity(kembali);

    }

}