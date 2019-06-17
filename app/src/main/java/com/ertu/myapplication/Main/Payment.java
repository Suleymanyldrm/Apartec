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

public class Payment extends AppCompatActivity {

    String [] payment = {"Ödeme-1","Ödeme-2","Ödeme-3","Ödeme-4","Ödeme-5","Ödeme-6","Ödeme-7","Ödeme-8","Ödeme-9","Ödeme-10"};
    ListView payment_all;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);

        payment_all=findViewById(R.id.payment_list);

        ArrayAdapter adap = new ArrayAdapter(this,android.R.layout.simple_list_item_1,android.R.id.text1,payment);
        payment_all.setAdapter(adap);
        payment_all.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                AlertDialog.Builder alert = new AlertDialog.Builder(Payment.this);
                alert.setMessage(payment[position]+"\n Ödeme Bilgileri").setCancelable(false).setPositiveButton("Geri", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
                alert.create().show();
            }
        });
    }
    public void createPayment(View view){
        Dialog dia = new Dialog(Payment.this);
        dia.setContentView(R.layout.add_payment);
        dia.show();
    }
}
