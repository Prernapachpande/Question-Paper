package com.example.quest.Neet;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.quest.ApiInterface;
import com.example.quest.R;
import com.example.quest.RetroClient;
import com.example.quest.model.neet;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainNeet extends AppCompatActivity {
    private ProgressDialog pDialog;
    private List<neet> neetList;
    private RecyclerView recyclerView;
    private NeetAdapter eAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_neet);

        pDialog = new ProgressDialog(MainNeet.this);
        pDialog.setMessage("Loading Data.. Please wait...");
        pDialog.setIndeterminate(false);
        pDialog.setCancelable(false);
        pDialog.show();

        ApiInterface api = RetroClient.getRetrofitClient().create(ApiInterface.class);
        neetList = new ArrayList<>();
        Call<List<neet>> call = api.getneetdata();
        call.enqueue(new Callback<List<neet>>() {
            @Override
            public void onResponse(Call<List<neet>> call, Response<List<neet>> response) {
                pDialog.dismiss();
                if(response.isSuccessful()){
                    neetList = response.body();

                    recyclerView = (RecyclerView) findViewById(R.id.recycler_neet);
                    eAdapter = new NeetAdapter(MainNeet.this,neetList);
                    RecyclerView.LayoutManager eLayoutManager = new LinearLayoutManager(getApplicationContext());
                    recyclerView.setLayoutManager(eLayoutManager);
                    recyclerView.setItemAnimator(new DefaultItemAnimator());
                    recyclerView.setAdapter(eAdapter);

                }
            }

            @Override
            public void onFailure(Call<List<neet>> call, Throwable t) {
                pDialog.dismiss();

            }
        });
    }
    }

