package com.example.eloyvitorio.retrofitpoc.data.network;

import com.example.eloyvitorio.retrofitpoc.data.network.response.Post;
import com.example.eloyvitorio.retrofitpoc.data.network.response.User;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface MyApiEndpointInterface {

    // Request method and URL specified in the annotation
    @GET("users")
    Call<List<User>> getUsersList();

    @GET("users/{limit}")
    Call<User> getUserListWithLimit(@Path("limit") String limit);

    @POST("posts")
    Call<Post> createNewPost(@Body Post post);
}
