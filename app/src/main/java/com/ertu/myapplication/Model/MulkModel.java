package com.ertu.myapplication.Model;

public class MulkModel {

    String arac,daire,dukkan;

    public String getArac() {
        return arac;
    }

    public void setArac(String arac) {
        this.arac = arac;
    }

    public String getDaire() {
        return daire;
    }

    public void setDaire(String daire) {
        this.daire = daire;
    }

    public String getDukkan() {
        return dukkan;
    }

    public void setDukkan(String dukkan) {
        this.dukkan = dukkan;
    }

    public MulkModel(String arac, String daire, String dukkan) {
        this.arac = arac;
        this.daire = daire;
        this.dukkan = dukkan;
    }
}
