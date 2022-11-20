package com.example.mvvm_clean__dagger_coroutines_retrofit_sample_project_updated

import com.example.mvvm_clean__dagger_coroutines_retrofit_sample_project_updated.data.model.artist.Artist

class GetArtistsUseCase(private val artistsRepository: ArtistsRepository) {
    suspend fun execute() : List<Artist>? = artistsRepository.getArtists()
}