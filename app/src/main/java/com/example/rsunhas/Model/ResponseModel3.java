package com.example.rsunhas.Model;

import java.util.List;

public class ResponseModel3 {
    private int kode1;
    private String pesan;
    private List<DataModel3> data;

    public int getKode1() {
        return kode1;
    }

    public void setKode1(int kode1) {
        this.kode1 = kode1;
    }

    public String getPesan() {
        return pesan;
    }

    public void setPesan(String pesan) {
        this.pesan = pesan;
    }

    public List<DataModel3> getData() {
        return data;
    }

    public void setData(List<DataModel3> data) {
        this.data = data;
    }
}
