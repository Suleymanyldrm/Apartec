package com.ertu.myapplication.Main;

import android.app.Dialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import com.ertu.myapplication.R;

public class DenetleyiciYonetici extends AppCompatActivity {


    String [] yoneticiler = {"Yönetici","Yönetici","Yönetici","Yönetici","Yönetici","Yönetici","Yönetici","Yönetici","Yönetici","Yönetici","Yönetici"};
    ListView yoneticilist;

    String[] userlar = {"Kullanıcı 1", "Kullanıcı 2", "Kullanıcı 3", "Kullanıcı 4", "Kullanıcı 5", "Kullanıcı 6", "Kullanıcı 7", "Kullanıcı 8", "İKullanıcı 9", "Kullanıcı 10"};
    Spinner spinner;

    String[] bloklar = {"Blok-A","Blok-B","Blok-C","Blok-D","Blok-E","Blok-F","Blok-G","Blok-H","Blok-I","Blok-J","Blok-K"};
    Spinner spinner2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_denetleyici_yonetici);

        yoneticilist=findViewById(R.id.yonetici_list);
        ArrayAdapter adap = new ArrayAdapter(this,android.R.layout.simple_list_item_1,android.R.id.text1,yoneticiler);
        yoneticilist.setAdapter(adap);
        yoneticilist.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Dialog dia1 = new Dialog(DenetleyiciYonetici.this);
                dia1.setContentView(R.layout.yonetici_detay);
                dia1.show();
            }
        });

    }
    public void addyonetici(View view){

        Dialog dia2 = new Dialog(DenetleyiciYonetici.this);
        dia2.setContentView(R.layout.add_yonetici);
        dia2.show();

        spinner=dia2.findViewById(R.id.user_spinner);
        ArrayAdapter array = new ArrayAdapter(this,android.R.layout.simple_spinner_item,userlar);
        array.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        
        spinner.setAdapter(array);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(DenetleyiciYonetici.this,userlar[position]+" Seçildi",Toast.LENGTH_LONG).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        spinner2=dia2.findViewById(R.id.spinner_yoneici_blok);
        ArrayAdapter array2 = new ArrayAdapter(this,android.R.layout.simple_spinner_item,bloklar);
        array2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner2.setAdapter(array2);
        spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(DenetleyiciYonetici.this,bloklar[position]+" Seçildi",Toast.LENGTH_LONG).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }

}
