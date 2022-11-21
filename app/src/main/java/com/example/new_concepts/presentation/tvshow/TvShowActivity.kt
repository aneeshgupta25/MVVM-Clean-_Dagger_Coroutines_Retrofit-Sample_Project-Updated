package com.example.new_concepts.presentation.tvshow

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mvvm_clean__dagger_coroutines_retrofit_sample_project_updated.R
import com.example.mvvm_clean__dagger_coroutines_retrofit_sample_project_updated.databinding.ActivityTvShowBinding
import com.example.new_concepts.presentation.di.Injector
import javax.inject.Inject

class TvShowActivity : AppCompatActivity() {
    @Inject
    lateinit var factory: TvShowViewModelFactory
    private lateinit var binding: ActivityTvShowBinding
    private lateinit var viewmodel: TvShowViewModel
    private lateinit var adapter: TvShowAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_tv_show)

        (application as Injector).createTvShowSubComponent()
            .inject(this)
        supportActionBar?.title = "Tv Shows"
        viewmodel = ViewModelProvider(this, factory)[TvShowViewModel::class.java]
        initRecyclerView()
    }

    fun initRecyclerView() {
        binding.tvshowRecyclerview.layoutManager = LinearLayoutManager(applicationContext)
        adapter = TvShowAdapter()
        binding.tvshowRecyclerview.adapter = adapter
        displayPopularTvShows()
    }

    private fun displayPopularTvShows() {
        binding.tvshowProgressbar.visibility = View.VISIBLE
        val artists = viewmodel.getTvShows()
        artists.observe(this) {
            if (it != null) {
                if (it.isNotEmpty()) {
                    adapter.setList(it)
                    adapter.notifyDataSetChanged()
                    binding.tvshowProgressbar.visibility = View.GONE
                } else {
                    Toast.makeText(
                        applicationContext,
                        "Something went wrong!!!",
                        Toast.LENGTH_SHORT
                    ).show()
                    finish()
                }
            } else {
                Toast.makeText(
                    applicationContext,
                    "No Data Available Right Now!!!",
                    Toast.LENGTH_SHORT
                ).show()
                binding.tvshowProgressbar.visibility = View.VISIBLE
            }
        }
    }

    private fun updateTvShows() {
        binding.tvshowProgressbar.visibility = View.VISIBLE
        val newArtists = viewmodel.updateTvShows()
        newArtists.observe(this) {
            if (it != null) {
                if (it.isNotEmpty()) {
                    adapter.setList(it)
                    adapter.notifyDataSetChanged()
                    binding.tvshowProgressbar.visibility = View.GONE
                    Toast.makeText(
                        applicationContext,
                        "List has been updated...",
                        Toast.LENGTH_SHORT
                    ).show()
                } else {
                    Toast.makeText(
                        applicationContext,
                        "Something went wrong!!!",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            } else {
                Toast.makeText(
                    applicationContext,
                    "Can't Update right now!!",
                    Toast.LENGTH_SHORT
                ).show()
                binding.tvshowProgressbar.visibility = View.VISIBLE
            }
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflator: MenuInflater = menuInflater
        inflator.inflate(R.menu.update, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_update -> {
                updateTvShows()
                return true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}