package com.example.myposts

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        getPosts()
    }
    fun getPosts(){
        //make Retrofit Builder Object
        var rvPosts=findViewById<RecyclerView>(R.id.rvPosts)
        val retrofit = ApiClient.buildApiClient(ApiInterface::class.java)



        val request = retrofit.getPosts()
        //enque function triggers the call and makes it on a separate thread
        request.enqueue(object : Callback<List<Posts>?> {
            override fun onResponse(call: Call<List<Posts>?>, response: Response<List<Posts>?>) {
                if (response.isSuccessful){
                    //? is null and is used when the server has lend no request
                    var posts=response.body()!!
                    var postsAdapter=PostsAdapter(posts,baseContext)
                    rvPosts.adapter=postsAdapter
                    rvPosts.layoutManager=LinearLayoutManager(baseContext)
                }
            }

            override fun onFailure(call: Call<List<Posts>?>, t: Throwable) {
               // Throwable is an object that holds the error
                //Read on suspend functions
                Toast.makeText(baseContext,t.message,Toast.LENGTH_SHORT).show()

            }
        })




    }
}

