package com.example.new_concepts.presentation.tvshow

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.mvvm_clean__dagger_coroutines_retrofit_sample_project_updated.R
import com.example.mvvm_clean__dagger_coroutines_retrofit_sample_project_updated.databinding.ListItemBinding
import com.example.new_concepts.data.model.tvshow.TvShow

class TvShowAdapter: RecyclerView.Adapter<TvShowViewHolder>() {

    var tvShowList = ArrayList<TvShow>()

    fun setList(tvShows : List<TvShow>) {
        tvShowList.clear()
        tvShowList.addAll(tvShows)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TvShowViewHolder {
        val inflator = LayoutInflater.from(parent.context)
        val binding: ListItemBinding = DataBindingUtil.inflate(inflator, R.layout.list_item, parent, false)
        return TvShowViewHolder(binding)
    }

    override fun onBindViewHolder(holder: TvShowViewHolder, position: Int) {
        holder.bind(tvShowList[position])
    }

    override fun getItemCount(): Int {
        return tvShowList.size
    }
}

class TvShowViewHolder(val binding: ListItemBinding): RecyclerView.ViewHolder(binding.root){
    fun bind(tvShow: TvShow) {
        binding.titleTextview.text = tvShow.name
        binding.descriptionTextview.text = tvShow.overview
        val posterPath = "https://image.tmdb.org/t/p/w500" + tvShow.posterPath
        Glide.with(binding.image.context)
            .load(posterPath)
            .into(binding.image)

    }
}