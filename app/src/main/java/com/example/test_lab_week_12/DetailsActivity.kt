package com.example.test_lab_week_12

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide

class DetailsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)

        supportActionBar?.title = "Movie Details"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val title = intent.getStringExtra("movie_title")
        val overview = intent.getStringExtra("movie_overview")
        val posterPath = intent.getStringExtra("movie_poster")
        val releaseDate = intent.getStringExtra("movie_release_date")

        val titleTextView: TextView = findViewById(R.id.detail_title)
        val dateTextView: TextView = findViewById(R.id.detail_date)
        val overviewTextView: TextView = findViewById(R.id.detail_overview)
        val posterImageView: ImageView = findViewById(R.id.detail_poster)

        titleTextView.text = title
        dateTextView.text = releaseDate
        overviewTextView.text = overview

        if (posterPath != null) {
            Glide.with(this)
                .load("https://image.tmdb.org/t/p/w500$posterPath")
                .into(posterImageView)
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}