package com.example.new_concepts.presentation.artist

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
import com.example.mvvm_clean__dagger_coroutines_retrofit_sample_project_updated.databinding.ActivityArtistBinding
import com.example.new_concepts.presentation.di.Injector
import javax.inject.Inject

class ArtistActivity : AppCompatActivity() {

    @Inject
    lateinit var factory: ArtistViewModelFactory
    private lateinit var binding: ActivityArtistBinding
    private lateinit var artistViewModel: ArtistViewModel
    private lateinit var adapter: ArtistAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_artist)
        (application as Injector).createArtistSubComponent()
            .inject(this)
        supportActionBar?.title = "Artists"
        artistViewModel = ViewModelProvider(this, factory)[ArtistViewModel::class.java]
        initRecyclerView()
    }

    private fun initRecyclerView() {
        binding.artistRecyclerview.layoutManager = LinearLayoutManager(this)
        adapter = ArtistAdapter()
        binding.artistRecyclerview.adapter = adapter
        displayPopularArtists()
    }

    private fun displayPopularArtists() {
        binding.artistProgressbar.visibility = View.VISIBLE
        val artists = artistViewModel.getArtists()
        artists.observe(this) {
            if (it != null) {
                if (it.isNotEmpty()) {
                    adapter.setList(it)
                    adapter.notifyDataSetChanged()
                    binding.artistProgressbar.visibility = View.GONE
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
                binding.artistProgressbar.visibility = View.VISIBLE
            }
        }
    }

    private fun updateArtists() {
        binding.artistProgressbar.visibility = View.VISIBLE
        val newArtists = artistViewModel.updateArtists()
        newArtists.observe(this) {
            if (it != null) {
                if (it.isNotEmpty()) {
                    adapter.setList(it)
                    adapter.notifyDataSetChanged()
                    binding.artistProgressbar.visibility = View.GONE
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
                binding.artistProgressbar.visibility = View.VISIBLE
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
                updateArtists()
                return true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

}