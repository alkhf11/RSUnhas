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
import com.example.rsunhas.Adapter.AdapterData;
import com.example.rsunhas.MenuUtama;
import com.example.rsunhas.Model.DataModel;
import com.example.rsunhas.Model.ResponseModel;
import com.example.rsunhas.R;

import java.util.ArrayList;
import java.util.List;

public class TiketAntrian extends AppCompatActivity {
    private RecyclerView rvData;
    private RecyclerView.Adapter adData;
    private RecyclerView.LayoutManager lmData;

    private List<DataModel> listData = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tiket_antrian);


        rvData = findViewById(R.id.rv_data);
        lmData = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        rvData.setLayoutManager(lmData);
        retrieveData();

    }

    public void retrieveData() {
        APIRequestData ardData = RetroServer.konekRetrofit().create(APIRequestData.class);
        retrofit2.Call<ResponseModel> tampilData = ardData.ardRetrieveData();
        tampilData.enqueue(new retrofit2.Callback<ResponseModel>() {
            @Override
            public void onResponse(retrofit2.Call<ResponseModel> call, retrofit2.Response<ResponseModel> response) {
                int kode = response.body().getKode();
                String pesan = response.body().getPesan();

                Toast.makeText(TiketAntrian.this, "Kode : " + kode + "| Pesan : " + pesan, Toast.LENGTH_SHORT).show();

                listData = response.body().getData();
                adData = new AdapterData(TiketAntrian.this, listData);
                rvData.setAdapter(adData);
                adData.notifyDataSetChanged();

            }

            @Override
            public void onFailure(retrofit2.Call<ResponseModel> call, Throwable t) {
                Toast.makeText(TiketAntrian.this, "Gagal Terhubung ke Server" + t.getMessage(), Toast.LENGTH_SHORT).show();

            }
        });
    }

    public void kembali(View view) {
        Intent kembali = new Intent(this, MenuUtama.class);
        startActivity(kembali);

    }

}