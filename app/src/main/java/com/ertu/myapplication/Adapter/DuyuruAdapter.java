package com.ertu.myapplication.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.ertu.myapplication.Model.DuyuruModel;
import com.ertu.myapplication.R;

import java.util.List;

public class DuyuruAdapter extends BaseAdapter {

    List<DuyuruModel> duyuruModelList;
    Context context;

    public DuyuruAdapter(List<DuyuruModel> mulkModelList, Context context) {
        this.duyuruModelList = mulkModelList;
        this.context = context;
    }

    @Override
    public int getCount() {
        return duyuruModelList.size();
    }

    @Override
    public Object getItem(int position) {
        return duyuruModelList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        convertView = LayoutInflater.from(context).inflate(R.layout.user_duyuru, parent, false);
        TextView baslik = convertView.findViewById(R.id.baslik);
        TextView icerik = convertView.findViewById(R.id.icerik);
        TextView tarih = convertView.findViewById(R.id.tarih);
        baslik.setText(duyuruModelList.get(position).getBaslik());
        icerik.setText(duyuruModelList.get(position).getIcerik());
        tarih.setText(duyuruModelList.get(position).getTarih());
        return convertView;
    }
}
