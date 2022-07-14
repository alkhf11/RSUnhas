package com.example.rsunhas.kamar;

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
import com.example.rsunhas.Adapter.AdapterKamar;
import com.example.rsunhas.MenuUtama;
import com.example.rsunhas.Model.DataModelkmr;
import com.example.rsunhas.Model.ResponseModel;
import com.example.rsunhas.Model.ResponseModelkmr;
import com.example.rsunhas.R;


import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;

public class Kamar extends AppCompatActivity {
    private RecyclerView rvKamar;
    private RecyclerView.Adapter adKamar;
    private RecyclerView.LayoutManager lmKamar;

    private List<DataModelkmr> listKamar = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kamar);

        rvKamar = findViewById(R.id.rv_kamar);
        lmKamar = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        rvKamar.setLayoutManager(lmKamar);
        retrieveKamar();

    }

    public void retrieveKamar() {
        APIRequestData ardKamar = RetroServer.konekRetrofit().create(APIRequestData.class);
        Call<ResponseModelkmr> tampilDatakmr = ardKamar.ardRetrieveKamar();
        tampilDatakmr.enqueue(new retrofit2.Callback<ResponseModelkmr>() {
            @Override
            public void onResponse(retrofit2.Call<ResponseModelkmr> call, retrofit2.Response<ResponseModelkmr> response) {
                int kode = response.body().getKode();
                String pesan = response.body().getPesan();

                Toast.makeText(Kamar.this, "Kode : " + kode + "| Pesan : " + pesan, Toast.LENGTH_SHORT).show();


                listKamar = response.body().getData();
                adKamar = new AdapterKamar(Kamar.this, listKamar);
                rvKamar.setAdapter(adKamar);
                adKamar.notifyDataSetChanged();

            }

            @Override
            public void onFailure(retrofit2.Call<ResponseModelkmr> call, Throwable t) {
                Toast.makeText(Kamar.this, "Gagal Terhubung ke Server" + t.getMessage(), Toast.LENGTH_SHORT).show();

            }

        });

    }
    public void kembali(View view) {
        Intent kembali = new Intent(this, MenuUtama.class);
        startActivity(kembali);
}
}