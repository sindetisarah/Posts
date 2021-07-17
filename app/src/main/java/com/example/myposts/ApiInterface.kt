package com.example.myposts

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiInterface {
    //GET Anotation with its EndPoint
    //Call back function to display the post after the Api get Request has been made
        @GET("posts")
        fun getPosts():Call<List<Posts>>

   //Get Annotation for a Single post by its Id
    @GET("posts/{postId}")
    fun getPost(@Path("postId")id:Int) :Call<Posts>

    @GET("posts/{postId}/comments")
    fun getComments(@Path("postId")id: Int):Call<List<Comments>>

    }


