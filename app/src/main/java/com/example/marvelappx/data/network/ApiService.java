package com.example.marvelappx.data.network;

import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import timber.log.Timber;

public class ApiService {

    private static MarvelService INSTANCE;
    private static final String BASE_URL = "https://gateway.marvel.com";

    public static MarvelService getINSTANCE() {
        if (INSTANCE == null) {
            HttpLoggingInterceptor httpLoggingInterceptor = new
                    HttpLoggingInterceptor(message -> Timber.i("deu certo"));

            httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
            OkHttpClient okHttpClient = new OkHttpClient()
                    .newBuilder()
                    .connectTimeout(300, TimeUnit.SECONDS)
                    .readTimeout(300, TimeUnit.SECONDS)
                    .addInterceptor(httpLoggingInterceptor)
                    .build();

            GsonBuilder gsonBuilder = new GsonBuilder();
            Gson gson = gsonBuilder.create();

            Retrofit retrofit = new retrofit2.Retrofit.Builder()
                    .client(okHttpClient)
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .build();

            INSTANCE = retrofit.create(MarvelService.class);


            Log.i("RETROFIT DEU CERTO", "CERTO");
        }else{
            Log.e("RETROFIT DEU ERRADO", "ERROU");
        }
        return INSTANCE;


    }


}
