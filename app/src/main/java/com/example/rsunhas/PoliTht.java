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
import com.example.rsunhas.Model.ResponseModel5;
import com.example.rsunhas.Tiketantrian.TiketAntrian;
import com.example.rsunhas.Tiketantrian.TiketAntrianTht;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;
import java.util.Observable;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;


public class PoliTht extends AppCompatActivity {

    Calendar myCalendar;
    DatePickerDialog.OnDateSetListener date;
    DatePickerDialog.OnDateSetListener date2;

    EditText namalengkap5;
    TextView tgllahir5;
    EditText telepon5;
    TextView tglkunjungan5;
    Button btndaftar5;
    TextView norek5;
    private String nama, lahir, notelepon, kunjungan, rekmed;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_poli_tht);

        namalengkap5 = (EditText) findViewById(R.id.namalengkap5);
        tgllahir5 = (EditText) findViewById(R.id.tgllahir5);
        telepon5 = (EditText) findViewById(R.id.telepon5);
        tglkunjungan5 = (EditText) findViewById(R.id.tglkunjungan5);
        btndaftar5 = (Button) findViewById(R.id.btndaftar5);
        norek5 = (TextView) findViewById(R.id.norek5);

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

        tgllahir5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new DatePickerDialog(PoliTht.this, date,
                        myCalendar.get(Calendar.YEAR),
                        myCalendar.get(Calendar.MONTH),
                        myCalendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });
        tglkunjungan5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new DatePickerDialog(PoliTht.this, date2,
                        myCalendar.get(Calendar.YEAR),
                        myCalendar.get(Calendar.MONTH),
                        myCalendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });

        btndaftar5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nama = namalengkap5.getText().toString();
                lahir = tgllahir5.getText().toString();
                notelepon = telepon5.getText().toString();
                kunjungan = tglkunjungan5.getText().toString();
                rekmed = norek5.getText().toString();

                if (nama.trim().equals("")) {
                    namalengkap5.setError("Nama Harus Diisi");
                } else if (nama.trim().equals("")) {
                    tgllahir5.setError("Tanggal Lahir Harus Diisi");
                } else if (nama.trim().equals("")) {
                    tglkunjungan5.setError("Tanggal Kunjungan Harus Diisi");
                } else if (nama.trim().equals("")) {
                    telepon5.setError("Nomor Kontak Harus Diisi");
                } else {
                    createData();
                }
            }


            public void createData() {
                APIRequestData ardTht = RetroServer.konekRetrofit().create(APIRequestData.class);
                retrofit2.Call<ResponseModel5> simpanData = ardTht.ardCreateTht(nama, lahir, notelepon, kunjungan, rekmed);
                simpanData.enqueue(new retrofit2.Callback<ResponseModel5>() {
                    @Override
                    public void onResponse(retrofit2.Call<ResponseModel5> call, retrofit2.Response<ResponseModel5> response) {
                        int kode;
                        kode = response.body().getKode();
                        String pesan = response.body().getPesan();

                        Toast.makeText(PoliTht.this, "Kode : " + kode + "| Pesan : " + pesan, Toast.LENGTH_SHORT).show();
                        finish();

                    }

                    @Override
                    public void onFailure(retrofit2.Call<ResponseModel5> call, Throwable t) {
                        Toast.makeText(PoliTht.this, "Gagal Menghubungi Server | " + t.getMessage(), Toast.LENGTH_SHORT).show();

                    }
                });
            }
        });
    }


    public void kembali(View view) {
        Intent kembali = new Intent(this, DaftarPoli.class);
        startActivity(kembali);

    }

    public void daftar5(View view) {
        Intent daftar5 = new Intent(this, PoliTht.class);
        startActivity(daftar5);
    }

    public void tiket5(View view) {
        Intent tiket5 = new Intent(this, TiketAntrianTht.class);
        startActivity(tiket5);
    }
}