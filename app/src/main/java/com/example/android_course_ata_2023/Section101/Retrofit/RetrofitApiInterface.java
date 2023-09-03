package com.example.android_course_ata_2023.Section101.Retrofit;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface RetrofitApiInterface {

    @GET("posts/1")
    Call<Post> getFirstPost();

    @GET("posts")
    Call<List<Post>> getAllPosts();
}
