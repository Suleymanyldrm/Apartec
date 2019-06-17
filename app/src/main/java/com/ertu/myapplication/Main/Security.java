package com.ertu.myapplication.Main;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.ertu.myapplication.R;

public class Security extends AppCompatActivity {

    String[] kullanıcılistesi = {"Kullanıcı 1", "Kullanıcı 2", "Kullanıcı 3", "Kullanıcı 4", "Kullanıcı 5", "Kullanıcı 6", "Kullanıcı 7", "Kullanıcı 8", "Kullanıcı 9", "Kullanıcı 10"};
    ListView kullanicilar;

    String[] araclistesi = {"Araç 1", "Araç 2", "Araç 3", "Araç 4", "Araç 5", "Araç 6", "Araç 7", "Araç 8", "Araç 9", "Araç 10", "Araç 11"};
    ListView araclar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_security);

        kullanicilar = findViewById(R.id.user_list);

        ArrayAdapter adap = new ArrayAdapter
                (this, android.R.layout.simple_list_item_1, android.R.id.text1, kullanıcılistesi);
        kullanicilar.setAdapter(adap);
        kullanicilar.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int i, long l) {
                AlertDialog.Builder alert = new AlertDialog.Builder(Security.this);
                alert.setMessage(kullanıcılistesi[i] + " \nDaire Bilgisi,Araç Bilgileri ve İletişim Numarası").setCancelable(false).setPositiveButton("Geri", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
                alert.create().show();
            }
        });
    }

    public void goSecurityGuest(View view) {
        startActivity(new Intent(this, SecurityGuest.class));
    }

    public void goSecurityCarlist(View view) {

        setContentView(R.layout.activity_guest_car);

        araclar = findViewById(R.id.all_car_list);
        ArrayAdapter aray = new ArrayAdapter(this, android.R.layout.simple_list_item_1, android.R.id.text1, araclistesi);
        araclar.setAdapter(aray);
        araclar.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                AlertDialog.Builder alert = new AlertDialog.Builder(Security.this);
                alert.setMessage(araclistesi[position] + "\nPlaka Bilgisi\nAraç Sahibinin İletişim Bilgileri").setCancelable(false).setPositiveButton("Geri", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
                alert.create().show();
            }
        });

    }

    public void backGuest(View view) {

        startActivity(new Intent(this,Security.class));

    }

    public void goSecurityUser(View view) {
        startActivity(new Intent(this, Security.class));
    }
}
