package com.example.new_concepts.domain.usecase

import com.example.new_concepts.data.model.artist.Artist
import com.example.new_concepts.domain.repository.ArtistsRepository

class UpdateArtistsUseCase(private val artistsRepository: ArtistsRepository) {
    suspend fun execute() : List<Artist>? = artistsRepository.updateArtists()
}