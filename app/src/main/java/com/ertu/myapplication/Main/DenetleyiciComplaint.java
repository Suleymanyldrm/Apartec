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

public class DenetleyiciComplaint extends AppCompatActivity {

    String [] complaintlist={"Şikayet 1","Şikayet 2","Şikayet 3"};
    ListView complaint_list;
    String [] unreaded_complaintlist={"Şikayet 4","Şikayet 5","Şikayet 6"};
    ListView n_complaint_list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_denetleyici_complaint);

        complaint_list=findViewById(R.id.yanitlanmis_list);

        final ArrayAdapter adap = new ArrayAdapter
                (this,android.R.layout.simple_list_item_1,android.R.id.text1,complaintlist);
        complaint_list.setAdapter(adap);
        complaint_list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                AlertDialog.Builder alert = new AlertDialog.Builder(DenetleyiciComplaint.this);
                alert.setMessage(complaintlist[position]+" \nŞikayet İçeriği").setCancelable(false).setPositiveButton("Geri", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
                alert.create().show();
            }
        });

        n_complaint_list=findViewById(R.id.yanitlanmamisliste);

        ArrayAdapter adap2 = new ArrayAdapter(this,android.R.layout.simple_list_item_1,android.R.id.text1,unreaded_complaintlist);
        n_complaint_list.setAdapter(adap2);
        n_complaint_list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                AlertDialog.Builder alert2 = new AlertDialog.Builder(DenetleyiciComplaint.this);
                alert2.setMessage(unreaded_complaintlist[position]+"\n Şikayet İçeriği").setCancelable(false).setPositiveButton("Geri", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
                alert2.create().show();
            }
        });

    }
}
