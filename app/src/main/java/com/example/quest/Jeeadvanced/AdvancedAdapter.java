package com.example.quest.Jeeadvanced;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import com.example.quest.PdfView;
import com.example.quest.R;
import com.example.quest.model.advanced;

import java.util.List;

public class AdvancedAdapter extends RecyclerView.Adapter<AdvancedAdapter.CustomViewHolder> {
    private List<advanced> a;
    private Context context;
    private ViewGroup parent;
    private int viewType;



    public AdvancedAdapter(Context context, List<advanced> a) {
        this.context = context;
        this.a = a;
    }
    @Override
    public AdvancedAdapter.CustomViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.advanced_recycler, parent, false);
        return new AdvancedAdapter.CustomViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final AdvancedAdapter.CustomViewHolder holder, int position) {
        final advanced advanced = a.get(position);
        holder.year.setText(advanced.getYear());
       holder.year.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(context.getApplicationContext(), AdvancedPpr.class);
                i.putExtra("year",advanced.getYear());
                context.startActivity(i);
            }
        });
    }

    @Override
    public int getItemCount() {
        return a.size();
    }
    public class CustomViewHolder extends RecyclerView.ViewHolder {
        public TextView year;


        public CustomViewHolder(View view) {
            super(view);
            year = (TextView) view.findViewById(R.id.year);

        }
    }
}
