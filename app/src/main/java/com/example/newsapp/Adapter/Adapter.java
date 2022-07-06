package com.example.newsapp.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.newsapp.Model.Models;
import com.example.newsapp.R;
import com.example.newsapp.View.webview;

import java.util.ArrayList;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHoler> {
    Context context;
    ArrayList<Models> modelsArrayList;

    public Adapter(Context context, ArrayList<Models> models) {
        this.context = context;
        this.modelsArrayList = models;
    }

    @NonNull
    @Override
    public ViewHoler onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.layout_item, null, false);
        return new ViewHoler(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHoler holder, int position) {
        Models models = modelsArrayList.get(position);
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, webview.class);
                intent.putExtra("url", models.getUrl());
                context.startActivity(intent);
            }
        });

        holder.time.setText(new StringBuilder().append("Published At:-").append(models.getPublishedAt()).toString());
        holder.author.setText(models.getAuthor());
        holder.heading.setText(models.getTitle());
        holder.content.setText(models.getDescription());
        Glide.with(context).load(models.getUrlToImage()).into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return modelsArrayList.size();
    }

    public class ViewHoler extends RecyclerView.ViewHolder {
        TextView heading, content, author, category, time;
        CardView cardView;
        ImageView imageView;


        public ViewHoler(@NonNull View itemView) {
            super(itemView);
            heading = itemView.findViewById(R.id.mainheading);
            content = itemView.findViewById(R.id.content);
            author = itemView.findViewById(R.id.author);
            //  category=itemView.findViewById(R.id.mainheading);
            time = itemView.findViewById(R.id.time);
            cardView = itemView.findViewById(R.id.cardView);
            imageView = itemView.findViewById(R.id.imageView);
        }
    }
}
