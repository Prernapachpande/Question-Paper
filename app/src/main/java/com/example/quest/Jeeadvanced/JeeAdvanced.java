package com.example.quest.Jeeadvanced;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.quest.ApiInterface;
import com.example.quest.R;
import com.example.quest.RetroClient;
import com.example.quest.model.advanced;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class JeeAdvanced extends AppCompatActivity {
    private ProgressDialog pDialog;
    private List<advanced> advancedList;
    private RecyclerView recyclerView;
    private AdvancedAdapter eAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jee_advanced);

        pDialog = new ProgressDialog(JeeAdvanced.this);
        pDialog.setMessage("Loading Data.. Please wait...");
        pDialog.setIndeterminate(false);
        pDialog.setCancelable(false);
        pDialog.show();

        ApiInterface api = RetroClient.getRetrofitClient().create(ApiInterface.class);
        advancedList = new ArrayList<>();
        Call<List<advanced>> call = api.getalldata();
        call.enqueue(new Callback<List<advanced>>() {
            @Override
            public void onResponse(Call<List<advanced>> call, Response<List<advanced>> response) {
                pDialog.dismiss();
                if(response.isSuccessful()){
                    advancedList = response.body();

                    recyclerView = (RecyclerView) findViewById(R.id.recycler_advanced);
                    eAdapter = new AdvancedAdapter(JeeAdvanced.this,advancedList);
                    RecyclerView.LayoutManager eLayoutManager = new LinearLayoutManager(getApplicationContext());
                    recyclerView.setLayoutManager(eLayoutManager);
                    recyclerView.setItemAnimator(new DefaultItemAnimator());
                    recyclerView.setAdapter(eAdapter);

                }
            }

            @Override
            public void onFailure(Call<List<advanced>> call, Throwable t) {
                pDialog.dismiss();
            }
        });
    }
    }

