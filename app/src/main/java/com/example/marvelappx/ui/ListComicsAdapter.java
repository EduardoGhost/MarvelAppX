package com.example.marvelappx.ui;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.marvelappx.R;
import com.example.marvelappx.data.model.Comic;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observer;
import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;


public class ListComicsAdapter extends RecyclerView.Adapter<ListComicsAdapter.ListaComicsViewHolder>{

    private List<Comic> comics;

    private ItemComicClickListener itemComicClickListener;

    @Inject
    public ListComicsAdapter(ItemComicClickListener itemComicClickListener){
        this.itemComicClickListener = itemComicClickListener;
        comics = new ArrayList<>();
    }

    class ListaComicsViewHolder extends RecyclerView.ViewHolder{
        private TextView textTituloComic;
        private TextView textDescription;
        private TextView textPrice;
        private ImageView image;
        private Comic comic;
        private TextView text_rare;

        public ListaComicsViewHolder(View itemView) {
            super(itemView);

            textTituloComic = itemView.findViewById(R.id.text_titulo_comic);
            textDescription = itemView.findViewById(R.id.text_Descricao);
            textPrice = itemView.findViewById(R.id.text_Precos);
            image = itemView.findViewById(R.id.image);
            text_rare = itemView.findViewById(R.id.text_rare);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Observable<Comic> observavel = Observable.just(comic);
                    Observer<Comic> observador = new Observer<Comic>() {
                        @Override
                        public void onSubscribe(@NonNull Disposable d) {

                        }

                        @Override
                        public void onNext(@NonNull Comic comic) {
                            itemComicClickListener.itemComicClicado(comic);
                        }

                        @Override
                        public void onError(@NonNull Throwable e) {
                            e.printStackTrace();
                        Log.e("", String.valueOf("errou feio"));

                        }

                        @Override
                        public void onComplete() {

                        }
                    };
                    observavel.subscribe(observador);
//                    if(itemComicClickListener != null){
//
//                    }
                }
            });
    }

    public void bind(Comic comic){
            this.comic = comic;
        textTituloComic.setText(comic.getTitle());
        textDescription.setText(comic.getDescription());
        textPrice.setText("Preço :" + (comic.getPrices().get(0).getPrice()));

        Picasso.get().load(comic.getThumbnail().getPath() + "." + //imagem .extensão
            comic.getThumbnail().getExtension())
            .placeholder((R.drawable.ic_launcher_background))
            .error(android.R.drawable.btn_dialog)
                .into(image);
        if(comic.isRare()){
            text_rare.setText("Raro");

}}}

    @Override
    public ListaComicsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_comic, parent, false);
        return new ListaComicsViewHolder(view);
    }
    @Override
    public void onBindViewHolder(ListaComicsViewHolder holder, int position) {
        holder.bind(comics.get(position));
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

    public interface ItemComicClickListener{
        void itemComicClicado(Comic comic);
    }
}
