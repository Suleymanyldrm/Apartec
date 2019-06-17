package com.ertu.myapplication.Main;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.ertu.myapplication.R;

public class Guest extends AppCompatActivity {

    String [] anlik_guest={"Misafir ","Misafir ","Misafir","Misafir ","Misafir","Misafir"};
    String [] eski_guest={"Misafir ","Misafir ","Misafir","Misafir ","Misafir","Misafir"};

    ListView guestlist;
    ListView oldguestlist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guest);

        guestlist=findViewById(R.id.guest_list);
        oldguestlist=findViewById(R.id.old_guest_list);

        ArrayAdapter<String> adaptor = new ArrayAdapter<String>
                (this,android.R.layout.simple_list_item_1,android.R.id.text1,anlik_guest);
        guestlist.setAdapter(adaptor);
        guestlist.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                AlertDialog.Builder dia = new AlertDialog.Builder(Guest.this);
                dia.setMessage(anlik_guest[i]).setCancelable(false).setPositiveButton("Tamam", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
                dia.create().show();
            }
        });

        ArrayAdapter<String> adaptor1=new ArrayAdapter<String>
                (this,android.R.layout.simple_list_item_1,android.R.id.text1,eski_guest);
        oldguestlist.setAdapter(adaptor1);
        oldguestlist.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int i, long l) {
                final AlertDialog.Builder dia1 = new AlertDialog.Builder(Guest.this);
                dia1.setMessage(eski_guest[i]).setCancelable(false).setPositiveButton("Tamam", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
                dia1.create().show();
            }
        });

    }
}
