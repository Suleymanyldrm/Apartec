package com.ertu.myapplication.Main;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.ertu.myapplication.R;

public class Propertys extends AppCompatActivity {

    String [] dairelist= {"Daire 1","Daire 2"};
    ListView daire_list;

    String[] dukkanlist = {"Dukkan 1","Dukkan 2","Dukkan 3"};
    ListView dukkan_list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_propertys);

        daire_list=findViewById(R.id.userdairelist);

        ArrayAdapter<String> adaptor = new ArrayAdapter<String>
                (this,android.R.layout.simple_list_item_1,android.R.id.text1,dairelist);
        daire_list.setAdapter(adaptor);
        daire_list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int i, long l) {
                AlertDialog.Builder dia1= new AlertDialog.Builder(Propertys.this);
                dia1.setMessage(dairelist[i]).setCancelable(false).setPositiveButton("Tamam", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
                dia1.create().show();
            }
        });

        dukkan_list=findViewById(R.id.dukkanlist);

        ArrayAdapter<String> adaptor2 = new ArrayAdapter<String>
                (this,android.R.layout.simple_list_item_1,android.R.id.text1,dukkanlist);
        dukkan_list.setAdapter(adaptor2);
        dukkan_list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int a, long b) {
                final AlertDialog.Builder dia2 = new AlertDialog.Builder(Propertys.this);
                dia2.setMessage(dukkanlist[a]).setCancelable(false).setPositiveButton("Tamam", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
                dia2.create().show();
            }
        });


    }
}
