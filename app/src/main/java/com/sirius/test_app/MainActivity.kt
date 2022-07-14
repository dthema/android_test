package com.sirius.test_app

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowInsets
import android.view.WindowInsetsController.BEHAVIOR_SHOW_TRANSIENT_BARS_BY_SWIPE
import android.widget.Button
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.databinding.BindingAdapter
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.sirius.test_app.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var categoriesAdapter: CategoriesAdapter
    private lateinit var commentsAdapter: CommentsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initRecyclers()
        onGettingData(DataModel())
    }

    fun initRecyclers() {
        categoriesAdapter = CategoriesAdapter()
        commentsAdapter = CommentsAdapter()
        binding.categoriesView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        binding.categoriesView.adapter = categoriesAdapter
        binding.commentsView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        binding.commentsView.adapter = commentsAdapter
    }

    fun onGettingData(newData: DataModel) {
        binding.data = newData
        categoriesAdapter.submitList(newData.tags)
        categoriesAdapter.notifyDataSetChanged()
        commentsAdapter.submitList(newData.reviews)
        commentsAdapter.notifyDataSetChanged()
    }
}

@BindingAdapter("imageUrl")
fun loadImage(view: ImageView, url: String?) {
    if (!url.isNullOrEmpty()) {
        Glide.with(view.context)
            .load(url)
            .apply(RequestOptions().error(R.drawable.ic_launcher_background))
            .into(view)
    }
}

@BindingAdapter("numberToText")
fun numberToText(view: TextView, number: Number?) {
    view.text = number?.toString()
}

@SuppressLint("SetTextI18n")
@BindingAdapter("textWithReviews")
fun addReviews(view: TextView, text: String?) {
    view.text = "$text Reviews"
}
