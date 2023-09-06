package com.example.android_course_ata_2023.Section101.Retrofit;

import java.util.HashMap;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.Field;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.PATCH;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;

public interface RetrofitApiInterface {

    @GET("posts/{id}")
    Call<Post> getPostById(@Path("id") int id);

    @GET("posts")
    Call<List<Post>> getAllPosts();

    // https://jsonplaceholder.typicode.com/posts?userId=4&_sort=id&_order=desc
    @GET("posts")
    Call<List<Post>> getPostsByUserId(@QueryMap HashMap<String, Object> map);

    @GET("users/{id}")
    Call<User> getUserById(@Path("id") int id);

    @GET("photos/{id}")
    Call<Photo> getPhotoById(@Path("id") int id);

    @FormUrlEncoded
    @POST("posts")
    Call<Post> addPost(@Field("title") String title,
                       @Field("body") String content,
                       @Field("userId") int id
    );

    @FormUrlEncoded
    @POST("posts")
    Call<Post> addPost2(@FieldMap HashMap<String, Object> map);

    @DELETE("posts/{id}")
    Call<Post> deletePost(@Path("id") int id);
    @PUT("posts/{id}")
    Call<Post> putPost(@Path("id") int id, @Body Post post);
    @PATCH("posts/{id}")
    Call<Post> patchPost(@Path("id") int id , @Body Post post);
}
