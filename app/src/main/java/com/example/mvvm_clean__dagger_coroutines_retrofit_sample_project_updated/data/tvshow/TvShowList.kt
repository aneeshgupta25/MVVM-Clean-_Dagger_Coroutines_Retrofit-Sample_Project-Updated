package com.example.mvvm_clean__dagger_coroutines_retrofit_sample_project_updated.data.tvshow

import com.google.gson.annotations.SerializedName

data class TvShowList(

    @SerializedName("results")
    val tvShows: List<TvShow>,

    )