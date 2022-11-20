package com.example.mvvm_clean__dagger_coroutines_retrofit_sample_project_updated.data.repository.artist

import com.example.mvvm_clean__dagger_coroutines_retrofit_sample_project_updated.data.model.artist.Artist

interface ArtistLocalDataSource {
    suspend fun getArtistsFromDB() : List<Artist>
    suspend fun saveArtistsToDB(artists : List<Artist>)
    suspend fun clearAll()
}