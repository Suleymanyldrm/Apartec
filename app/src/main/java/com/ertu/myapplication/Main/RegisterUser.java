package com.ertu.myapplication.Main;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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

public class RegisterUser extends AppCompatActivity {

    EditText name, surname, email, tel, daire, blok, arac, dukkan, password;
    Button register;
    String _name, _surname, _tel, _email, _daire, _blok, _arac, _dukkan, _password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_user);

        name = findViewById(R.id.userName);
        surname = findViewById(R.id.userSurname);
        tel = findViewById(R.id.userTelno);
        email = findViewById(R.id.userMail);
        arac = findViewById(R.id.userCar);
        blok = findViewById(R.id.userBlok);
        daire = findViewById(R.id.userCircleno);
        dukkan = findViewById(R.id.userDukkan);
        password = findViewById(R.id.userPassword);
        register = findViewById(R.id.register);

        register.setOnClickListener(new View.OnClickListener() {  // TODO: 29.03.2019 idsi register olan butona tıklanma özelliği verdik.
            @Override
            public void onClick(View v) {

                if (name.getText().toString().trim().equals("") || surname.getText().toString().trim().equals("")
                        || tel.getText().toString().trim().equals("") || email.getText().toString().trim().equals("")
                        || arac.getText().toString().trim().equals("") || blok.getText().toString().trim().equals("")
                        || daire.getText().toString().trim().equals("") || dukkan.getText().toString().trim().equals("")
                        || password.getText().toString().trim().equals("")) {

                    Toast.makeText(getApplicationContext(), "Lütfen Boş Alanları Doldurun", Toast.LENGTH_LONG).show();
                } else {
                    saveDatabase();

                    name.setText("");
                    surname.setText("");
                    tel.setText("");
                    email.setText("");          // TODO: 30.03.2019 Edittextler doluysa boşalt kayıt butonuna tıklandğı zaman
                    daire.setText("");
                    blok.setText("");
                    arac.setText("");
                    dukkan.setText("");
                    password.setText("");
                }

            }
        });
    }

    private void saveDatabase() {

        _name = name.getText().toString().trim();
        _surname = surname.getText().toString().trim();
        _tel = tel.getText().toString().trim();
        _email = email.getText().toString().trim();
        _arac = arac.getText().toString().trim();
        _blok = blok.getText().toString().trim();
        _daire = daire.getText().toString().trim();
        _dukkan = dukkan.getText().toString().trim();
        _password = password.getText().toString().trim();

        String url = "http://suleyman36.dx.am/database/register.php";
        StringRequest stringRequest = new StringRequest(Request.Method.POST, url,
                new Response.Listener<String>() {   // TODO: 29.03.2019 Verileri yolladığımız çalışacak method.
                    @Override
                    public void onResponse(String response) {

                        if (response.equals("Kayıt Başarılı")) {
                            Toast.makeText(getApplicationContext(), response, Toast.LENGTH_LONG).show();
                        } else if (response.equals("Sistemde Böyle Bir Kullanıcı Mevcut")) {
                            Toast.makeText(getApplicationContext(), "Sistemde Böyle Bir Kullanıcı Mevcut", Toast.LENGTH_SHORT).show();
                        }


                    }
                }, new Response.ErrorListener() {     // TODO: 29.03.2019 Veriler yollanmadığı zaman çalışacak method.
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getApplicationContext(), "hata" + error, Toast.LENGTH_LONG).show();
            }
        }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError { // TODO: 29.03.2019 Verilerin yollanması
                HashMap<String, String> deger = new HashMap<>();

                deger.put("ad", _name);                                 // TODO: 29.03.2019 "sütun ismi" , text
                deger.put("soyad", _surname);
                deger.put("tel_no", _tel);
                deger.put("email", _email);
                deger.put("arac", _arac);
                deger.put("blok", _blok);
                deger.put("daire", _daire);                              // TODO: 29.03.2019 "sütun ismi" , text
                deger.put("dukkan", _dukkan);
                deger.put("sifre", _password);

                return deger;
            }
        };
        MySingleton.getInstance(getApplicationContext()).addToRequestQueue(stringRequest);
    }
}




