package com.ertu.myapplication.Model;

public class DuyuruModel {

    String baslik, icerik, tarih;

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

    public String getTarih() {
        return tarih;
    }

    public void setTarih(String tarih) {
        this.tarih = tarih;
    }


    public DuyuruModel(String baslik, String icerik,String tarih) {
        this.baslik = baslik;
        this.icerik = icerik;
        this.tarih = tarih;

    }
}
