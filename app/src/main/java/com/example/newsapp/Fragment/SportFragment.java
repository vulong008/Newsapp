package com.example.newsapp.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.newsapp.API.ApiUtilities;
import com.example.newsapp.Adapter.Adapter;
import com.example.newsapp.Model.Models;
import com.example.newsapp.Model.mainNews;
import com.example.newsapp.R;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SportFragment extends Fragment {
    private String category="sports";
    String api="fe7b771999d24d46911599c9512a8832";
    ArrayList<Models> modelsArrayList;
    Adapter adapter;
    String  country="in";
    private RecyclerView recyclerViewSport;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.sport_fragment,container,false);
        recyclerViewSport=view.findViewById(R.id.RecyclerViewSport);
        modelsArrayList=new ArrayList<>();
        recyclerViewSport.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter=new Adapter(getContext(),modelsArrayList);
        recyclerViewSport.setAdapter(adapter);

        findNews();
        return view;
    }


    private void findNews() {
        ApiUtilities.getApiInterface().getCategoriNews(country,category,100,api).enqueue(new Callback<mainNews>() {
            @Override
            public void onResponse(Call<mainNews> call, Response<mainNews> response) {
                if(response.isSuccessful())
                {
                    modelsArrayList.addAll(response.body().getArticles());
                    adapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onFailure(Call<mainNews> call, Throwable t) {

            }
        });
    }
}
