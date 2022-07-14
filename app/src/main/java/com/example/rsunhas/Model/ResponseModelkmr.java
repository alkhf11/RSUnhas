package com.example.rsunhas.Model;

import java.util.List;

public class ResponseModelkmr {

    private int kode;
    private String pesan;
    private List<DataModelkmr> data;

    public int getKode() {
        return kode;
    }

    public void setKode(int kode) {
        this.kode = kode;
    }

    public String getPesan() {
        return pesan;
    }

    public void setPesan(String pesan) {
        this.pesan = pesan;
    }

    public List<DataModelkmr> getData() {
        return data;
    }

    public void setData(List<DataModelkmr> data) {
        this.data = data;
    }
}

