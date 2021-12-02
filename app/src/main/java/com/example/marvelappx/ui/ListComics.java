package com.example.marvelappx.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;
import com.example.marvelappx.R;
import com.example.marvelappx.data.di.Application.MyApplication;
import com.example.marvelappx.data.di.components.ApplicationComponentes;
import com.example.marvelappx.data.di.components.ComicActivityComponent;
import com.example.marvelappx.data.di.components.DaggerComicActivityComponent;
import com.example.marvelappx.data.di.module.ActivityContextModule;
import com.example.marvelappx.data.di.module.ApplicationContexto;
import com.example.marvelappx.data.di.module.ComicActivityContext;
import com.example.marvelappx.data.di.module.ComicActivityMvpModule;
import com.example.marvelappx.data.model.Comic;
import com.example.marvelappx.mvp.Contrato;
import com.example.marvelappx.mvp.Presenter;
import java.util.List;
import javax.inject.Inject;

public class ListComics extends AppCompatActivity implements Contrato.ListaComicsView,
        ListComicsAdapter.ItemComicClickListener {


    ComicActivityComponent comicActivityComponent;

    @Inject
    public ListComicsAdapter Adapter;

    @Inject
    @ApplicationContexto
    public Context mContext;

    @Inject
    @ComicActivityContext
    public Context activityContext;

    @Inject
    Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_comics);

        ApplicationComponentes applicationComponentes =
                MyApplication.get(this).getApplicationComponent();


        comicActivityComponent = DaggerComicActivityComponent.builder()
                .activityContextModule(new ActivityContextModule(this))
                .comicActivityMvpModule(new ComicActivityMvpModule(this))
                .applicationComponentes(applicationComponentes)
                .build();

        comicActivityComponent.injectMainActivity(this);

        presenter.obterComic();
        //presenter = new Presenter(this);

        configAdapter();

        }

        private void configAdapter(){
        RecyclerView recyclerComics = findViewById(R.id.recycler_comics);
        Adapter = new ListComicsAdapter(this);
        RecyclerView.LayoutManager linearLayoutManager = new LinearLayoutManager(ListComics.this);
        recyclerComics.setLayoutManager(linearLayoutManager);
        recyclerComics.setAdapter(Adapter);

    }
    @Override
    public void exibirComics(List<Comic> comics) {
        Adapter.setComics(comics);
    }


    @Override
    public void mostrarErro(){
        Toast.makeText(ListComics.this, "Não rodou!", Toast.LENGTH_SHORT).show();

    }
    @Override
    protected void onDestroy(){
        super.onDestroy();
        presenter.destruirView();
    }

    @Override
    public void itemComicClicado(Comic comic) {
        Intent intent = new Intent(ListComics.this, DetalhesComics.class);
        intent.putExtra("key", comic);
        startActivity(intent);

    }

}
