package com.sirius.test_app

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView

class CommentsAdapter : ListAdapter<ReviewModel, CommentsAdapter.CommentHolder>(DiffCallback) {

    inner class CommentHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val message = itemView.findViewById<TextView>(R.id.commentText)
        private val name = itemView.findViewById<TextView>(R.id.commentName)
        private val date = itemView.findViewById<TextView>(R.id.commentDate)
        private val avatar = itemView.findViewById<ImageView>(R.id.avatarImage)

        fun bind(comment: ReviewModel) {
            message.text = comment.message
            name.text = comment.userName
            date.text = comment.date
            loadImage(avatar, comment.userImage)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CommentHolder {
        val itemView =
            LayoutInflater.from(parent.context)
                .inflate(R.layout.comment_item, parent, false)
        return CommentHolder(itemView)
    }

    override fun onBindViewHolder(holder: CommentHolder, position: Int) {
        val comment = getItem(position)
        holder.bind(comment)
    }

    object DiffCallback : DiffUtil.ItemCallback<ReviewModel>() {
        override fun areItemsTheSame(oldItem: ReviewModel, newItem: ReviewModel): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: ReviewModel, newItem: ReviewModel): Boolean {
            return oldItem == newItem
        }
    }
}