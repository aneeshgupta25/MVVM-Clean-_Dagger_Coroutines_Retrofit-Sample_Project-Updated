package com.example.new_concepts.presentation.artist

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.mvvm_clean__dagger_coroutines_retrofit_sample_project_updated.R
import com.example.mvvm_clean__dagger_coroutines_retrofit_sample_project_updated.databinding.ListItemBinding
import com.example.new_concepts.data.model.artist.Artist

class ArtistAdapter: RecyclerView.Adapter<ArtistViewHolder>() {

    private var artistsList = ArrayList<Artist>()

    fun setList(artists : List<Artist>){
        artistsList.clear()
        artistsList.addAll(artists)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArtistViewHolder {
        val inflator = LayoutInflater.from(parent.context)
        return ArtistViewHolder(DataBindingUtil.inflate(inflator, R.layout.list_item, parent, false))
    }

    override fun onBindViewHolder(holder: ArtistViewHolder, position: Int) {
        holder.bind(artistsList[position])
    }

    override fun getItemCount(): Int {
        return artistsList.size
    }
}

class ArtistViewHolder(val binding: ListItemBinding): RecyclerView.ViewHolder(binding.root) {
    fun bind(artist: Artist) {
        binding.titleTextview.text = artist.name
        binding.descriptionTextview.text = artist.popularity.toString()
        val posterUrl = "\"https://image.tmdb.org/t/p/w500\"" + artist.profilePath
        Glide.with(binding.image.context)
            .load(posterUrl)
            .into(binding.image)
    }
}