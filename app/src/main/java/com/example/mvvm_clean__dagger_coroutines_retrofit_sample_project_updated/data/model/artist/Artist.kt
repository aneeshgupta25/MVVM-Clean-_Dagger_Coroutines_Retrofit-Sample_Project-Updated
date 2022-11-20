package com.example.mvvm_clean__dagger_coroutines_retrofit_sample_project_updated.data.model.artist

import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

data class Artist(

    @PrimaryKey
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String?,
    @SerializedName("popularity")
    val popularity: Double?,
    @SerializedName("profile_path")
    val profilePath: String?
)
