package com.example.marvelappx.data.di.module;


import android.content.Context;

import com.example.marvelappx.data.di.components.Componentes;
import com.example.marvelappx.data.di.scope.PerActivity;
import com.example.marvelappx.data.network.MarvelService;
import com.example.marvelappx.data.network.response.ComicDataContainer;
import com.example.marvelappx.data.network.response.ComicDataWrapper;

import java.util.concurrent.TimeUnit;

import javax.inject.Named;
import javax.inject.Scope;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import timber.log.Timber;


@Module(includes = ContextModule.class)
public class ApplicationModule {

    public String mBaseUrl = "https://gateway.marvel.com/v1/public/";

    @PerActivity
    @Provides
    GsonConverterFactory provideGsonConverterFactory() {
        return GsonConverterFactory.create();
    }


    @Provides
    @Named("ok-2")
    HttpLoggingInterceptor httpLoggingInterceptor() {
        HttpLoggingInterceptor httpLoggingInterceptor = new
                HttpLoggingInterceptor(message -> Timber.i("deu certo"));
        return httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

    }



    @Provides
    @Named("ok-1")
    OkHttpClient provideOkHttpClient1(@Named("ok-2") HttpLoggingInterceptor httpLoggingInterceptor) {
        return new OkHttpClient.Builder()
                .connectTimeout(300, TimeUnit.SECONDS)
                .readTimeout(300, TimeUnit.SECONDS)
                .addInterceptor(httpLoggingInterceptor)
                .build();
    }


    @Provides
    Retrofit provideRetrofit(@Named("ok-1") OkHttpClient client, GsonConverterFactory converterFactory) {
        return new Retrofit.Builder()
                .baseUrl(mBaseUrl)
                .addConverterFactory(converterFactory)
                .client(client)
                .build();
    }




    @Provides
    public MarvelService marvelService(Retrofit retrofit){
        return retrofit.create(MarvelService.class);
    }


}
