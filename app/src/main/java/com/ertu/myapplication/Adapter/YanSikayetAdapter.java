package com.ertu.myapplication.Adapter;

import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.ertu.myapplication.Main.UserComplaint;
import com.ertu.myapplication.Model.YanSikayetModel;
import com.ertu.myapplication.R;

import java.util.List;

public class YanSikayetAdapter extends BaseAdapter {

    List<YanSikayetModel> yansikayetModelList;
    Context context;

    public YanSikayetAdapter(List<YanSikayetModel> mulkModelList, Context context) {
        this.yansikayetModelList = mulkModelList;
        this.context = context;
    }

    @Override
    public int getCount() {
        return yansikayetModelList.size();
    }

    @Override
    public Object getItem(int position) {
        return yansikayetModelList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        convertView = LayoutInflater.from(context).inflate(R.layout.yanitlanan_sikayet, parent, false);
        TextView baslik = convertView.findViewById(R.id.yanitlanan);
        baslik.setText(yansikayetModelList.get(position).getBaslik());
        TextView icerik = convertView.findViewById(R.id.icerik);
        icerik.setText(yansikayetModelList.get(position).getIcerik());
        TextView cevap = convertView.findViewById(R.id.cevap);
        cevap.setText(yansikayetModelList.get(position).getCevap());

        return convertView;
    }
}
