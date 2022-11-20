package com.example.new_concepts.data.model.movie

import com.google.gson.annotations.SerializedName

data class MovieList(

    @SerializedName("results")
    val movies: List<Movie>
)