package com.example.marvelappx.ui;


import androidx.recyclerview.widget.RecyclerView;
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

    class ListaComicsViewHolder extends RecyclerView.ViewHolder{
        private TextView textTituloComic;
        private TextView textDescription;
        private TextView textPrice;
        private ImageView image;

        public ListaComicsViewHolder(View itemView) {
            super(itemView);
            textTituloComic = itemView.findViewById(R.id.text_titulo_comic);
            textDescription = itemView.findViewById(R.id.text_Descricao);
            textPrice = itemView.findViewById(R.id.text_Precos);
            image = itemView.findViewById(R.id.image);
        }
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
        holder.textDescription.setText(comic.getDescription());
        holder.textPrice.setText("U$: " + String.valueOf(comic.getPrices().get(0).getPrice()));
        Picasso.get().load(comic.getThumbnail().getPath() + "." + //imagem .extensão
                comic.getThumbnail().getExtension())

                .placeholder((R.drawable.ic_launcher_background))
                .error(android.R.drawable.btn_dialog)
                .into(holder.image);
    }
    @Override
    public int getItemCount() {
        //return comics.size();
        return (comics != null && comics.size() > 0) ? comics.size() : 0;
    }

    public void setComics(List<Comic> comics){
        this.comics = comics;
        notifyDataSetChanged();

    }
    
}
