package com.example.book_search_kotlin.view

import android.os.Bundle
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.example.book_search_kotlin.controller.ImageSharing
import com.example.book_search_kotlin.R

class BookDetailsActivity : AppCompatActivity(R.layout.activity_book_details) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val titleMain: TextView = findViewById(R.id.titleMain)
        val publisher: TextView = findViewById(R.id.detailPublisher)
        val pageNo: TextView = findViewById(R.id.pageNo)
        val bookCoverImageView: ImageView = findViewById(R.id.bookCoverImageView)
        val title: TextView = findViewById(R.id.title)
        val imageShareButton: ImageButton = findViewById(R.id.imageShareButton)
        val authorMain: TextView = findViewById(R.id.detailAuthor)

        title.text = intent.getStringExtra("title")
        titleMain.text = intent.getStringExtra("title")
        publisher.text = intent.getStringExtra("publisher")
        pageNo.text = intent.getStringExtra("pageNo")
        authorMain.text = intent.getStringExtra("author")

        Glide.with(this)
            .load(intent.getStringExtra("imageUrl"))
            .placeholder(R.drawable.placeholder_image)
            .error(R.drawable.error)
            .into(bookCoverImageView)

        imageShareButton.setOnClickListener {
            val bitmap = ImageSharing(this@BookDetailsActivity, bookCoverImageView)
            bitmap.getBitmapUrl(intent.getStringExtra("title").orEmpty())


        }


    }
}