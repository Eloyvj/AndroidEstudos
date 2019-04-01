package com.example.eloyvitorio.filmespopulares.data.model.mapper;

import com.example.eloyvitorio.filmespopulares.data.model.Filme;
import com.example.eloyvitorio.filmespopulares.data.model.data.network.response.FilmeResponse;

import java.util.ArrayList;
import java.util.List;

public class FilmeMapper {

    public static List<Filme> deResponseParaDominio(List<FilmeResponse> listaFilmeResponse) {
        List<Filme> listaFilmes = new ArrayList<>();
        for (FilmeResponse filmeResponse : listaFilmeResponse) {
            final Filme filme = new Filme(filmeResponse.getTituloOriginal(), filmeResponse.getCaminhoPoster());
            listaFilmes.add(filme);
        }

        return listaFilmes;
    }
}
