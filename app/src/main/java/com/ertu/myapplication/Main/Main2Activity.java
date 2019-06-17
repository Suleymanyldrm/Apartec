package com.ertu.myapplication.Main;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.ertu.myapplication.Adapter.AnaekranDuyuruAdapter;
import com.ertu.myapplication.Model.AnaekranDuyuruModel;
import com.ertu.myapplication.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Main2Activity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    List<AnaekranDuyuruModel> anaduyuruModels;  // TODO: 7.04.2019 modeldeki verileri list şeklinde çekme.
    AnaekranDuyuruAdapter anaduyuruAdapter;
    AnaekranDuyuruModel anaduyuruModel;
    ListView duyurlar_listesi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),Login.class);
                startActivity(intent);
            }
        });

        final DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);


        // TODO: 25.04.2019 duyuruların ana ekranda listelenmesi burdan başlıyor.

        duyurlar_listesi = findViewById(R.id.duyuru_list);

        String url = "http://suleyman36.dx.am/database/duyuru.php";
        // TODO: 5.04.2019 BİLGİLERİM SAYFASINA DATABASEDEN VERİ ÇEKTİK

        StringRequest stringRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                try {
                    JSONObject jsonObject = new JSONObject(response);
                    JSONArray array = jsonObject.getJSONArray("data");
                    anaduyuruModels=new ArrayList<>();

                    final int numberOfItemsInResp = array.length();
                    for(int i = 0; i <= numberOfItemsInResp; i++){
                        JSONObject object = array.getJSONObject(i);

                        anaduyuruModel=new AnaekranDuyuruModel(object.getString("baslik"),object.getString("tarih"));
                        anaduyuruModels.add(anaduyuruModel);
                        anaduyuruAdapter=new AnaekranDuyuruAdapter(anaduyuruModels,Main2Activity.this);
                        duyurlar_listesi.setAdapter(anaduyuruAdapter);
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

        // TODO: 25.04.2019 buraya kadar
    }

    @Override
    public void onBackPressed() {

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.homepage) {

            Intent intent = new Intent(getApplicationContext(),Main2Activity.class);
            startActivity(intent);

        } else if (id == R.id.user_info) {
            Bundle extras = getIntent().getExtras();
            String value = extras.getString("email");
            Intent ıntent=new Intent(getApplicationContext(),UserInformation.class);
            ıntent.putExtra("mail",value);
            startActivity(ıntent);

        } else if (id == R.id.user_property) {
            Bundle extras = getIntent().getExtras();
            String value = extras.getString("email");
            Intent ıntent=new Intent(getApplicationContext(),UserPropertys.class);
            ıntent.putExtra("mail",value);
            startActivity(ıntent);

        } else if (id == R.id.user_notice) {
            startActivity(new Intent(this, UserDuyuru.class));

        }else if (id== R.id.user_dues){
            Bundle extras = getIntent().getExtras();
            String value = extras.getString("email");
            Intent ıntent=new Intent(getApplicationContext(),UserDues.class);
            ıntent.putExtra("mail",value);
            startActivity(ıntent);

        }else if (id == R.id.user_complaint) {
            Bundle extras = getIntent().getExtras();
            String value = extras.getString("email");
            Intent ıntent=new Intent(getApplicationContext(),UserComplaint.class);
            ıntent.putExtra("mail",value);
            startActivity(ıntent);
        }/*else if (id == R.id.user_payment ){

            startActivity(new Intent(this, UserPayment.class));
        }*/
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
