package com.example.quest.Jeeadvanced;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.quest.PdfView;
import com.example.quest.R;
import com.example.quest.model.advancedppr;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;


public class AdvancedPpr extends AppCompatActivity {
    private List<advancedppr> advancedpprList;
    private String TAG = AdvancedPpr.class.getSimpleName();
    public  static TextView ppra,pprb;
    public  static String PaperA,PaperB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_advanced_ppr);
        advancedpprList = new ArrayList<>();

        papers paper = new papers();
        paper.execute();
        TextView txt = (TextView) findViewById(R.id.txt);
        String title = getIntent().getStringExtra("year");
        txt.setText(title);

        ppra = (TextView) findViewById(R.id.papera);
       pprb = (TextView) findViewById(R.id.paperb);
        ppra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a = new Intent(AdvancedPpr.this, PdfView.class);
                a.putExtra("PdfView",PaperA);
                startActivity(a);
            }
        });
        pprb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent b = new Intent(AdvancedPpr.this,PdfView.class);
                b.putExtra("PdfView",PaperB);
                startActivity(b);
            }
        });
        }
    }

