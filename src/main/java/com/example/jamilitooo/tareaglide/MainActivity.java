package com.example.jamilitooo.tareaglide;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;

import com.bumptech.glide.Glide;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import WebServices.Asynchtask;
import WebServices.WebService;

public class MainActivity extends AppCompatActivity implements Asynchtask {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageView imageView = (ImageView) findViewById(R.id.imgNoticia);
        Glide.with(this).load("http://goo.gl/gEgYUd").into(imageView);

        Map<String,String> datos=new HashMap<>();
        WebService ws=new WebService("http://revistas.uteq.edu.ec/ws/getrevistas.php",datos, this, this);
        ws.execute("");
    }

    @Override
    public void processFinish(String result) throws JSONException {
        JSONObject jsonObject=new JSONObject(result);
        JSONArray revistas =jsonObject.getJSONArray("issues");

        ArrayList<volumen> volumen1=new ArrayList<>();

        for(int i=0;i<revistas.length();i++)
        {
            volumen1.add(new volumen(revistas.getJSONObject(i)));
        }

        AdaptadorVolumenes adaptadorVolumenes=new AdaptadorVolumenes(this, volumen1);
        ListView lstvolumenes=(ListView)findViewById(R.id.lstvolumenes);
        lstvolumenes.setAdapter(adaptadorVolumenes);
    }
}
