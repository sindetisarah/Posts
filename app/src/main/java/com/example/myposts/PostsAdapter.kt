package com.example.myposts

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
//elevation
//margin

class PostsAdapter(var post_list: List<Posts>) : RecyclerView.Adapter<postViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): postViewHolder {

        var itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.post_list_item, parent, false)
        return postViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: postViewHolder, position: Int) {
        //Where actual Recyling happens
        //Fetch the current position
        //finding the current Post
        //we always convert an integer to a String to be able to display it in The Recycler view

        var currentPosts = post_list.get(position)
        holder.tvUserId.text = currentPosts.userId.toString()
        holder.tvId.text = currentPosts.id.toString()
        holder.tvTitle.text = currentPosts.title
        holder.tvBody.text = currentPosts.body

    }

    override fun getItemCount(): Int {
        return post_list.size
    }

}

class postViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    //here we cast the text views in the course list item
    var tvUserId = itemView.findViewById<TextView>(R.id.tvUserId)
    var tvId = itemView.findViewById<TextView>(R.id.tvId)
    var tvTitle = itemView.findViewById<TextView>(R.id.tvTitle)
    var tvBody = itemView.findViewById<TextView>(R.id.tvBody)

}