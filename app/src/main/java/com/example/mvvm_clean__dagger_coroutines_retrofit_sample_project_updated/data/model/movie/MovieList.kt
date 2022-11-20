package com.example.mvvm_clean__dagger_coroutines_retrofit_sample_project_updated.data.model.movie

import com.google.gson.annotations.SerializedName

data class MovieList(

    @SerializedName("results")
    val movies: List<Movie>
)