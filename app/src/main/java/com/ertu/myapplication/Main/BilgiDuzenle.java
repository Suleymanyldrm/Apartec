package com.ertu.myapplication.Main;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatDialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.ertu.myapplication.R;

import java.util.HashMap;
import java.util.Map;

// TODO: 5.04.2019 Bilgilerim sayfasında bilgilerimi düzenleye tıklandığı zaman açılacak alertin clası....
public class BilgiDuzenle extends AppCompatDialogFragment {

    EditText ad, soyad, tel, mail, blok, daire, sifre;
    String _name, _surname, _tel, _email, _blok, _daire, _password;
    Context context;
    Activity activity;


    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {


        final AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater layoutInflater = getActivity().getLayoutInflater();
        final View view = layoutInflater.inflate(R.layout.bilgi_duzenle, null);

        builder.setView(view);
        builder.setTitle("BİLGİLERİNİ DÜZENLE");
        builder.setNegativeButton("vazgeç", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        builder.setPositiveButton("kaydet", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                ad = view.findViewById(R.id.d_ad);
                soyad = view.findViewById(R.id.d_soyad);
                tel = view.findViewById(R.id.d_tel);
                mail = view.findViewById(R.id.d_mail);
                blok = view.findViewById(R.id.d_blok);
                daire = view.findViewById(R.id.d_daire);
                sifre = view.findViewById(R.id.d_sifre);

                if (ad.getText().toString().trim().equals("") || soyad.getText().toString().trim().equals("")
                        || tel.getText().toString().trim().equals("") || mail.getText().toString().trim().equals("")
                        || blok.getText().toString().trim().equals("") || daire.getText().toString().trim().equals("")
                        || sifre.getText().toString().trim().equals("")) {

                    Toast.makeText(getActivity(), "Lütfen Boş Alanları Doldurun", Toast.LENGTH_LONG).show();
                } else {

                    guncelle();

                    ad.setText("");
                    soyad.setText("");
                    tel.setText("");
                    mail.setText("");
                    blok.setText("");
                    daire.setText("");
                    sifre.setText("");
                }

            }
        });

        return builder.create();
    }

    public void guncelle() {

        _name = ad.getText().toString().trim();
        _surname = soyad.getText().toString().trim();
        _tel = tel.getText().toString().trim();
        _email = mail.getText().toString().trim();
        _blok = blok.getText().toString().trim();
        _daire = daire.getText().toString().trim();
        _password = sifre.getText().toString().trim();

        String mail = getArguments().getString("email");
        String url = "http://suleyman36.dx.am/database/bilgileri_duzenle.php?email=" + mail;
        StringRequest stringRequest = new StringRequest(Request.Method.POST, url,
                new Response.Listener<String>() {   // TODO: 29.03.2019 Verileri yolladığımız çalışacak method.
                    @Override
                    public void onResponse(String response) {

                        Toast.makeText(getActivity(), response, Toast.LENGTH_LONG).show();

                    }
                }, new Response.ErrorListener() {     // TODO: 29.03.2019 Veriler yollanmadığı zaman çalışacak method.
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getActivity(), "hata" + error, Toast.LENGTH_LONG).show();
            }
        }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError { // TODO: 29.03.2019 Verilerin yollanması
                HashMap<String, String> deger = new HashMap<>();

                deger.put("ad", _name);                                 // TODO: 29.03.2019 "sütun ismi" , text
                deger.put("soyad", _surname);
                deger.put("tel_no", _tel);
                deger.put("email", _email);
                deger.put("blok", _blok);
                deger.put("daire", _daire);                              // TODO: 29.03.2019 "sütun ismi" , text
                deger.put("sifre", _password);

                return deger;
            }
        };

        MySingleton.getInstance(getActivity()).addToRequestQueue(stringRequest);

    }

}
