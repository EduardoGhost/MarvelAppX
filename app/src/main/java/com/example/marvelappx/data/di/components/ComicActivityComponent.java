package com.example.marvelappx.data.di.components;

import android.content.Context;

import com.example.marvelappx.data.di.module.AdapterModule;
import com.example.marvelappx.data.di.module.ComicActivityContext;
import com.example.marvelappx.data.di.module.ComicActivityMvpModule;
import com.example.marvelappx.data.di.scope.ActivityScope;
import com.example.marvelappx.ui.ListComics;
import dagger.Component;

@ActivityScope
@Component(modules = {AdapterModule.class, ComicActivityMvpModule.class},
        dependencies = ApplicationComponentes.class)
public interface ComicActivityComponent {

    @ComicActivityContext
    Context getContext();
    void injectMainActivity(ListComics listComics);
}
