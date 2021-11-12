package com.example.marvelappx.data.network;



import com.example.marvelappx.data.network.response.ComicDataWrapper;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface MarvelService {

    @GET("/v1/public/comics")
    Call<ComicDataWrapper> getAllComics
            (@Query("ts") String ts, //time stamp igual 1
             @Query("apikey") String apikey,
             @Query("hash") String hash,
             @Query("limit") String limit);

}
