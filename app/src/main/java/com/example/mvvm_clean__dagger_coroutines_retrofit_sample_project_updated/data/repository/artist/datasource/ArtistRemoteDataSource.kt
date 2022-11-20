package com.example.mvvm_clean__dagger_coroutines_retrofit_sample_project_updated.data.repository.artist.datasource

import com.example.mvvm_clean__dagger_coroutines_retrofit_sample_project_updated.data.model.artist.ArtistList
import retrofit2.Response

interface ArtistRemoteDataSource {
    suspend fun getArtists() : Response<ArtistList>
}