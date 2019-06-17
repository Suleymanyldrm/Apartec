package com.ertu.myapplication.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.ertu.myapplication.Model.MulkModel;
import com.ertu.myapplication.R;

import java.util.List;

public class MulkAdapter extends BaseAdapter {

    List<MulkModel> mulkModelList;
    Context context;

    public MulkAdapter(List<MulkModel> mulkModelList, Context context) {
        this.mulkModelList = mulkModelList;
        this.context = context;
    }

    @Override
    public int getCount() {
        return mulkModelList.size();
    }

    @Override
    public Object getItem(int position) {
        return mulkModelList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        convertView = LayoutInflater.from(context).inflate(R.layout.user_mulk, parent, false);
        TextView aracAdi = convertView.findViewById(R.id.arac_adi);
        TextView daireAdi = convertView.findViewById(R.id.daire_adi);
        TextView dukkanAdi = convertView.findViewById(R.id.dukkan_adi);
        aracAdi.setText(mulkModelList.get(position).getArac());
        daireAdi.setText(mulkModelList.get(position).getDaire());
        dukkanAdi.setText(mulkModelList.get(position).getDukkan());
        return convertView;
    }
}
