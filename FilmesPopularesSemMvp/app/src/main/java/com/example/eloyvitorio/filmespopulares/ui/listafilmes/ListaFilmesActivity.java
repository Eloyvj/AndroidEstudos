package com.example.eloyvitorio.filmespopulares.ui.listafilmes;

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

import java.util.Arrays;
import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ListaFilmesActivity extends AppCompatActivity {

    private RecyclerView recyclerFilmes;
    private ListaFilmesAdapter filmesAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_filmes);

        configuraToolbar();

        configuraAdapter();

        obtemFilmes();
    }

    private void configuraToolbar() {
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    private void configuraAdapter() {
        recyclerFilmes = findViewById(R.id.recycler_filmes);

        filmesAdapter = new ListaFilmesAdapter();

        RecyclerView.LayoutManager gridLayoutMamager = new GridLayoutManager(this, 2);

        recyclerFilmes.setLayoutManager(gridLayoutMamager);
        recyclerFilmes.setAdapter(filmesAdapter);
    }

    private void obtemFilmes() {
        ApiService.getInstance()
                .obterFilmesPopulares("5a436d513d8fcb4f4e4138c77c24ca2a")
                .enqueue(new Callback<FilmesResult>() {
                    @Override
                    public void onResponse(Call<FilmesResult> call, Response<FilmesResult> response) {
                        if (response.isSuccessful()) {
                            final List<Filme> listaFilmes = FilmeMapper
                                    .deResponseParaDominio(response.body().getResultadoFilmes());
                            filmesAdapter.setFilmes(listaFilmes);
                        } else {
                            //Tratar os codigos de resposta
                            mostraErro();
                        }
                    }

                    @Override
                    public void onFailure(Call<FilmesResult> call, Throwable t) {
                        mostraErro();
                    }
                });
    }

    private void mostraErro() {
        Toast.makeText(this, "Erro ao obter a lista de filmes.", Toast.LENGTH_SHORT).show();
    }
}
