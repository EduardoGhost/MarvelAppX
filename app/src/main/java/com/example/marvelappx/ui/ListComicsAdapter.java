package com.example.marvelappx.ui;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.marvelappx.R;
import com.example.marvelappx.data.model.Comic;
import com.example.marvelappx.data.network.response.ComicResponse;

import java.util.ArrayList;
import java.util.List;

public class ListComicsAdapter extends RecyclerView.Adapter<ListComicsAdapter.ListaComicsViewHolder>{

    private List<Comic> comics;

    public ListComicsAdapter(){
        comics = new ArrayList<>();
    }

    @NonNull
    @Override
    public ListaComicsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_comic, parent, false);
        return new ListaComicsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ListaComicsViewHolder holder, int position) {
        holder.textTituloComic.setText(comics.get(position).getTitle());
    }

    @Override
    public int getItemCount() {
        return (comics != null && comics.size() > 0) ? comics.size() : 0;
    }

    static class ListaComicsViewHolder extends RecyclerView.ViewHolder{

        private TextView textTituloComic;

        public ListaComicsViewHolder(@NonNull View itemView) {
            super(itemView);

            textTituloComic =itemView.findViewById(R.id.text_titulo_comic);


        }


    }public void setComics(List<Comic> comics){
        this.comics = comics;
        notifyDataSetChanged();
    }




}
