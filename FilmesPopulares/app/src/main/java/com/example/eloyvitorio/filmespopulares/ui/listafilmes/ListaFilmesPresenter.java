package com.example.eloyvitorio.filmespopulares.ui.listafilmes;

import com.example.eloyvitorio.filmespopulares.data.model.Filme;
import com.example.eloyvitorio.filmespopulares.data.model.data.network.ApiService;
import com.example.eloyvitorio.filmespopulares.data.model.data.network.response.FilmesResult;
import com.example.eloyvitorio.filmespopulares.data.model.mapper.FilmeMapper;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ListaFilmesPresenter implements ListaFilmesContrato.ListaFilmesPresenter {

    private ListaFilmesContrato.ListaFilmesView view;

    public ListaFilmesPresenter(ListaFilmesContrato.ListaFilmesView view) {
        this.view = view;
    }

    @Override
    public void setView(ListaFilmesContrato.ListaFilmesView view) {
        this.view = view;
    }

    @Override
    public void obtemFilmes() {
        ApiService.getInstance()
                .obterFilmesPopulares("5a436d513d8fcb4f4e4138c77c24ca2a")
                .enqueue(new Callback<FilmesResult>() {
                    @Override
                    public void onResponse(Call<FilmesResult> call, Response<FilmesResult> response) {
                        if (response.isSuccessful()) {
                            final List<Filme> listaFilmes = FilmeMapper
                                    .deResponseParaDominio(response.body().getResultadoFilmes());
                            view.mostraFilmes(listaFilmes);
                        } else {
                            //Tratar os codigos de resposta
                            view.mostraErro();
                        }
                    }

                    @Override
                    public void onFailure(Call<FilmesResult> call, Throwable t) {
                        view.mostraErro();
                    }
                });
    }

    @Override
    public void destruirView() {
        this.view = null;
    }
}

