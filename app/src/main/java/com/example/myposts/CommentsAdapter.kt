package com.example.myposts

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


class CommentsAdapter( var comments_List:List<Comments>):RecyclerView.Adapter<CommentsViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CommentsViewHolder {
      var itemView= LayoutInflater.from(parent.context).inflate(R.layout.comments_list_item,parent,false)
        return CommentsViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: CommentsViewHolder, position: Int) {
        var currentComment=comments_List.get(position)
        holder.tvCommentName.text=currentComment.name
        holder.tvCommentBody.text=currentComment.body
        holder.tvCommentEmail.text=currentComment.email


    }

    override fun getItemCount(): Int {
        return comments_List.size


    }

}
class CommentsViewHolder(itemView:View):RecyclerView.ViewHolder(itemView){
    var tvCommentName=itemView.findViewById<TextView>(R.id.tvCommentName)
    var tvCommentEmail=itemView.findViewById<TextView>(R.id.tvCommentEmail)
    var tvCommentBody=itemView.findViewById<TextView>(R.id.tvCommentBody)


}