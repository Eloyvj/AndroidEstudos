package com.example.eloyvitorio.filmespopulares.data.model.data.network;

import com.example.eloyvitorio.filmespopulares.data.model.data.network.response.FilmesResult;

import okhttp3.Response;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface FilmesService {

    @GET("movie/popular")
    Call<FilmesResult> obterFilmesPopulares(@Query("api_key") String chaveApi);
}
