package com.ertu.myapplication.Main;

import android.app.Dialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.ertu.myapplication.R;

public class Information extends AppCompatActivity {

    String [] carlist={"Arac 1","Arac 2"};
    ListView carList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_information);
        carList=findViewById(R.id.userCarList);

        ArrayAdapter<String> veriAdaptoru = new ArrayAdapter<String>
                (this,android.R.layout.simple_list_item_1,android.R.id.text1,carlist);

        carList.setAdapter(veriAdaptoru);
        carList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int i, long l) {
                final Dialog userdetay = new Dialog(Information.this);
                userdetay.setContentView(R.layout.car_detay);
                userdetay.show();
            }
        });
    }
}
