package com.example.quest.Jeemain;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.quest.ApiInterface;
import com.example.quest.R;
import com.example.quest.RetroClient;
import com.example.quest.model.Mains;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainJee extends AppCompatActivity {
    private ProgressDialog pDialog;
    private List<Mains> mainsList;
    private RecyclerView recyclerView;
    private MainAdapter eAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_jee);

        pDialog = new ProgressDialog(this);
        pDialog.setMessage("Loading Data.. Please wait...");
        pDialog.setIndeterminate(false);
        pDialog.setCancelable(false);
        pDialog.show();

        ApiInterface api = RetroClient.getRetrofitClient().create(ApiInterface.class);
        mainsList = new ArrayList<>();
        Call<List<Mains>> call = api.getdata();
        call.enqueue(new Callback<List<Mains>>() {
            @Override
            public void onResponse(Call<List<Mains>> call, Response<List<Mains>> response) {
                pDialog.dismiss();
                if(response.isSuccessful()){
                    mainsList = response.body();

                    recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
                    eAdapter = new MainAdapter(MainJee.this,mainsList);
                    RecyclerView.LayoutManager eLayoutManager = new LinearLayoutManager(getApplicationContext());
                    recyclerView.setLayoutManager(eLayoutManager);
                    recyclerView.setItemAnimator(new DefaultItemAnimator());
                    recyclerView.setAdapter(eAdapter);

                }
            }

            @Override
            public void onFailure(Call<List<Mains>> call, Throwable t) {
                pDialog.dismiss();
            }
        });
    }
}
