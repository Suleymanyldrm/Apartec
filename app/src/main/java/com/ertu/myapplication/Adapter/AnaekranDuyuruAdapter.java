package com.ertu.myapplication.Adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.ertu.myapplication.Main.UserDuyuru;
import com.ertu.myapplication.Model.AnaekranDuyuruModel;
import com.ertu.myapplication.R;

import java.util.List;

public class AnaekranDuyuruAdapter extends BaseAdapter {

    List<AnaekranDuyuruModel> anaduyuruModelList;
    Context context;
    Activity activity;

    public AnaekranDuyuruAdapter(List<AnaekranDuyuruModel> mulkModelList, Context context) {
        this.anaduyuruModelList = mulkModelList;
        this.context = context;
    }

    @Override
    public int getCount() {
        return anaduyuruModelList.size();
    }

    @Override
    public Object getItem(int position) {
        return anaduyuruModelList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        convertView = LayoutInflater.from(context).inflate(R.layout.ana_ekran_duyuru, parent, false);
        TextView anabaslik = convertView.findViewById(R.id.ana_baslik);
        TextView anatarih = convertView.findViewById(R.id.ana_tarih);
        anabaslik.setText(anaduyuruModelList.get(position).getAnabaslik());
        anatarih.setText(anaduyuruModelList.get(position).getAnatarih());

        LinearLayout anaekran = convertView.findViewById(R.id.anaekran);
        anaekran.setOnClickListener(new View.OnClickListener() {   // TODO: 25.04.2019 anaekrandaki duyuru başlığına tıkladığı zaman
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, UserDuyuru.class);
                context.startActivity(intent);
            }
        });
        return convertView;
    }

}
