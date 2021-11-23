package com.example.marvelappx.data.di.components;

import com.example.marvelappx.data.di.module.ApplicationModule;
import com.example.marvelappx.data.di.scope.PerActivity;
import com.example.marvelappx.data.network.MarvelService;

import javax.inject.Singleton;
import dagger.Component;

    @Singleton
    @PerActivity
    @Component(modules = ApplicationModule.class)
    public interface Componentes {

        MarvelService marvelService();


}
