package com.sirius.test_app

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView

class CategoriesAdapter : ListAdapter<String, CategoriesAdapter.CategoryHolder>(DiffCallback) {

    inner class CategoryHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val categoryField = itemView.findViewById<TextView>(R.id.categoryName)

        fun bind(category: String) {
            categoryField.text = category
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryHolder {
        val itemView =
            LayoutInflater.from(parent.context)
                .inflate(R.layout.category_item, parent, false)
        return CategoryHolder(itemView)
    }

    override fun onBindViewHolder(holder: CategoryHolder, position: Int) {
        val category = getItem(position)
        holder.bind(category)
    }

    object DiffCallback : DiffUtil.ItemCallback<String>() {
        override fun areItemsTheSame(oldItem: String, newItem: String): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: String, newItem: String): Boolean {
            return oldItem == newItem
        }
    }

}