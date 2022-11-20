package com.example.new_concepts.data.repository.artist.datasourceimpl

import com.example.new_concepts.data.api.TMDBService
import com.example.new_concepts.data.model.artist.ArtistList
import com.example.new_concepts.data.repository.artist.datasource.ArtistRemoteDataSource
import retrofit2.Response

class ArtistRemoteDataSourceImpl(
    private val tmdbService: TMDBService,
    private val apiKey : String
) : ArtistRemoteDataSource {
    override suspend fun getArtists(): Response<ArtistList> = tmdbService.getPopularArtists(apiKey = apiKey)
}