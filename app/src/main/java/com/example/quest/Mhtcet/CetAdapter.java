package com.example.quest.Mhtcet;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.quest.Jeemain.MainAdapter;
import com.example.quest.Neet.NeetAdapter;
import com.example.quest.PdfView;
import com.example.quest.R;
import com.example.quest.model.Mains;
import com.example.quest.model.mhtcet;

import java.util.List;

public class CetAdapter extends RecyclerView.Adapter<CetAdapter.CustomViewHolder> {
    private List<mhtcet> c;
    private Context context;

    public CetAdapter(Context context, List<mhtcet> c) {
        this.context = context;
        this.c = c;
    }
    @Override
    public CetAdapter.CustomViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.cet_recycler, parent, false);
        return new CetAdapter.CustomViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final CetAdapter.CustomViewHolder holder, int position) {
        final mhtcet cet = c.get(position);
        holder.year.setText(cet.getYear());
        holder.year.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(context.getApplicationContext(), PdfView.class);
                i.putExtra("PdfView",cet.getFile());
                context.startActivity(i);
            }
        });
    }

    @Override
    public int getItemCount() {
        return c.size();
    }
    public class CustomViewHolder extends RecyclerView.ViewHolder {
        public TextView year;


        public CustomViewHolder(View view) {
            super(view);
            year = (TextView) view.findViewById(R.id.year);
           /*year.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent i = new Intent(context.getApplicationContext(),PdfView.class);
                    i.putExtra("pdf_url",main.getFile());
                    context.startActivity(i);
                }*/
        }
    }
}
