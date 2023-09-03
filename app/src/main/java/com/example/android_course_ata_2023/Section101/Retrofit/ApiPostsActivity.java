package com.example.android_course_ata_2023.Section101.Retrofit;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.example.android_course_ata_2023.R;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiPostsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_api_posts);

        String url = "https://jsonplaceholder.typicode.com/";

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                ;

        RetrofitApiInterface apiInterface = retrofit
                .create(RetrofitApiInterface.class);

       Call<Post> firstCall = apiInterface.getFirstPost();

       firstCall.enqueue(new Callback<Post>() {
           @Override
           public void onResponse(Call<Post> call, Response<Post> response) {
               Post p = response.body();
               Log.d("ApiTest", "onResponse: "+p.getTitle());
           }

           @Override
           public void onFailure(Call<Post> call, Throwable t) {
               Log.d("ApiTest", "onResponse: "+t.getMessage());
           }
       });

       Call<List<Post>> allPosts = apiInterface.getAllPosts();
       allPosts.enqueue(new Callback<List<Post>>() {
           @Override
           public void onResponse(Call<List<Post>> call, Response<List<Post>> response) {
               for (Post p:response.body()) {
                   Log.d("ApiTest", "onResponse: "+p);
               }

           }

           @Override
           public void onFailure(Call<List<Post>> call, Throwable t) {
               Log.d("ApiTest", "onResponse: "+t.getMessage());
           }
       });



    }
}