package com.example.mvvm_clean__dagger_coroutines_retrofit_sample_project_updated.data.movie

import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

data class Movie(

    @PrimaryKey
    @SerializedName("id")
    val id: Int,
    @SerializedName("overview")
    val overview: String?,
    @SerializedName("poster_path")
    val posterPath: String?,
    @SerializedName("release_date")
    val releaseDate: String?,
    @SerializedName("title")
    val title: String?
)