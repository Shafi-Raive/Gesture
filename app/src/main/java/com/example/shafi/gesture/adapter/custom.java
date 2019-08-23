package com.example.shafi.gesture.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.shafi.gesture.R;

public class custom extends RecyclerView.Adapter<custom.myViewHolder> {

    Context context;
    String [] name, name1;

    public custom(Context context, String[] name, String[] name1) {
        this.context = context;
        this.name = name;
        this.name1 = name1;
    }




    @NonNull
    @Override
    public myViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.sample_list_view, viewGroup, false);

        return new myViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull myViewHolder myViewHolder, int i) {

        myViewHolder.title.setText(name[i]);
        myViewHolder.dsc.setText(name1[i]);

    }

    @Override
    public int getItemCount() {
        return name.length;
    }

    class myViewHolder extends RecyclerView.ViewHolder{

        TextView title, dsc;

        public myViewHolder(@NonNull View itemView) {
            super(itemView);

            title = itemView.findViewById(R.id.tvTitle);
            dsc = itemView.findViewById(R.id.tvDsc);
        }
    }
}
