package com.ertu.myapplication.Main;

import android.app.Dialog;
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

import com.ertu.myapplication.R;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    String [] d1 = {"Duyuru 1","Duyuru 2","Duyuru 3","Duyuru 4","Duyuru 5","Duyuru 6"};
    ListView duyurlar_listesi;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        //initUI();
                            // TODO: 22.04.2019 YÖNETİCİ GİRİŞ DASHBORDU

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               Intent intent = new Intent(getApplicationContext(),Login.class);
               startActivity(intent);
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        ArrayAdapter<String> adaptor= new ArrayAdapter<String>
                (MainActivity.this,android.R.layout.simple_list_item_1,android.R.id.text1, d1);

        duyurlar_listesi=findViewById(R.id.odemeler_list);

        if (duyurlar_listesi !=null){
            duyurlar_listesi.setAdapter(adaptor);
            duyurlar_listesi.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int i, long l) {
                    final Dialog dia1 = new Dialog(MainActivity.this);
                    dia1.setContentView(R.layout.notice_edit);
                    dia1.show();
                }
            });
        }
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
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

            Intent intent = new Intent(getApplicationContext(),MainActivity.class);
            startActivity(intent);

        } else if (id == R.id.info) {

            Intent intent = new Intent(getApplicationContext(),Information.class);
            startActivity(intent);

        } else if (id == R.id.users) {

            Intent intent = new Intent(getApplicationContext(), Users.class);
            startActivity(intent);

        } else if (id == R.id.property) {

            Intent intent = new Intent(getApplicationContext(), Propertys.class);
            startActivity(intent);

        } else if (id == R.id.notice) {

            Intent intent = new Intent(getApplicationContext(),Notice.class);
            startActivity(intent);

        }else if (id== R.id.dues){

            Intent intent = new Intent(getApplicationContext(),Dues.class);
            startActivity(intent);

        }else if (id == R.id.guest) {

            Intent intent= new Intent(getApplicationContext(),Guest.class);
            startActivity(intent);

        }else if (id == R.id.complaint) {

            Intent intent = new Intent(getApplicationContext(), Complaint.class);
            startActivity(intent);

        }else if(id == R.id.pay){

            Intent intent = new Intent(getApplicationContext(), Payment.class);
           startActivity(intent);
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
