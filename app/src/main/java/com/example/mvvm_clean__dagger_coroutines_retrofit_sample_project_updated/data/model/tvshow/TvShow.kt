package com.example.mvvm_clean__dagger_coroutines_retrofit_sample_project_updated.data.model.tvshow

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "popular_tvShows")
data class TvShow(

    @PrimaryKey
    @SerializedName("id")
    val id: Int,
    @SerializedName("first_air_date")
    val firstAirDate: String?,
    @SerializedName("name")
    val name: String?,
    @SerializedName("overview")
    val overview: String?,
    @SerializedName("poster_path")
    val posterPath: String?
)