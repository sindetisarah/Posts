package com.example.myposts

import retrofit2.Call
import retrofit2.http.GET

interface ApiInterface {
    //GET Anotation with its EndPoint
        @GET("posts")
        fun getPosts():Call<List<Posts>>
    }

