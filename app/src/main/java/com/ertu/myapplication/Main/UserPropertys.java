package com.ertu.myapplication.Main;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.ertu.myapplication.Adapter.MulkAdapter;
import com.ertu.myapplication.Model.MulkModel;
import com.ertu.myapplication.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class UserPropertys extends AppCompatActivity {

    // TODO: 7.04.2019 MÜLKLERİ VERİTABANINDAN ÇEKİP GÖSTERME..

    List<MulkModel> mulkModels;  // TODO: 7.04.2019 modeldeki verileri list şeklinde çekme.
    MulkAdapter mulkAdapter;
    MulkModel mulkModel;
    ListView listView;
    Button mulkduzenle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_propertys);

        mulkduzenle = findViewById(R.id.mulkduzenle);
        Bundle extras = getIntent().getExtras();
        final String userMail = extras.getString("mail");

        mulkduzenle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Bundle bundle=new Bundle();
                bundle.putString("email",userMail);
                MulkDuzenle mulkDuzenle = new MulkDuzenle();
                mulkDuzenle.setArguments(bundle);
                mulkDuzenle.show(getSupportFragmentManager(),"Mülk Düzenle");

            }
        });


        listView = findViewById(R.id.userMulklist);

        String url = "http://suleyman36.dx.am/database/mulklerim.php?email="+userMail;
        // TODO: 5.04.2019 BİLGİLERİM SAYFASINA DATABASEDEN VERİ ÇEKTİK

        StringRequest stringRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                try {
                    JSONObject jsonObject = new JSONObject(response);
                    JSONArray array = jsonObject.getJSONArray("result");
                    mulkModels=new ArrayList<>();
                    for(int i = 0; i <= array.length(); i++){
                        JSONObject object = array.getJSONObject(i);

                        mulkModel=new MulkModel(object.getString("arac"),object.getString("daire"),object.getString("dukkan"));
                        mulkModels.add(mulkModel);
                        mulkAdapter=new MulkAdapter(mulkModels,getApplicationContext());
                        listView.setAdapter(mulkAdapter);
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
