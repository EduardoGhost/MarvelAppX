package com.example.marvelappx.data.network;



import com.example.marvelappx.data.model.ComicDataWrapper;

import retrofit2.Call;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface MarvelService {


    @GET("comics")
    Call<ComicDataWrapper> getAllComics(@Query("ts") String key,
                                        @Query("apikey") String apikey,
                                        @Query("hash") String hash);
}
