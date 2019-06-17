package com.ertu.myapplication.Main;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatDialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.ertu.myapplication.R;

import java.util.HashMap;
import java.util.Map;

public class MulkDuzenle extends AppCompatDialogFragment {

    EditText arac, daire, dukkan;
    String _arac, _daire, _dukkan;
    Context context;
    Activity activity;

    // TODO: 7.04.2019  Mülklerim sayfasında mülklerimi düzenleye tıklandığı zaman açılacak alertin clası....
    @Override
    public Dialog onCreateDialog(final Bundle savedInstanceState) {

        final AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater layoutInflater = getActivity().getLayoutInflater();
        final View view = layoutInflater.inflate(R.layout.mulk_duzenle, null);

        //context = view.getContext();

        builder.setView(view);
        builder.setTitle("MÜLKLERİNİ DÜZENLE");
        builder.setNegativeButton("vazgeç", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        builder.setPositiveButton("kaydet", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                arac = view.findViewById(R.id.d_arac);
                daire = view.findViewById(R.id.d_daire);
                dukkan = view.findViewById(R.id.d_dukkan);

                if (arac.getText().toString().trim().equals("") || daire.getText().toString().trim().equals("")
                        || dukkan.getText().toString().trim().equals("")) {

                    Toast.makeText(getActivity(), "Lütfen Boş Alanları Doldurun", Toast.LENGTH_LONG).show();

                } else {

                    mulkGuncelle();

                    arac.setText("");
                    daire.setText("");
                    dukkan.setText("");


                }

            }
        });

        return builder.create();
    }

   /* @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        if (context instanceof Activity){
            activity=(Activity) context;
        }

    }*/

    public void mulkGuncelle() {

        _arac = arac.getText().toString().trim();
        _daire = daire.getText().toString().trim();
        _dukkan = dukkan.getText().toString().trim();

        String mail = getArguments().getString("email");
        String url = "http://suleyman36.dx.am/database/mulkleri_duzenle.php?email=" + mail;
        StringRequest stringRequest = new StringRequest(Request.Method.POST, url,
                new Response.Listener<String>() {   // TODO: 29.03.2019 Verileri yolladığımız çalışacak method.
                    @Override
                    public void onResponse(String response) {

                        Toast.makeText(getContext(), response, Toast.LENGTH_LONG).show();
                        //reloadFragment();

                    }
                }, new Response.ErrorListener() {     // TODO: 29.03.2019 Veriler yollanmadığı zaman çalışacak method.
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getActivity(), "hata" + error, Toast.LENGTH_LONG).show();
            }
        }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError { // TODO: 29.03.2019 Verilerin yollanması
                HashMap<String, String> deger = new HashMap<>();

                deger.put("arac", _arac);
                deger.put("daire", _daire);                              // TODO: 29.03.2019 "sütun ismi" , text
                deger.put("dukkan", _dukkan);

                return deger;
            }
        };

        MySingleton.getInstance(getActivity()).addToRequestQueue(stringRequest);

    }

    /*private void reloadFragment(){
        if(activity!=null){
            Fragment currentFragment = activity.getFragmentManager().findFragmentById(R.id.mulkduzenle);
            if (currentFragment!=null) {
                FragmentTransaction fragTransaction =   (activity).getFragmentManager().beginTransaction();
                fragTransaction.detach(currentFragment);
                fragTransaction.attach(currentFragment);
                fragTransaction.commit();
            }
        }

    }*/
}

