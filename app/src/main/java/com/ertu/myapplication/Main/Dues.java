package com.ertu.myapplication.Main;

import android.app.Dialog;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.ertu.myapplication.R;

public class Dues extends AppCompatActivity {


    String [] odemelist={"Kullanıcı 1","Kullanıcı 2","Kullancı 3","Kullanıcı 4","Kullanıcı 5"};
    ListView dues_list;

    String [] odemeyenlerlist={"Kullanıcı 6","Kullanıcı 7","Kullanıcı 8","Kullanıcı 9","Kullanıcı 10"};
    ListView dues_delay_list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dues);
        dues_list=findViewById(R.id.dues_list);

        ArrayAdapter<String> veriAdaptoru=new ArrayAdapter<String>
                (this,android.R.layout.simple_list_item_1,android.R.id.text1,odemelist);

        dues_list.setAdapter(veriAdaptoru);
        dues_list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                AlertDialog.Builder diyalog= new AlertDialog.Builder(Dues.this);
                diyalog.setMessage(odemelist[i]).setCancelable(false).setPositiveButton("Tamam", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
                diyalog.create().show();
            }
        });

        dues_delay_list=findViewById(R.id.dues_delay_list);

        ArrayAdapter<String> veriAdaptoru1=new ArrayAdapter<String>
                (this,android.R.layout.simple_list_item_1,android.R.id.text1,odemeyenlerlist);

        dues_delay_list.setAdapter(veriAdaptoru1);
        dues_delay_list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int i, long l) {

                Dialog dues_detay=new Dialog(Dues.this);
                dues_detay.setContentView(R.layout.item_view);
                dues_detay.show();
                /*
                AlertDialog.Builder diyalog1=new AlertDialog.Builder(Dues.this);
                diyalog1.setMessage(odemeyenlerlist[i]).setCancelable(false).setPositiveButton("Tamam", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
                diyalog1.create().show();*/
            }
        });

    }
}
