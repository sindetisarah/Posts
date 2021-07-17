package com.example.myposts

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CommentsActivity : AppCompatActivity() {
    var postId=0
    lateinit var tvPostTitle:TextView
    lateinit var tvPostBody:TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_comments)

        postId=intent.getIntExtra("POST_ID",0)

        getPost()
        castViews()
        getComments()

    }
    fun castViews(){
        //casting my views

        tvPostTitle=findViewById(R.id.tvPostTitle)

        tvPostBody=findViewById(R.id.tvPostBody)

    }
    fun getPost(){
        if(postId==0){
            Toast.makeText(baseContext,"Post not found",Toast.LENGTH_SHORT).show()
            finish()
        }
        val apiClient = ApiClient.buildApiClient(ApiInterface::class.java)
        val request =  apiClient.getPost(postId)
        request.enqueue(object:Callback<Posts>{
            override fun onResponse(call: Call<Posts>, response: Response<Posts>) {
                if(response.isSuccessful){
                    var post=response.body()
                    tvPostTitle.text=post?.title
                    tvPostBody.text=post?.body
                }

            }

            override fun onFailure(call: Call<Posts>, t: Throwable) {

               Toast.makeText(baseContext,t.message,Toast.LENGTH_SHORT).show()
            }

        })


    }
    fun getComments(){
        var rvComments=findViewById<RecyclerView>(R.id.rvComments)
        val retrofit=ApiClient.buildApiClient(ApiInterface::class.java)
        val request=retrofit.getComments(postId)
        request.enqueue(object : Callback<List<Comments>?> {
            override fun onResponse(call: Call<List<Comments>?>, response: Response<List<Comments>?>) {
           var comments=response.body()!!
               var commentsAdapter=CommentsAdapter(comments)
                rvComments.adapter=commentsAdapter
                rvComments.layoutManager=LinearLayoutManager(baseContext)

            }

            override fun onFailure(call: Call<List<Comments>?>, t: Throwable) {
                Toast.makeText(baseContext,t.message,Toast.LENGTH_SHORT).show()
            }
        })

            }



    }





