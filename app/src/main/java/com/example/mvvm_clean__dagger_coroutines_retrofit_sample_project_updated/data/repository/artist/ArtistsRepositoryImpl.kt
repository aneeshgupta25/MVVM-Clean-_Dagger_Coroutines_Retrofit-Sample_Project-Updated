package com.example.mvvm_clean__dagger_coroutines_retrofit_sample_project_updated.data.repository.artist

import com.example.mvvm_clean__dagger_coroutines_retrofit_sample_project_updated.data.model.artist.Artist
import com.example.mvvm_clean__dagger_coroutines_retrofit_sample_project_updated.domain.repository.ArtistsRepository

class ArtistsRepositoryImpl : ArtistsRepository {
    override suspend fun getArtists(): List<Artist>? {
        TODO("Not yet implemented")
    }

    override suspend fun updateArtists(): List<Artist>? {
        TODO("Not yet implemented")
    }
}