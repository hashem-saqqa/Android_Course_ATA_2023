package com.example.android_course_ata_2023.Section101.Retrofit;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;

import com.example.android_course_ata_2023.R;
import com.example.android_course_ata_2023.databinding.ActivityApiPostsBinding;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiPostsActivity extends AppCompatActivity {


    ActivityApiPostsBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityApiPostsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.apiText.setMovementMethod(new ScrollingMovementMethod());

        String url = "https://jsonplaceholder.typicode.com/";

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        RetrofitApiInterface apiInterface = retrofit
                .create(RetrofitApiInterface.class);

//        List<Post> p = new ArrayList<>();
//        Map<String, Object> m = new HashMap<>();
//        Call<List<Post>> allPosts = apiInterface.getAllPosts();
//        allPosts.enqueue(new Callback<List<Post>>() {
//            @Override
//            public void onResponse(Call<List<Post>> call, Response<List<Post>> response) {
//                for (Post p : response.body()) {
//                    String text = "";
//                    text += "\nid: "+p.getId();
//                    text += "\nuser Id: "+p.getUserId();
//                    text += "\ntitle: "+p.getTitle();
//                    text += "\nbody: "+p.getBody();
//                    text += "\n\n**********************************";
//                    binding.apiText.append(text);
//
//                }
//
//            }
//
//            @Override
//            public void onFailure(Call<List<Post>> call, Throwable t) {
//                Log.d("ApiTest", "onResponse: " + t.getMessage());
//            }
//        });

//        HashMap<String,Object> hm = new HashMap<>();
//        hm.put("userId",4);
//        hm.put("_sort","id");
//        hm.put("_order","desc");
//        apiInterface.getPostsByUserId().enqueue(new Callback<List<Post>>() {
//            @Override
//            public void onResponse(Call<List<Post>> call, Response<List<Post>> response) {
//                for (Post p : response.body()) {
//
//                }
//
//            }
//
//            @Override
//            public void onFailure(Call<List<Post>> call, Throwable t) {
//
//            }
//        });
//        apiInterface.getUserById(1).enqueue(new Callback<User>() {
//            @Override
//            public void onResponse(Call<User> call, Response<User> response) {
//                User u = response.body();
//                binding.apiText.setText(u.toString());
//            }
//
//            @Override
//            public void onFailure(Call<User> call, Throwable t) {
//
//            }
//        });
//        apiInterface.getPhotoById(2).enqueue(new Callback<Photo>() {
//            @Override
//            public void onResponse(Call<Photo> call, Response<Photo> response) {
//                Photo p = response.body();
//                binding.apiText.setText(p.getTitle());
//                binding.apiText.append("\n\n"+response.code());
//
//                Picasso.get().load(p.getThumbnailUrl()).into(binding.adiPhoto);
//
//            }
//
//            @Override
//            public void onFailure(Call<Photo> call, Throwable t) {
//
//            }
//        });
        HashMap<String,Object> map = new HashMap<>();
        map.put("title","new Title");
        map.put("body","this is my first post");
        map.put("userId",3);

        apiInterface.addPost("new Title","this is my first post",4)
                .enqueue(new Callback<Post>() {
            @Override
            public void onResponse(Call<Post> call, Response<Post> response) {
                if (!response.isSuccessful()){
                    binding.apiText.setText("\n\n"+response.code());
                    return;
                }
                binding.apiText.setText(response.body().toString());
                binding.apiText.append("\n\n"+response.code());
            }

            @Override
            public void onFailure(Call<Post> call, Throwable t) {

            }
        });

    }
}