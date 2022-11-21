package com.example.new_concepts.presentation.movie

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mvvm_clean__dagger_coroutines_retrofit_sample_project_updated.R
import com.example.mvvm_clean__dagger_coroutines_retrofit_sample_project_updated.databinding.ActivityMovieBinding
import com.example.new_concepts.presentation.di.Injector
import javax.inject.Inject

class MovieActivity : AppCompatActivity() {

    @Inject
    lateinit var factory: MovieViewModelFactory
    private lateinit var binding: ActivityMovieBinding
    private lateinit var movieViewModel: MovieViewModel
    private lateinit var adapter: MovieAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_movie)
        (application as Injector).createMovieSubComponent()
            .inject(this)
        supportActionBar?.title = "Movies"
        movieViewModel = ViewModelProvider(this, factory)[MovieViewModel::class.java]
        initRecyclerView()
    }

    private fun initRecyclerView() {
        binding.movieRecyclerview.layoutManager = LinearLayoutManager(this)
        adapter = MovieAdapter()
        binding.movieRecyclerview.adapter = adapter
        displayPopularMovies()
    }

    private fun displayPopularMovies() {
        binding.movieProgressbar.visibility = View.VISIBLE
        val responseLiveData = movieViewModel.getMovies()
        responseLiveData.observe(this) {
            if (it != null) {
                Log.v("Aneesh", it.size.toString())
                if(it.isNotEmpty()) {
                    adapter.setList(it)
                    adapter.notifyDataSetChanged()
                    binding.movieProgressbar.visibility = View.GONE
                } else {
                    Toast.makeText(applicationContext, "Something went wrong!!!", Toast.LENGTH_SHORT).show()
                    finish()
                }
            } else {
                Toast.makeText(
                    applicationContext,
                    "No Data Available Right Now!!!",
                    Toast.LENGTH_SHORT
                ).show()
                binding.movieProgressbar.visibility = View.VISIBLE
            }
        }
    }

    override fun onCreateOptionsMenu(menu : Menu?): Boolean{
        val inflator: MenuInflater = menuInflater
        inflator.inflate(R.menu.update, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when(item.itemId) {
            R.id.action_update -> {
                updateMovies()
                true
            } else -> super.onOptionsItemSelected(item)
        }
    }

    private fun updateMovies() {
        binding.movieProgressbar.visibility = View.VISIBLE
        val response = movieViewModel.updateMovies()
        response.observe(this) {
            if (it != null) {
                if(it.isNotEmpty()) {
                    adapter.setList(it)
                    adapter.notifyDataSetChanged()
                    binding.movieProgressbar.visibility = View.GONE
                    Toast.makeText(applicationContext, "List has been updated...", Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(applicationContext, "Something went wrong!!!", Toast.LENGTH_SHORT).show()
                }
            } else {
                Toast.makeText(
                    applicationContext,
                    "Can't update right now :(",
                    Toast.LENGTH_SHORT
                ).show()
                binding.movieProgressbar.visibility = View.VISIBLE
            }
        }
    }
}