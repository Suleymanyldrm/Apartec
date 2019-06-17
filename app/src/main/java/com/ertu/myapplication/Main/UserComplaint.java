package com.ertu.myapplication.Main;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.ertu.myapplication.Adapter.BekSikayetAdapter;
import com.ertu.myapplication.Adapter.YanSikayetAdapter;
import com.ertu.myapplication.Model.BekSikayetModel;
import com.ertu.myapplication.Model.YanSikayetModel;
import com.ertu.myapplication.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserComplaint extends AppCompatActivity {

    Button sikayetOlustur;
    ListView listView1,listView2;

    List<BekSikayetModel> bekSikayetModels;  // TODO: 7.04.2019 modeldeki verileri list şeklinde çekme.
    BekSikayetAdapter bekSikayetAdapter;
    BekSikayetModel bekSikayetModel;

    List<YanSikayetModel> yanSikayetModels;  // TODO: 7.04.2019 modeldeki verileri list şeklinde çekme.
    YanSikayetAdapter yanSikayetAdapter;
    YanSikayetModel yanSikayetModel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_complaint);

        Bundle extras = getIntent().getExtras();
        final String userMail = extras.getString("mail");

        sikayetOlustur = findViewById(R.id.sikayetolustur);
        sikayetOlustur.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Bundle bundle = new Bundle();
                bundle.putString("email", userMail);

            SikayetGonder sikayetgonder = new SikayetGonder();
            sikayetgonder.setArguments(bundle);
            sikayetgonder.show(getSupportFragmentManager(),"Sikayet Gonder");
            }
        });

        listView1 = findViewById(R.id.beklemedeki_sikayet);
        listView2 = findViewById(R.id.yanitlanan_sikayet);

        beklemedeki_sikayet(listView1);
        yanitlanan_sikayet(listView2);
    }


    public void beklemedeki_sikayet(View view) {

        Bundle extras = getIntent().getExtras();
        final String userMail = extras.getString("mail");
        String url = "http://suleyman36.dx.am/database/beklemedeki_sikayet.php?yazar="+userMail;

        StringRequest stringRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                try {
                    JSONObject jsonObject = new JSONObject(response);
                    JSONArray array = jsonObject.getJSONArray("result");
                    bekSikayetModels=new ArrayList<>();

                    final int numberOfItemsInResp = array.length();
                    for(int i = 0; i <= numberOfItemsInResp; i++){
                        JSONObject object = array.getJSONObject(i);

                        bekSikayetModel=new BekSikayetModel(object.getString("baslik"),object.getString("icerik"));
                        bekSikayetModels.add(bekSikayetModel);
                        bekSikayetAdapter=new BekSikayetAdapter(bekSikayetModels,UserComplaint.this);
                        listView1.setAdapter(bekSikayetAdapter);
                    }


                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });

        MySingleton.getInstance(this).addToRequestQueue(stringRequest);

    }

    public void yanitlanan_sikayet(View view) {

        Bundle extras = getIntent().getExtras();
        final String userMail = extras.getString("mail");
        String url = "http://suleyman36.dx.am/database/yanitlanan_sikayet.php?yazar="+userMail;

        StringRequest stringRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                try {
                    JSONObject jsonObject = new JSONObject(response);
                    JSONArray array = jsonObject.getJSONArray("result");
                    yanSikayetModels=new ArrayList<>();

                    final int numberOfItemsInResp = array.length();
                    for(int i = 0; i <= numberOfItemsInResp; i++){
                        JSONObject object = array.getJSONObject(i);

                        yanSikayetModel=new YanSikayetModel(object.getString("baslik"),object.getString("icerik"), object.getString("cevap"));
                        yanSikayetModels.add(yanSikayetModel);
                        yanSikayetAdapter=new YanSikayetAdapter(yanSikayetModels,UserComplaint.this);
                        listView2.setAdapter(yanSikayetAdapter);
                    }


                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });

        MySingleton.getInstance(this).addToRequestQueue(stringRequest);

    }

}
