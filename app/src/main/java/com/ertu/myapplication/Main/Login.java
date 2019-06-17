package com.ertu.myapplication.Main;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
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

import cn.pedant.SweetAlert.SweetAlertDialog;

public class Login extends AppCompatActivity {

    EditText kullanici_adi, kullanici_sifre;
    Button login, kayit;
    String kullaniciadi, kullanicisifre;
    SweetAlertDialog pDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        kullanici_adi = findViewById(R.id.mail);
        kullanici_sifre = findViewById(R.id.password);
        login = findViewById(R.id.giris);
        kayit = findViewById(R.id.kayit);


        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                if (kullanici_adi.getText().toString().trim().equals("") || kullanici_sifre.getText().toString().trim().equals("")) {

                    Toast.makeText(getApplicationContext(), "Lütfen Boş Alanları Doldurun", Toast.LENGTH_SHORT).show();
                } else {

                    girisYap();
                    kullanici_adi.setText("");
                    kullanici_sifre.setText("");

                    pDialog = new SweetAlertDialog(Login.this, SweetAlertDialog.PROGRESS_TYPE);
                    pDialog.getProgressHelper().setBarColor(Color.parseColor("#d63f76"));
                    pDialog.setTitleText("Giriş Yapılıyor");
                    pDialog.show();
                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            try {
                                Thread.sleep(250);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                            pDialog.setCancelable(false);
                        }
                    }).start();

                }

            }
        });

        kayit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), RegisterUser.class);
                startActivity(intent);
            }
        });
    }

    public void girisYap() {

        kullaniciadi = kullanici_adi.getText().toString().trim();
        kullanicisifre = kullanici_sifre.getText().toString().trim();

        String url = "http://suleyman36.dx.am/database/login.php";
        StringRequest stringRequest = new StringRequest(Request.Method.POST, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        if (response.equals("Giriş Başarılı")) {
                            Toast.makeText(getApplicationContext(), "Giriş Başarılı", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(getApplicationContext(), Main2Activity.class);
                            intent.putExtra("email", kullaniciadi); // TODO: 5.04.2019 emaili anahtar olarak kullandık bilgilerimi doldurduk.
                            startActivity(intent);
                        }
                        else {
                            Toast.makeText(getApplicationContext(), "Böyle Bir Kullanıcı Mevcut Değil", Toast.LENGTH_SHORT).show();
                        }
                        
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getApplicationContext(), "İnternet Bağlantınızı Kontrol Ediniz!", Toast.LENGTH_LONG).show();
            }
        }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError { // TODO: 29.03.2019 Verilerin yollanması
                HashMap<String, String> deger = new HashMap<>();

                deger.put("email", kullaniciadi);                                 // TODO: 29.03.2019 "sütun ismi" , text
                deger.put("sifre", kullanicisifre);

                return deger;
            }
        };
        MySingleton.getInstance(getApplicationContext()).addToRequestQueue(stringRequest);

    }
}
