package com.example.marvelappx.data.network;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiService {

    private static MarvelService INSTANCE;

    public static MarvelService getINSTANCE() {

        if (INSTANCE == null) {
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl("http://gateway.marvel.com/v1/public/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
            INSTANCE = retrofit.create(MarvelService.class);
        }
        return INSTANCE;


    }


}
