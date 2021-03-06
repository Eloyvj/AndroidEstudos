package com.example.eloyvitorio.filmespopulares.ui.listafilmes;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.eloyvitorio.filmespopulares.R;
import com.example.eloyvitorio.filmespopulares.data.model.Filme;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class ListaFilmesAdapter extends RecyclerView.Adapter<ListaFilmesAdapter.ListaFilmesViewHolder> {

    private List<Filme> filmes;

    public ListaFilmesAdapter() {
        filmes = new ArrayList<>();
    }

    @NonNull
    @Override
    public ListaFilmesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_filme, parent, false);

        return new ListaFilmesViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ListaFilmesViewHolder holder, int position) {
        holder.bind(filmes.get(position));
        holder.textTituloFilme.setText(filmes.get(position).getTitulo());

    }

    @Override
    public int getItemCount() {
        return (filmes != null && filmes.size() > 0) ? filmes.size() : 0;
    }

    static class ListaFilmesViewHolder extends RecyclerView.ViewHolder {

        private TextView textTituloFilme;
        private ImageView imagePosterFilme;

        public ListaFilmesViewHolder(@NonNull View itemView) {
            super(itemView);

            textTituloFilme = itemView.findViewById(R.id.text_titulo_filme);
            imagePosterFilme = itemView.findViewById(R.id.image_poster_filme);
        }

        public void bind(Filme filme) {
            textTituloFilme.setText(filme.getTitulo());
            Picasso.get().load("https://image.tmdb.org/t/p/w342/"
                    + filme.getCaminhoPoster()).into(imagePosterFilme);
        }

    }

    public void setFilmes(List<Filme> filmes) {
        this.filmes = filmes;
        notifyDataSetChanged();
    }

}
