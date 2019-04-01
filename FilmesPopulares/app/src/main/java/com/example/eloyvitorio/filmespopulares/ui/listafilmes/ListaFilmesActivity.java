package com.example.eloyvitorio.filmespopulares.ui.listafilmes;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.widget.Toast;

import com.example.eloyvitorio.filmespopulares.R;
import com.example.eloyvitorio.filmespopulares.data.model.Filme;
import com.example.eloyvitorio.filmespopulares.data.model.data.network.ApiService;
import com.example.eloyvitorio.filmespopulares.data.model.data.network.response.FilmesResult;
import com.example.eloyvitorio.filmespopulares.data.model.mapper.FilmeMapper;
import com.example.eloyvitorio.filmespopulares.ui.detalhesFilme.DetalhesFilmeActivity;

import java.util.Arrays;
import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ListaFilmesActivity extends AppCompatActivity
        implements ListaFilmesContrato.ListaFilmesView,
        ListaFilmesAdapter.ItemFilmeClickListener {

    private ListaFilmesAdapter filmesAdapter;
    ListaFilmesContrato.ListaFilmesPresenter presenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_filmes);

        configuraToolbar();

        configuraAdapter();

        presenter = new ListaFilmesPresenter(this);

        presenter.obtemFilmes();
    }

    private void configuraToolbar() {
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    private void configuraAdapter() {
        final RecyclerView recyclerFilmes = findViewById(R.id.recycler_filmes);

        filmesAdapter = new ListaFilmesAdapter(this);

        RecyclerView.LayoutManager gridLayoutMamager = new GridLayoutManager(this, 2);

        recyclerFilmes.setLayoutManager(gridLayoutMamager);
        recyclerFilmes.setAdapter(filmesAdapter);
    }

    @Override
    public void mostraFilmes(List<Filme> filmes) {
        filmesAdapter.setFilmes(filmes);
    }

    @Override
    public void mostraErro() {
        Toast.makeText(this, "Erro ao obter a lista de filmes.", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.destruirView();
    }

    @Override
    public void onItemFilmeClicado(Filme filme) {
        Intent intent = new Intent(this, DetalhesFilmeActivity.class);
        intent.putExtra(DetalhesFilmeActivity.EXTRA_FILME, filme);
        startActivity(intent);
    }
}
