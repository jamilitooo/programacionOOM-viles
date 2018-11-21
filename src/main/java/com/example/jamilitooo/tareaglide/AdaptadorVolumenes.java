package com.example.jamilitooo.tareaglide;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.Glide;

import java.util.ArrayList;


public class AdaptadorVolumenes extends ArrayAdapter<volumen> {



    public AdaptadorVolumenes(Context context, ArrayList<volumen> datos) {
        super(context, R.layout.layoutitem, datos);
    }


    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = LayoutInflater.from(getContext());
        View item = inflater.inflate(R.layout.layoutitem, null);

        TextView lblTitulo = (TextView)item.findViewById(R.id.lblTitulo);
        lblTitulo.setText(getItem(position).getTitulo());

        TextView lblVolumen = (TextView)item.findViewById(R.id.lblVolumen);
        lblVolumen.setText(getItem(position).getVolumen());

        TextView lblFecha = (TextView)item.findViewById(R.id.lblFecha);
        lblFecha.setText(getItem(position).getFecha());

        ImageView imageView = (ImageView)item.findViewById(R.id.imgNoticia);
        Glide.with(this.getContext())
                .load(getItem(position).getURL())
                .error(R.drawable.imgnotfound)
                .into(imageView);


        return(item);
    }
}

