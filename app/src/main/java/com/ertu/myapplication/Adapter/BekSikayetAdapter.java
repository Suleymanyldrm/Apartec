package com.ertu.myapplication.Adapter;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.ertu.myapplication.Main.UserComplaint;
import com.ertu.myapplication.Model.BekSikayetModel;
import com.ertu.myapplication.R;

import java.util.List;

public class BekSikayetAdapter extends BaseAdapter {

    List<BekSikayetModel> sikayetModelList;
    Context context;
    Activity activity;

    public BekSikayetAdapter(List<BekSikayetModel> mulkModelList, Context context) {
        this.sikayetModelList = mulkModelList;
        this.context = context;
    }

    @Override
    public int getCount() {
        return sikayetModelList.size();
    }

    @Override
    public Object getItem(int position) {
        return sikayetModelList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        convertView = LayoutInflater.from(context).inflate(R.layout.beklemedeki_sikayet, parent, false);
        TextView baslik = convertView.findViewById(R.id.bekleme);
        baslik.setText(sikayetModelList.get(position).getBaslik());
        TextView icerik = convertView.findViewById(R.id.icerik);
        icerik.setText(sikayetModelList.get(position).getIcerik());

        return convertView;

        }
}


