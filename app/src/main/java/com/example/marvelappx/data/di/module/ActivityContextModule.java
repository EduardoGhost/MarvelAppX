package com.example.marvelappx.data.di.module;

import android.content.Context;

import com.example.marvelappx.data.di.scope.ActivityScope;
import com.example.marvelappx.ui.ListComics;

import dagger.Module;
import dagger.Provides;

@Module
public class ActivityContextModule {
    private ListComics listComics;

    public Context context;

    public ActivityContextModule(ListComics listComics) {
        this.listComics = listComics;
        context = listComics;
    }

    @Provides
    @ActivityScope
    public ListComics getMainActivity() {
        return listComics;
    }

    @Provides
    @ActivityScope
    @ComicActivityContext
    public Context getContext() {
        return context;
    }

}
