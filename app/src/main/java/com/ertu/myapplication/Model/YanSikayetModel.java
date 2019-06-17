package com.ertu.myapplication.Model;

public class YanSikayetModel {

    String baslik,icerik,cevap;

    public YanSikayetModel(String baslik, String icerik, String cevap) {
        this.baslik = baslik;
        this.icerik = icerik;
        this.cevap = cevap;
    }

    public String getBaslik() {
        return baslik;
    }

    public void setBaslik(String baslik) {
        this.baslik = baslik;
    }

    public String getIcerik() {
        return icerik;
    }

    public void setIcerik(String icerik) {
        this.icerik = icerik;
    }

    public String getCevap() {
        return cevap;
    }

    public void setCevap(String cevap) {
        this.cevap = cevap;
    }
}
