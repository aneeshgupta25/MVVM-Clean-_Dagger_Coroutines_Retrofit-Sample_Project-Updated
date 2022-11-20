package com.example.new_concepts.data.repository.artist.datasource

import com.example.new_concepts.data.model.artist.ArtistList
import retrofit2.Response

interface ArtistRemoteDataSource {
    suspend fun getArtists() : Response<ArtistList>
}