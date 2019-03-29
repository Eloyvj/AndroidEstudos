package com.example.eloyvitorio.retrofitpoc.data.network;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiService {

    private static MyApiEndpointInterface INSTANCE;
    public static final String BASE_URL = "https://jsonplaceholder.typicode.com/";

    public static MyApiEndpointInterface getInstance() {
        if (INSTANCE == null) {
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            INSTANCE = retrofit.create(MyApiEndpointInterface.class);
        }

        return INSTANCE;
    }
}
