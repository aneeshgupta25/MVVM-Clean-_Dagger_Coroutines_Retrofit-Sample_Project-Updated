package com.example.new_concepts.data.repository.artist.datasource

import com.example.new_concepts.data.model.artist.Artist


interface ArtistCacheDataSource {
    suspend fun getArtistsFromCache() : List<Artist>
    suspend fun saveArtistsToCache(artists : List<Artist>)
}