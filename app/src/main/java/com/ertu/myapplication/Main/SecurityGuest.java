package com.ertu.myapplication.Main;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.ertu.myapplication.R;

public class SecurityGuest extends AppCompatActivity {

    String [] aktif_guest_list={"Misafir 1","Misafir 2","Misafir 3","Misafir 4","Misafir 5","Misafir 6","Misafir 7","Misafir 8","Misafir 9"};
    ListView guestlist;

    String [] old_guest_list={"Misafir 1","Misafir 2","Misafir 3","Misafir 4","Misafir 5","Misafir 6","Misafir 7","Misafir 8","Misafir 9"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_security_guest);

        guestlist = findViewById(R.id.guest_list);
        ArrayAdapter adap = new ArrayAdapter(this,android.R.layout.simple_list_item_1,android.R.id.text1,aktif_guest_list);
        guestlist.setAdapter(adap);
        guestlist.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int i, long l) {
                Dialog dia = new Dialog(SecurityGuest.this);
                dia.setContentView(R.layout.activity_security_guest_detay);
                dia.show();
            }
        });

    }
    public void addGuest(View view){

        Dialog dia1 = new Dialog(SecurityGuest.this);
        dia1.setContentView(R.layout.activity_add_guest);
        dia1.show();
    }
    public void listOldGuest(View view){
        Dialog dia2 = new Dialog(SecurityGuest.this);
        dia2.setContentView(R.layout.activity_old_guest_list);
        dia2.show();

        ListView oldguestlist;

        oldguestlist = dia2.findViewById(R.id.oldlist);
        ArrayAdapter adap2 = new ArrayAdapter
                (this,android.R.layout.simple_list_item_1,android.R.id.text1,old_guest_list);
        oldguestlist.setAdapter(adap2);
        oldguestlist.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                AlertDialog.Builder alert = new AlertDialog.Builder(SecurityGuest.this);
                alert.setMessage(old_guest_list[position]+"\nZiyaretçi Bilgileri").setCancelable(false).setPositiveButton("Geri", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
                alert.create().show();
            }
        });

    }
}
