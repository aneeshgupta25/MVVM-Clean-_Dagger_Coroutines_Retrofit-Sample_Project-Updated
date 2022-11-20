package com.example.new_concepts.presentation

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.mvvm_clean__dagger_coroutines_retrofit_sample_project_updated.R
import com.example.mvvm_clean__dagger_coroutines_retrofit_sample_project_updated.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {
    private lateinit var binding: ActivityHomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_home)
        binding.movieButton.setOnClickListener{
            val intent = Intent(this, MovieActivity::class.java)
            startActivity(intent)
        }
        binding.artistButton.setOnClickListener{
            val intent = Intent(this, ArtistActivity::class.java)
            startActivity(intent)
        }
        binding.tvShowButton.setOnClickListener{
            val intent = Intent(this, TvShowActivity::class.java)
            startActivity(intent)
        }
    }
}