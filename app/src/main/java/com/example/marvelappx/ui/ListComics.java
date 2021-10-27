package com.example.marvelappx.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.Window;

import com.example.marvelappx.R;
import com.example.marvelappx.data.model.Comic;
import com.example.marvelappx.data.model.ComicData;
import com.example.marvelappx.data.network.ApiService;
import com.example.marvelappx.data.network.MarvelService;
import com.example.marvelappx.data.network.response.ComicResult;

import java.util.Arrays;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ListComics extends AppCompatActivity {
    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        recyclerView = findViewById(R.id.recycler_comics);

        ApiService.getINSTANCE().getAllComics
                ("ts=1&apikey=87eae2cc29e0e5c27e1978b9b1d484f5&hash=fddd12b1cc463430b1ef5e4853f20b8a").enqueue
                (new Callback<ComicResult>() {
                    @Override
                    public void onResponse(Call<ComicResult> call, Response<ComicResult> response) {
                        if(response.isSuccessful()){
                            RecyclerView.LayoutManager linearLayoutManager = new LinearLayoutManager(ListComics.this);
                            recyclerView.setLayoutManager(linearLayoutManager);
                            recyclerView.setAdapter(new ListComicsAdapter(response.body().getDados()));
                        }
                    }

                    @Override
                    public void onFailure(Call<ComicResult> call, Throwable t) {

                    }
                });


    }

    }
