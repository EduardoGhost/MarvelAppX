package com.example.marvelappx.data.di.module;

import com.example.marvelappx.data.di.scope.ActivityScope;
import com.example.marvelappx.mvp.Contrato;

import dagger.Module;
import dagger.Provides;

@Module
public class ComicActivityMvpModule {

        private final Contrato.ListaComicsView mView;

        public ComicActivityMvpModule(Contrato.ListaComicsView mView) {
            this.mView = mView;
        }

        @Provides
        @ActivityScope
        Contrato.ListaComicsView provideView() {
            return mView;
        }
}
