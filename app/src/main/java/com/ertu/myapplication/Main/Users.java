package com.ertu.myapplication.Main;

import android.app.Dialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import com.ertu.myapplication.R;

public class Users extends AppCompatActivity {

    String[] user = {"Kullanıcı 1", "Kullanıcı 2", "Kullanıcı 3", "Kullanıcı 4", "Kullanıcı 5", "Kullanıcı 6", "Kullanıcı 7", "Kullanıcı 8", "İKullanıcı 9", "Kullanıcı 10"};
    ListView listView;

    String [] blok= {"Blok","Blok","Blok","Blok","Blok","Blok","Blok","Blok","Blok","Blok"};
    Spinner user_create_blok;

    String [] daire = {"Daire","Daire","Daire","Daire","Daire","Daire","Daire","Daire","Daire","Daire","Daire","Daire"};
    Spinner user_create_daire;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_users);
        listView = findViewById(R.id.listview);

        ArrayAdapter<String> veriAdaptoru = new ArrayAdapter<String>
                (this, android.R.layout.simple_list_item_1, android.R.id.text1, user);

        listView.setAdapter(veriAdaptoru);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int i, long l) {
                final Dialog userdetay = new Dialog(Users.this);
                userdetay.setContentView(R.layout.user_detay);
                userdetay.show();
                userdetay.findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        userdetay.dismiss();
                    }
                });
            }
        });
    }
    public void goAddUser(View view){
        Dialog dia = new Dialog(Users.this);
        dia.setContentView(R.layout.add_user);
        dia.show();

        user_create_blok=dia.findViewById(R.id.user_blok_chose);
        ArrayAdapter adap = new ArrayAdapter(this,android.R.layout.simple_spinner_item,blok);
        adap.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        user_create_blok.setAdapter(adap);
        user_create_blok.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(Users.this,blok[position]+" Seçildi",Toast.LENGTH_LONG).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        user_create_daire=dia.findViewById(R.id.user_daire_chose);
        ArrayAdapter ada = new ArrayAdapter(this,android.R.layout.simple_spinner_item,daire);
        ada.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        user_create_daire.setAdapter(ada);
        user_create_daire.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(Users.this,daire[position]+" Seçildi",Toast.LENGTH_LONG).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }
}
