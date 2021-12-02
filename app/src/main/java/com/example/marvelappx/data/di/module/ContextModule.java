package com.example.marvelappx.data.di.module;

import android.content.Context;
import com.example.marvelappx.data.di.scope.ApplicationScope;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;

@Module
public class ContextModule {
    Context context;

    public ContextModule(Context context) {
        this.context = context;
    }
    @Provides
    @ApplicationScope
    @ApplicationContexto
    public Context context() {
        return context;
    }


}
