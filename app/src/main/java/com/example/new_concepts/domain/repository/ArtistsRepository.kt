package com.example.new_concepts.domain.repository

import com.example.new_concepts.data.model.artist.Artist

interface ArtistsRepository {
    suspend fun getArtists() : List<Artist>?
    suspend fun updateArtists() : List<Artist>?
}