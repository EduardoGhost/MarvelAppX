package com.example.marvelappx.data.di.module;

import android.content.Context;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;

@Module
public class ContextModule {
    Context context;

    public ContextModule(Context context) {
        this.context = context;
    }

    @Named("application_context")
    @Provides
    public Context context(){
        return context.getApplicationContext();
    }
}
