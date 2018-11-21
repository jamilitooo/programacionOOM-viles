package com.example.jamilitooo.tareaglide;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class volumen {
    private String titulo;
    private String volumen;
    private String url;
    private String fecha;
    public volumen(JSONObject a) throws JSONException {
        titulo =  a.getString("title").toString();
        volumen =  "Vol: "+ a.getString("volume").toString()+" N°: "+a.getString("number").toString();
        url = a.getString("portada").toString();
        fecha=a.getString("data_published").toString();
    }
    public String getTitulo()
    {
        return titulo;
    }
    public String getVolumen()
    {
        return volumen;
    }
    public String getFecha()
    {
        return fecha;
    }
    public String getUrl()
    {
        return url;
    }

    public String getURL(){       return url;    }
    public static ArrayList<volumen> JsonObjectsBuild(JSONArray datos) throws JSONException {
        ArrayList<volumen> volumen1 = new ArrayList<>();
        for (int i = 0; i < datos.length(); i++) {
            volumen1.add(new volumen(datos.getJSONObject(i)));
        }
        return volumen1;
    }
}

