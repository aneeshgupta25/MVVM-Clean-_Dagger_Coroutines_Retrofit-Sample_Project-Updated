package com.example.new_concepts.data.model.tvshow

import com.google.gson.annotations.SerializedName

data class TvShowList(

    @SerializedName("results")
    val tvShows: List<TvShow>,

    )