package com.ertu.myapplication.Main;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.ertu.myapplication.Adapter.DuyuruAdapter;
import com.ertu.myapplication.Model.DuyuruModel;
import com.ertu.myapplication.Model.MulkModel;
import com.ertu.myapplication.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class UserDuyuru extends AppCompatActivity {

    List<DuyuruModel> duyuruModels;  // TODO: 7.04.2019 modeldeki verileri list şeklinde çekme.
    DuyuruAdapter duyuruAdapter;
    DuyuruModel duyuruModel;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_duyuru);

        listView = findViewById(R.id.duyurularList);

        String url = "http://suleyman36.dx.am/database/duyuru.php";

        StringRequest stringRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                try {
                    JSONObject jsonObject = new JSONObject(response);
                    JSONArray array = jsonObject.getJSONArray("data");
                    duyuruModels=new ArrayList<>();

                    final int numberOfItemsInResp = array.length();
                    for(int i = 0; i <= numberOfItemsInResp; i++){
                        JSONObject object = array.getJSONObject(i);

                        duyuruModel=new DuyuruModel(object.getString("baslik"),object.getString("icerik"),object.getString("tarih"));
                        duyuruModels.add(duyuruModel);
                        duyuruAdapter=new DuyuruAdapter(duyuruModels,UserDuyuru.this);
                        listView.setAdapter(duyuruAdapter);
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

