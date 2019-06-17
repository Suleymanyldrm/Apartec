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

public class Complaint extends AppCompatActivity {
    String [] complaintlist={"Şikayet 1","Şikayet 2","Şikayet 3"};
    ListView complaint_list;
    String [] unreaded_complaintlist={"Şikayet 3","Şikayet 4","Şikayet 5"};
    ListView n_complaint_list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_complaint);
        complaint_list=findViewById(R.id.complaint_list);

        ArrayAdapter<String> veriAdaptoru=new ArrayAdapter<String >
                (this,android.R.layout.simple_list_item_1,android.R.id.text1,complaintlist);

        complaint_list.setAdapter(veriAdaptoru);
        complaint_list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int i, long l) {
                AlertDialog.Builder diyalog=new AlertDialog.Builder(Complaint.this);
                diyalog.setMessage(complaintlist[i]).setCancelable(false).setPositiveButton("Tamam", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
                diyalog.create().show();
            }
        });
        n_complaint_list=findViewById(R.id.n_complaint_list);

        ArrayAdapter<String> veriAdaptoru2 = new ArrayAdapter<String>
                (this,android.R.layout.simple_list_item_2,android.R.id.text2,unreaded_complaintlist);

        n_complaint_list.setAdapter(veriAdaptoru2);
        n_complaint_list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Dialog comp=new Dialog(Complaint.this);
                comp.setContentView(R.layout.n_complaint);
                comp.show();
            }
        });

    }
}
