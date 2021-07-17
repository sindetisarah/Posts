package com.example.myposts

import retrofit2.Call
import retrofit2.http.GET

interface ApiInterface {
    //GET Anotation with its EndPoint
    //Call back function to display the post after the Api get Request has been made
        @GET("posts")
        fun getPosts():Call<List<Posts>>
    }

