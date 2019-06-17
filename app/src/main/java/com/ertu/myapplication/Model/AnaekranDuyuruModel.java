package com.ertu.myapplication.Model;

public class AnaekranDuyuruModel {

    String anabaslik,anatarih;

    public AnaekranDuyuruModel(String anabaslik, String anatarih) {
        this.anabaslik = anabaslik;
        this.anatarih = anatarih;
    }

    public String getAnatarih() {
        return anatarih;
    }

    public void setAnatarih(String anatarih) {
        this.anatarih = anatarih;
    }

    public String getAnabaslik() {
        return anabaslik;
    }

    public void setAnabaslik(String anabaslik) {
        this.anabaslik = anabaslik;
    }


}
