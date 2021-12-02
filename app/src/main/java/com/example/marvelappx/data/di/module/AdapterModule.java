package com.example.marvelappx.data.di.module;

import com.example.marvelappx.data.di.scope.ActivityScope;
import com.example.marvelappx.ui.ListComics;
import com.example.marvelappx.ui.ListComicsAdapter;
import dagger.Module;
import dagger.Provides;

@Module(includes = {ActivityContextModule.class})
public class AdapterModule {

    @Provides
    @ActivityScope
    public ListComicsAdapter getCoinList(ListComicsAdapter.ItemComicClickListener itemComicClickListener) {
        return new ListComicsAdapter(itemComicClickListener);
    }
//
    @Provides
    @ActivityScope
    public ListComicsAdapter.ItemComicClickListener getClickListener(ListComics listComics) {
        return listComics;
    }
}
