package com.example.marvelappx.data.network;

import com.example.marvelappx.data.model.ComicData;
import com.example.marvelappx.data.network.response.ComicResponse;
import com.example.marvelappx.data.network.response.ComicResult;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface MarvelService {

    @GET("comics")
    Call<ComicResult> getAllComics(@Query("key")String chaveAPI);
}
