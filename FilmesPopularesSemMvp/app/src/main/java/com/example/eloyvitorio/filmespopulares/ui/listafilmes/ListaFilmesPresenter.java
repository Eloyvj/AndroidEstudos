package com.example.eloyvitorio.filmespopulares.ui.listafilmes;

import com.example.eloyvitorio.filmespopulares.data.model.Filme;
import com.example.eloyvitorio.filmespopulares.data.model.data.network.ApiService;
import com.example.eloyvitorio.filmespopulares.data.model.data.network.response.FilmesResult;
import com.example.eloyvitorio.filmespopulares.data.model.mapper.FilmeMapper;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ListaFilmesPresenter implements ListaFilmesContrato.ListaFilmesPresenter{

    private ListaFilmesContrato.ListaFilmesView view;

    @Override
    public void setView(ListaFilmesContrato.ListaFilmesView view) {
        this.view = view;
    }

    @Override
    public void obtemFilmes() {

    }
}

