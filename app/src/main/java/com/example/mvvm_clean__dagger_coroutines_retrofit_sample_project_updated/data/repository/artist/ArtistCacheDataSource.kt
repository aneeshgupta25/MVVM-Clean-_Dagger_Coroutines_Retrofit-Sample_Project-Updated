package com.example.mvvm_clean__dagger_coroutines_retrofit_sample_project_updated.data.repository.artist

import com.example.mvvm_clean__dagger_coroutines_retrofit_sample_project_updated.data.model.artist.Artist


interface ArtistCacheDataSource {
    suspend fun getArtistsFromCache() : List<Artist>
    suspend fun saveArtistsToCache(artists : List<Artist>)
}