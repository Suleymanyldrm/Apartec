package com.ertu.myapplication.Main;

import android.app.Dialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.ertu.myapplication.R;

public class Notice extends AppCompatActivity {

    String [] duyurular = {"Duyuru 1","Duyuru 2","Duyuru 3","Duyuru 4","Duyuru 5","Duyuru 6"};
    ListView notice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notice);

        notice=findViewById(R.id.notice_list);

        ArrayAdapter adaptor= new ArrayAdapter
                (this,android.R.layout.simple_list_item_1,android.R.id.text1,duyurular);
        notice.setAdapter(adaptor);
        notice.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int i, long l) {
                final Dialog dia1 = new Dialog(Notice.this);
                dia1.setContentView(R.layout.notice_edit);
                dia1.show();
            }
        });
    }
}
