package com.ertu.myapplication.Main;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.ertu.myapplication.R;

import org.json.JSONException;
import org.json.JSONObject;

public class UserInformation extends AppCompatActivity {

    TextView ad, soyad, tel, mail, blok, daire, sifre;
    Button duzenle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_information);

        ad = findViewById(R.id.ad);
        soyad = findViewById(R.id.soyad);
        tel = findViewById(R.id.tel);
        mail = findViewById(R.id.mail);
        blok = findViewById(R.id.blok);
        daire = findViewById(R.id.daire);
        sifre = findViewById(R.id.sifre);
        duzenle = findViewById(R.id.duzenle);
        Bundle extras = getIntent().getExtras();
        final String userMail = extras.getString("mail");

        duzenle.setOnClickListener(new View.OnClickListener() {  // TODO: 5.04.2019 Bilgileri düzenle butonuna işlev verdik..
            @Override
            public void onClick(View v) {

                Bundle bundle = new Bundle();
                bundle.putString("email", userMail);
                BilgiDuzenle bilgiDuzenle = new BilgiDuzenle();
                bilgiDuzenle.setArguments(bundle);
                bilgiDuzenle.show(getSupportFragmentManager(), "Bilgi Düzenle");

            }
        });


        String url = "http://suleyman36.dx.am/database/bilgilerim.php?email=" + userMail;
        // TODO: 5.04.2019 BİLGİLERİM SAYFASINA DATABASEDEN VERİ ÇEKTİK
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest
                (Request.Method.GET, url, null, new Response.Listener<JSONObject>() {

                    @Override
                    public void onResponse(JSONObject response) {

                        try {
                            ad.setText(response.getString("ad"));
                            soyad.setText(response.getString("soyad"));
                            tel.setText(response.getString("tel_no"));
                            mail.setText(response.getString("email"));
                            blok.setText(response.getString("blok"));
                            daire.setText(response.getString("daire"));
                            sifre.setText(response.getString("sifre"));
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }
                }, new Response.ErrorListener() {

                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(getApplicationContext(), "hata" + error, Toast.LENGTH_SHORT).show();

                    }
                });

        MySingleton.getInstance(this).addToRequestQueue(jsonObjectRequest);
    }
}


