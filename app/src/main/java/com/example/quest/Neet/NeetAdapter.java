package com.example.quest.Neet;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.quest.Jeemain.MainAdapter;
import com.example.quest.PdfView;
import com.example.quest.R;
import com.example.quest.model.Mains;
import com.example.quest.model.neet;

import java.util.List;

public class NeetAdapter extends RecyclerView.Adapter<NeetAdapter.CustomViewHolder>{
    private List<neet> n;
    private Context context;

    public NeetAdapter(Context context, List<neet> n) {
        this.context = context;
        this.n = n;
    }
    @Override
    public NeetAdapter.CustomViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.neet_recycler, parent, false);
        return new NeetAdapter.CustomViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final NeetAdapter.CustomViewHolder holder, int position) {
        final neet neet = n.get(position);
        holder.year.setText(neet.getYear());
        holder.year.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(context.getApplicationContext(), PdfView.class);
                i.putExtra("PdfView",neet.getFile());
                context.startActivity(i);
            }
        });
    }

    @Override
    public int getItemCount() {
        return n.size();
    }
    public class CustomViewHolder extends RecyclerView.ViewHolder {
        public TextView year;


        public CustomViewHolder(View view) {
            super(view);
            year = (TextView) view.findViewById(R.id.year);
        }
    }
}
