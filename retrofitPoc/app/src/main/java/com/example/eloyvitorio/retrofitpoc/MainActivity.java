package com.example.eloyvitorio.retrofitpoc;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.eloyvitorio.retrofitpoc.data.network.ApiService;
import com.example.eloyvitorio.retrofitpoc.data.network.response.Post;
import com.example.eloyvitorio.retrofitpoc.data.network.response.User;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//         Call api methods
        userListWithLimit("1");
//        userListComplete();
//        addNewPost();

    }


    private void userListWithLimit(String limit) {
        Call<User> call = ApiService.getInstance().getUserListWithLimit("1");
        call.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                if(response.isSuccessful() && response.body() != null) {
                    String nameTest = response.body().getName();
                    String breakPointHere = "eloy";
                }
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {

            }
        });
    }

    private void userListComplete() {
        Call<List<User>> call = ApiService.getInstance().getUsersList();
        call.enqueue(new Callback<List<User>>() {
            @Override
            public void onResponse(Call<List<User>> call, Response<List<User>> response) {
                if(response.isSuccessful() && response.body() != null) {
                    String nameTest = response.body().get(0).getName();
                    String breakPointHere = "eloy";
                }
            }

            @Override
            public void onFailure(Call<List<User>> call, Throwable t) {

            }
        });
    }

    private void addNewPost() {
        int userId = 1;
        String title = "reprehenderit optio excepturi yole eloy";
        String postBody = "It is a long established fact that a reader will be distracted by the " +
                "readable content of a page when looking at its layout. The point of using " +
                "Lorem Ipsum is that it has a more-or-less normal distribution of letters, as " +
                "opposed to using 'Content here, content here', making it look like " +
                "readable English.";

        Post post = new Post(userId, title, postBody);
        Call call = ApiService.getInstance().createNewPost(post);
        call.enqueue(new Callback<Post>() {
            @Override
            public void onResponse(Call<Post> call, Response<Post> response) {
                if(response.isSuccessful() && response.body() != null) {
                    String titleTest = response.body().getTitle();
                    String breakPointHere = "eloy";
                }
            }

            @Override
            public void onFailure(Call<Post> call, Throwable t) {

            }
        });
    }
}
