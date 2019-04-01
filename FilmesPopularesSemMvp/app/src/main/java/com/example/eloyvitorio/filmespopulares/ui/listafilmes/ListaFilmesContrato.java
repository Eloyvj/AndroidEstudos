package com.example.eloyvitorio.filmespopulares.ui.listafilmes;

import com.example.eloyvitorio.filmespopulares.data.model.Filme;

import java.util.List;

public interface ListaFilmesContrato {

    interface ListaFilmesView {

        void mostraFilmes(List<Filme> filmes);

        void mostraErro();
    }

    interface ListaFilmesPresenter {

        void setView(ListaFilmesView view);

        void obtemFilmes();
    }
}
