package com.example.quest.Jeemain;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.quest.PdfView;
import com.example.quest.R;
import com.example.quest.model.Mains;

import java.util.List;

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.CustomViewHolder> {
    private List<Mains> m;
    private Context context;



    public MainAdapter(Context context, List<Mains> m) {
        this.context = context;
        this.m = m;
    }
    @Override
    public MainAdapter.CustomViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.main_recycler, parent, false);
        return new CustomViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final MainAdapter.CustomViewHolder holder, int position) {
        final Mains main = m.get(position);
        holder.year.setText(main.getYear());
        holder.year.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(context.getApplicationContext(),PdfView.class);
                i.putExtra("PdfView",main.getFile());
                context.startActivity(i);
            }
        });
    }

    @Override
    public int getItemCount() {
        return m.size();
    }
    public class CustomViewHolder extends RecyclerView.ViewHolder {
        public TextView year;


        public CustomViewHolder(View view) {
            super(view);
            year = (TextView) view.findViewById(R.id.year);

        }
    }
}
