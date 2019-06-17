package com.ertu.myapplication.Main;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
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

public class SikayetGonder extends AppCompatDialogFragment {

    EditText baslik, icerik;
    String  gBaslik,gIcerik;
    Context context;
    Activity activity;

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {


        final AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater layoutInflater = getActivity().getLayoutInflater();
        final View view = layoutInflater.inflate(R.layout.create_complaint, null);

        builder.setView(view);
        builder.setTitle("Şikayet Gönder");
        builder.setNegativeButton("vazgeç", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        builder.setPositiveButton("gönder", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                baslik = view.findViewById(R.id.baslik);
                icerik = view.findViewById(R.id.icerik);

                if (baslik.getText().toString().trim().equals("") || icerik.getText().toString().trim().equals("")) {

                    Toast.makeText(getActivity(), "Lütfen Boş Alanları Doldurun", Toast.LENGTH_LONG).show();
                } else {

                    gonder();
                    baslik.setText("");
                    icerik.setText("");
                }

            }
        });

        return builder.create();
    }

    public void gonder() {

        gBaslik = baslik.getText().toString().trim();
        gIcerik = icerik.getText().toString().trim();

        final String mail = getArguments().getString("email");
        String url = "http://suleyman36.dx.am/database/sikayet_gonder.php";
        StringRequest stringRequest = new StringRequest(Request.Method.POST, url,
                new Response.Listener<String>() {   // TODO: 29.03.2019 Verileri yolladığımız çalışacak method.
                    @Override
                    public void onResponse(String response) {

                        Toast.makeText(getActivity(), response, Toast.LENGTH_LONG).show();

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

                deger.put("baslik", gBaslik);                                 // TODO: 29.03.2019 "sütun ismi" , text
                deger.put("icerik", gIcerik);
                deger.put("yazar",mail);

                return deger;
            }
        };

        MySingleton.getInstance(getActivity()).addToRequestQueue(stringRequest);
    }
}
