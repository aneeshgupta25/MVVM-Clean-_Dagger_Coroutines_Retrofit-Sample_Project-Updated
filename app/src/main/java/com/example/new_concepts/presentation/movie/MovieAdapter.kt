package com.example.new_concepts.presentation.movie

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.mvvm_clean__dagger_coroutines_retrofit_sample_project_updated.R
import com.example.mvvm_clean__dagger_coroutines_retrofit_sample_project_updated.databinding.ListItemBinding
import com.example.new_concepts.data.model.movie.Movie

class MovieAdapter : RecyclerView.Adapter<MovieViewHolder>() {

    private var movieList = ArrayList<Movie>()

    fun setList(movies : List<Movie>) {
        movieList.clear()
        movieList.addAll(movies)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding: ListItemBinding = DataBindingUtil.inflate(layoutInflater, R.layout.list_item, parent, false)
        return MovieViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val movie = movieList[position]
        holder.bind(movie)
    }

    override fun getItemCount(): Int {
        return movieList.size
    }

}

class MovieViewHolder(private val binding: ListItemBinding) : RecyclerView.ViewHolder(binding.root){
    fun bind(movie: Movie) {
        binding.titleTextview.text = movie.title
        binding.descriptionTextview.text = movie.overview
        val posterUrl = "https://image.tmdb.org/t/p/w500" + movie.posterPath
        Glide.with(binding.image.context)
            .load(posterUrl)
            .into(binding.image)
    }
}