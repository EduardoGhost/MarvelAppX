package com.example.marvelappx.ui;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Build;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.marvelappx.R;
import com.example.marvelappx.data.model.Comic;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class ListComicsAdapter extends RecyclerView.Adapter<ListComicsAdapter.ListaComicsViewHolder>{

    private List<Comic> comics;

    public ListComicsAdapter(){
        comics = new ArrayList<>();
    }

    @Override
    public ListaComicsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_comic, parent, false);
        return new ListaComicsViewHolder(view);
    }


    @Override
    public void onBindViewHolder(ListaComicsViewHolder holder, int position) {
        Comic comic = comics.get(position);
        holder.textTituloComic.setText(comic.getTitle());
        //comics.get(position);
        //holder.textTituloComic.setText(comics.get(position).getTitle());

    }

    @Override
    public int getItemCount() {

        //return comics.size();

        return (comics != null && comics.size() > 0) ? comics.size() : 0;
    }

    class ListaComicsViewHolder extends RecyclerView.ViewHolder{

        TextView textTituloComic;
        ImageView imagemComic;


        public ListaComicsViewHolder(View itemView) {
            super(itemView);

            textTituloComic = itemView.findViewById(R.id.text_titulo_comic);
            //imagemComic = itemView.findViewById(R.id.imagem_comic);
        }


        public void bind(Comic comic){
           textTituloComic.setText(comic.getTitle());
           //Picasso.get().load(comic.getThumbnail()).into(imagemComic);
        }

    }public void setComics(List<Comic> comics){
        this.comics = comics;
        notifyDataSetChanged();

    }




}
