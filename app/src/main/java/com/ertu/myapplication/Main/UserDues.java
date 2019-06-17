package com.ertu.myapplication.Main;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.ertu.myapplication.R;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class UserDues extends AppCompatActivity {

    Button button;
    TextView mesaj;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_dues);

        mesaj = findViewById(R.id.mesaj);

       // button = findViewById(R.id.odemeyap);
        Bundle extras = getIntent().getExtras();
        final String userMail = extras.getString("mail");

       /* button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                Bundle bundle = new Bundle();
                bundle.putString("email", userMail);

                final AlertDialog.Builder builder = new AlertDialog.Builder(UserDues.this);
                builder.setTitle("Aidat");
                builder.setMessage("Ödeme İşleminizi onaylayınız");
                builder.setNegativeButton("Vazgeç",null);
                builder.setPositiveButton("Öde", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        String url = "http://suleyman36.dx.am/database/aidat_odeme.php?email=" + userMail;
                        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                                new Response.Listener<String>() {
                                    @Override
                                    public void onResponse(String response) {

                                            Toast.makeText(getApplicationContext(), response , Toast.LENGTH_SHORT).show();

                                    }
                                }, new Response.ErrorListener() {
                            @Override
                            public void onErrorResponse(VolleyError error) {
                                Toast.makeText(getApplicationContext(), "hata" + error, Toast.LENGTH_LONG).show();
                            }
                        }) {
                            @Override
                            protected Map<String, String> getParams() throws AuthFailureError {
                                return getParams();
                            }
                        };

                        MySingleton.getInstance(getApplicationContext()).addToRequestQueue(stringRequest);
                    }
                });

                builder.show();
            }
        });*/


        String url = "http://suleyman36.dx.am/database/mesaj_cekme.php?email=" + userMail;
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest
                (Request.Method.GET, url, null, new Response.Listener<JSONObject>() {

                    @Override
                    public void onResponse(JSONObject response) {

                         try {
                            mesaj.setText(response.getString("mesaj_1"));
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                         try {
                            mesaj.setText(response.getString("mesaj_2"));
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
