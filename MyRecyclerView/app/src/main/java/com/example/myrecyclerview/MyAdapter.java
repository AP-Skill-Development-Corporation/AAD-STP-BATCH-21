package com.example.myrecyclerview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    Context ctx;
    int imgs[];
    String titles[];
    String subTitles[];

    public MyAdapter(Context ctx, int[] imgs, String[] titles, String[] subTitles) {
        this.ctx = ctx;
        this.imgs = imgs;
        this.titles = titles;
        this.subTitles = subTitles;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyViewHolder(LayoutInflater.from(ctx).inflate(R.layout.every_row_design,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.img.setImageResource(imgs[position]);
        holder.ti.setText(titles[position]);
        holder.st.setText(subTitles[position]);
    }

    @Override
    public int getItemCount() {
        return imgs.length;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView img;
        TextView ti,st;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            img=itemView.findViewById(R.id.iv);
            ti=itemView.findViewById(R.id.tv_title);
            st=itemView.findViewById(R.id.tv_subtitle);
        }
    }
}
