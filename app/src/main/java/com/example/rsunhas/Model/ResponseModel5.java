package com.example.rsunhas.Model;

import java.util.List;

public class ResponseModel5 {
    private int kode;
    private String pesan;
    private List<DataModel5> data;

    public int getKode() {
        return kode;
    }

    public void setKode1(int kode5) {
        this.kode = kode5;
    }

    public String getPesan() {
        return pesan;
    }

    public void setPesan(String pesan) {
        this.pesan = pesan;
    }

    public List<DataModel5> getData() {
        return data;
    }

    public void setData(List<DataModel5> data) {
        this.data = data;
    }
}
