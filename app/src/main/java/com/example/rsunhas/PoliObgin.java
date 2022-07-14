package com.example.rsunhas;

import androidx.annotation.NonNull;
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


import com.example.rsunhas.API.APIRequestData;
import com.example.rsunhas.API.RetroServer;
import com.example.rsunhas.Model.ResponseModel3;
import com.example.rsunhas.Tiketantrian.TiketAntrianObgin;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;



public class PoliObgin extends AppCompatActivity {

    Calendar myCalendar;
    DatePickerDialog.OnDateSetListener date;
    DatePickerDialog.OnDateSetListener date2;

    EditText namalengkap3;
    TextView tgllahir3;
    EditText telepon3;
    TextView tglkunjungan3;
    Button btndaftar3;
    TextView norek3;
    private String nama, lahir, notelepon, kunjungan, rekmed;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_poli_obgin);

        namalengkap3 = (EditText) findViewById(R.id.namalengkap3);
        tgllahir3 = (EditText) findViewById(R.id.tgllahir3);
        telepon3 = (EditText) findViewById(R.id.telepon3);
        tglkunjungan3 = (EditText) findViewById(R.id.tglkunjungan3);
        btndaftar3 = (Button) findViewById(R.id.btndaftar3);
        norek3 = (TextView) findViewById(R.id.norek3);

        myCalendar = Calendar.getInstance();
        date = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear,
                                  int dayOfMonth) {
                myCalendar.set(Calendar.YEAR, year);
                myCalendar.set(Calendar.MONTH, monthOfYear);
                myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);

                TextView tanggal = findViewById(R.id.tgllahir3);
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

                TextView tanggalk = findViewById(R.id.tglkunjungan3);

                String myFormat = "dd-MMMM-yyyy";
                SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);

                tanggalk.setText(sdf.format(myCalendar.getTime()));
            }
        };

        tgllahir3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new DatePickerDialog(PoliObgin.this, date,
                        myCalendar.get(Calendar.YEAR),
                        myCalendar.get(Calendar.MONTH),
                        myCalendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });
        tglkunjungan3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new DatePickerDialog(PoliObgin.this, date2,
                        myCalendar.get(Calendar.YEAR),
                        myCalendar.get(Calendar.MONTH),
                        myCalendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });

        btndaftar3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nama = namalengkap3.getText().toString();
                lahir = tgllahir3.getText().toString();
                notelepon = telepon3.getText().toString();
                kunjungan = tglkunjungan3.getText().toString();
                rekmed = norek3.getText().toString();

                if (nama.trim().equals("")) {
                    namalengkap3.setError("Nama Harus Diisi");
                } else if (nama.trim().equals("")) {
                    tgllahir3.setError("Tanggal Lahir Harus Diisi");
                } else if (nama.trim().equals("")) {
                    tglkunjungan3.setError("Tanggal Kunjungan Harus Diisi");
                } else if (nama.trim().equals("")) {
                    telepon3.setError("Nomor Kontak Harus Diisi");
                } else {
                    createData();
                }
            }


            public void createData() {
                APIRequestData ardObgin = RetroServer.konekRetrofit().create(APIRequestData.class);
                retrofit2.Call<ResponseModel3> simpanObgin = ardObgin.ardCreateObgin(nama, lahir, notelepon, kunjungan, rekmed);
                simpanObgin.enqueue(new retrofit2.Callback<ResponseModel3>() {
                    @Override
                    public void onResponse(@NonNull retrofit2.Call<ResponseModel3> call, @NonNull retrofit2.Response<ResponseModel3> response) {
                        int kode1 = response.body().getKode1();
                        String pesan = response.body().getPesan();

                        Toast.makeText(PoliObgin.this, "Kode : " + kode1 + "| Pesan : " + pesan, Toast.LENGTH_SHORT).show();
                        finish();

                    }

                    @Override
                    public void onFailure(retrofit2.Call<ResponseModel3> call, Throwable t) {
                        Toast.makeText(PoliObgin.this, "Gagal Menghubungi Server | " + t.getMessage(), Toast.LENGTH_SHORT).show();

                    }
                });
            }
        });
    }


    public void kembali(View view) {
        Intent kembali = new Intent(this, DaftarPoli.class);
        startActivity(kembali);

    }

    public void daftar3(View view) {
        Intent daftar3 = new Intent(this, PoliObgin.class);
        startActivity(daftar3);
    }

    public void tiket3(View view) {
        Intent tiket3 = new Intent(this, TiketAntrianObgin.class);
        startActivity(tiket3);
    }
}