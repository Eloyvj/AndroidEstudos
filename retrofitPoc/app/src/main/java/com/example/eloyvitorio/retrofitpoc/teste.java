package com.example.eloyvitorio.retrofitpoc;

import com.example.eloyvitorio.retrofitpoc.data.network.ApiService;
import com.example.eloyvitorio.retrofitpoc.data.network.response.User;

import java.io.IOException;

import retrofit2.Call;

public class teste {


    public User blanb() throws IOException {

        Call<User> call = ApiService.getInstance().getUserListWithLimit("1");

        /*call.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                if(response.isSuccessful() && response.body() != null) {
                    User response1 = response.body();
                    int x = 0;
                }
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {

            }
        });*/

        return call.execute().body();


    }

}
