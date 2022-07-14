package com.example.rsunhas;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.toolbox.StringRequest;
import com.example.rsunhas.API.APIRequestData;
import com.example.rsunhas.API.RetroServer;
import com.example.rsunhas.Model.ResponseModel;
import com.example.rsunhas.Model.ResponseModel2;
import com.example.rsunhas.Tiketantrian.TiketAntrian;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;
import java.util.Observable;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;


public class PoliUmum extends AppCompatActivity {

    Calendar myCalendar;
    DatePickerDialog.OnDateSetListener date;
    DatePickerDialog.OnDateSetListener date2;

    EditText namalengkap;
    TextView tgllahir;
    EditText telepon;
    TextView tglkunjungan;
    Button btndaftar;
    TextView norek;
    private String nama, lahir, notelepon, kunjungan, rekmed;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_poli_umum);

        namalengkap = (EditText) findViewById(R.id.namalengkap);
        tgllahir = (EditText) findViewById(R.id.tgllahir);
        telepon = (EditText) findViewById(R.id.telepon);
        tglkunjungan = (EditText) findViewById(R.id.tglkunjungan);
        btndaftar = (Button) findViewById(R.id.btndaftar);
        norek = (TextView) findViewById(R.id.norek);

        myCalendar = Calendar.getInstance();
        date = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear,
                                  int dayOfMonth) {
                myCalendar.set(Calendar.YEAR, year);
                myCalendar.set(Calendar.MONTH, monthOfYear);
                myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);

                TextView tanggal = findViewById(R.id.tgllahir);
                String myFormat = "dd-MMMM-yyyy";
                SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);
                tanggal.setText(sdf.format(myCalendar.getTime()));

            }
        };
        date2 = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear,
                                  int dayOfMonth) {
                myCalendar.set(Calendar.YEAR, year);
                myCalendar.set(Calendar.MONTH, monthOfYear);
                myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);

                TextView tanggalk = findViewById(R.id.tglkunjungan);

                String myFormat = "dd-MMMM-yyyy";
                SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);

                tanggalk.setText(sdf.format(myCalendar.getTime()));
            }
        };

        tgllahir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new DatePickerDialog(PoliUmum.this, date,
                        myCalendar.get(Calendar.YEAR),
                        myCalendar.get(Calendar.MONTH),
                        myCalendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });
        tglkunjungan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new DatePickerDialog(PoliUmum.this, date2,
                        myCalendar.get(Calendar.YEAR),
                        myCalendar.get(Calendar.MONTH),
                        myCalendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });

        btndaftar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nama = namalengkap.getText().toString();
                lahir = tgllahir.getText().toString();
                notelepon = telepon.getText().toString();
                kunjungan = tglkunjungan.getText().toString();
                rekmed = norek.getText().toString();

                if (nama.trim().equals("")) {
                    namalengkap.setError("Nama Harus Diisi");
                } else if (nama.trim().equals("")) {
                    tgllahir.setError("Tanggal Lahir Harus Diisi");
                } else if (nama.trim().equals("")) {
                    tglkunjungan.setError("Tanggal Kunjungan Harus Diisi");
                } else if (nama.trim().equals("")) {
                    telepon.setError("Nomor Kontak Harus Diisi");
                } else {
                    createData();
                }
            }


            public void createData() {
                APIRequestData ardData = RetroServer.konekRetrofit().create(APIRequestData.class);
                retrofit2.Call<ResponseModel2> simpanData = ardData.ardCreateData(nama, lahir, notelepon, kunjungan, rekmed);
                simpanData.enqueue(new retrofit2.Callback<ResponseModel2>() {
                    @Override
                    public void onResponse(retrofit2.Call<ResponseModel2> call, retrofit2.Response<ResponseModel2> response) {
                        int kode;
                        kode = response.body().getKode();
                        String pesan = response.body().getPesan();

                        Toast.makeText(PoliUmum.this, "Kode : " + kode + "| Pesan : " + pesan, Toast.LENGTH_SHORT).show();
                        finish();

                    }

                    @Override
                    public void onFailure(retrofit2.Call<ResponseModel2> call, Throwable t) {
                        Toast.makeText(PoliUmum.this, "Gagal Menghubungi Server | " + t.getMessage(), Toast.LENGTH_SHORT).show();

                    }
                });
            }
        });
    }


    public void kembali(View view) {
        Intent kembali = new Intent(this, DaftarPoli.class);
        startActivity(kembali);

    }

    public void daftar(View view) {
        Intent daftar = new Intent(this, PoliObgin.class);
        startActivity(daftar);
    }

    public void tiket(View view) {
        Intent tiket = new Intent(this, TiketAntrian.class);
        startActivity(tiket);
    }
}