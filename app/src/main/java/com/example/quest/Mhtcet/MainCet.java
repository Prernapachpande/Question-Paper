package com.example.quest.Mhtcet;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.quest.ApiInterface;
import com.example.quest.Jeemain.MainAdapter;
import com.example.quest.Jeemain.MainJee;
import com.example.quest.R;
import com.example.quest.RetroClient;
import com.example.quest.model.Mains;
import com.example.quest.model.mhtcet;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainCet extends AppCompatActivity {
    private ProgressDialog pDialog;
    private List<mhtcet> mhtList;
    private RecyclerView recyclerView;
    private CetAdapter eAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_cet);

        pDialog = new ProgressDialog(MainCet.this);
        pDialog.setMessage("Loading Data.. Please wait...");
        pDialog.setIndeterminate(false);
        pDialog.setCancelable(false);
        pDialog.show();

        ApiInterface api = RetroClient.getRetrofitClient().create(ApiInterface.class);
        mhtList = new ArrayList<>();
        Call<List<mhtcet>> call = api.getcetdata();
        call.enqueue(new Callback<List<mhtcet>>() {
            @Override
            public void onResponse(Call<List<mhtcet>> call, Response<List<mhtcet>> response) {
                pDialog.dismiss();
                if(response.isSuccessful()){
                    mhtList = response.body();

                    recyclerView = (RecyclerView) findViewById(R.id.recycler_cet);
                    eAdapter = new CetAdapter(MainCet.this,mhtList);
                    RecyclerView.LayoutManager eLayoutManager = new LinearLayoutManager(getApplicationContext());
                    recyclerView.setLayoutManager(eLayoutManager);
                    recyclerView.setItemAnimator(new DefaultItemAnimator());
                    recyclerView.setAdapter(eAdapter);

                }
            }

            @Override
            public void onFailure(Call<List<mhtcet>> call, Throwable t) {
                pDialog.dismiss();
            }
        });
    }
    }

