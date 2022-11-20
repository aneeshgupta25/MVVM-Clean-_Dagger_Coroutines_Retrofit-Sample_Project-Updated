package com.example.mvvm_clean__dagger_coroutines_retrofit_sample_project_updated.domain.repository

import com.example.mvvm_clean__dagger_coroutines_retrofit_sample_project_updated.data.model.artist.Artist

interface ArtistsRepository {
    suspend fun getArtists() : List<Artist>?
    suspend fun updateArtists() : List<Artist>?
}