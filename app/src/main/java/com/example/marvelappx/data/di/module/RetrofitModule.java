package com.example.marvelappx.data.di.module;

import com.example.marvelappx.data.di.scope.ApplicationScope;
import com.example.marvelappx.data.network.MarvelService;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import java.util.concurrent.TimeUnit;
import javax.inject.Named;
import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import timber.log.Timber;

@Module(includes = ContextModule.class)
public class RetrofitModule {

    public String mBaseUrl = "https://gateway.marvel.com/v1/public/";

    @Provides
    @ApplicationScope
    public MarvelService marvelService(Retrofit retrofit){
        return retrofit.create(MarvelService.class);
    }

    @Provides
    @ApplicationScope
    GsonConverterFactory provideGsonConverterFactory() {
        return GsonConverterFactory.create();
    }

    @Provides
    @ApplicationScope
    @Named("ok-2")
    HttpLoggingInterceptor httpLoggingInterceptor() {
        HttpLoggingInterceptor httpLoggingInterceptor = new
                HttpLoggingInterceptor(message -> Timber.i("deu certo"));
        return httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

    }

    @Provides
    @ApplicationScope
    @Named("ok-1")
    OkHttpClient provideOkHttpClient1(@Named("ok-2") HttpLoggingInterceptor httpLoggingInterceptor) {
        return new OkHttpClient.Builder()
                .connectTimeout(300, TimeUnit.SECONDS)
                .readTimeout(300, TimeUnit.SECONDS)
                .addInterceptor(httpLoggingInterceptor)
                .build();
    }

    @Provides
    @ApplicationScope
    Retrofit provideRetrofit(@Named("ok-1") OkHttpClient client, GsonConverterFactory converterFactory) {
        return new Retrofit.Builder()
                .baseUrl(mBaseUrl)
                .addConverterFactory(converterFactory)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(client)
                .build();
    }




}
