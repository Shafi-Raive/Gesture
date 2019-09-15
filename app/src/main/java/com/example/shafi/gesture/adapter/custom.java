package com.example.shafi.gesture.adapter;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.shafi.gesture.Model;
import com.example.shafi.gesture.R;

import java.util.List;

public class custom extends RecyclerView.Adapter<custom.myViewHolder> {

    private static ClickListener clickListener;
    Context context;
    private List<Model> mModelList;

    public custom(Context context, List<Model> modelList) {
        this.context = context;
        mModelList = modelList;
    }




    @NonNull
    @Override
    public myViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.sample_list_view, viewGroup, false);

        return new myViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final myViewHolder holder, int position) {

        final Model model = mModelList.get(position);
        holder.textView.setText(model.getText());
        holder.view.setBackgroundColor(model.isSelected() ? Color.CYAN : Color.WHITE);
        holder.textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                model.setSelected(!model.isSelected());
                holder.view.setBackgroundColor(model.isSelected() ? Color.CYAN : Color.WHITE);
              //  holder.view.setOnTouchListener(new MenuGestureHandler());
            }
        });

    }

    @Override
    public int getItemCount() {
        return mModelList == null ? 0 : mModelList.size();
    }

    class myViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener, View.OnLongClickListener{

        private View view;
        private TextView textView;

        public myViewHolder(@NonNull View itemView) {
            super(itemView);

            view = itemView;
            textView = (TextView) itemView.findViewById(R.id.tvTitle);

            itemView.setOnLongClickListener(this);
            itemView.setOnClickListener(this);

            ///itemView.setOnTouchListener(new MenuGestureHandler());
        }




        @Override
        public void onClick(View v) {
            clickListener.onItemClick(getAdapterPosition(), v);



        }

        @Override
        public boolean onLongClick(View v) {
            clickListener.onItemLongClick(getAdapterPosition(), v);
            return false;
        }
    }

    public interface ClickListener{

        void onItemClick(int position, View v);
        void onItemLongClick(int position, View v);
    }

    public void setItemClickListener(ClickListener clickListener){

        custom.clickListener = clickListener;
    }


















}
