package com.example.marvelappx.data.network;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import timber.log.Timber;

public class ApiService {

    private static MarvelService INSTANCE;
    private static final String BASE_URL = "https://gateway.marvel.com/v1/public/";

    public static MarvelService getINSTANCE() {

        if (INSTANCE == null) {

            GsonBuilder gsonBuilder = new GsonBuilder();
            Gson gson = gsonBuilder.create();
            HttpLoggingInterceptor httpLoggingInterceptor = new
                    HttpLoggingInterceptor(message -> Timber.i(message));

            httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

            OkHttpClient okHttpClient = new OkHttpClient()
                    .newBuilder()
                    .addInterceptor(httpLoggingInterceptor)
                    .build();

            Retrofit retrofit = new Retrofit.Builder()
                    .client(okHttpClient)
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .build();
            INSTANCE = retrofit.create(MarvelService.class);
        }
        return INSTANCE;


    }


}
