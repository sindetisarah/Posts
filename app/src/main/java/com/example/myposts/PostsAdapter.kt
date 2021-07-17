package com.example.myposts

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import kotlin.coroutines.coroutineContext

//elevation
//margin

class PostsAdapter(var post_list: List<Posts>,var context: Context) : RecyclerView.Adapter<PostViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {

        var itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.post_list_item, parent, false)
        return PostViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        //Where actual Recyling happens
        //Fetch the current position
        //finding the current Post
        //we always convert an integer to a String to be able to display it in The Recycler view

        var currentPosts = post_list.get(position)
        holder.tvUserId.text = currentPosts.userId.toString()
        holder.tvId.text = currentPosts.id.toString()
        holder.tvTitle.text = currentPosts.title
        holder.tvBody.text = currentPosts.body
        //create an onClickEventListener
        holder.cvPosts.setOnClickListener {
            var intent=Intent(context,CommentsActivity::class.java)
            intent.putExtra("POST_ID",currentPosts.id)
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            context.startActivity(intent)



        }

    }

    override fun getItemCount(): Int {
        return post_list.size
    }

}

class PostViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {


    //here we cast the text views in the course list item
    var tvUserId = itemView.findViewById<TextView>(R.id.tvUserId)
    var tvId = itemView.findViewById<TextView>(R.id.tvId)
    var tvTitle = itemView.findViewById<TextView>(R.id.tvTitle)
    var tvBody = itemView.findViewById<TextView>(R.id.tvBody)


    //cast the Recycler card view here
    var cvPosts=itemView.findViewById<CardView>(R.id.cvPosts)

}