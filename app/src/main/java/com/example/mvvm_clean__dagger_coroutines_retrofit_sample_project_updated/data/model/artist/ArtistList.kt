package com.example.mvvm_clean__dagger_coroutines_retrofit_sample_project_updated.data.model.artist

import com.google.gson.annotations.SerializedName


data class ArtistList(

    @SerializedName("results")
    val artists: List<Artist>

)