package com.example.new_concepts.domain.usecase

import com.example.new_concepts.data.model.tvshow.TvShow
import com.example.new_concepts.domain.repository.TvShowsRepository

class UpdateTvShowsUseCase(private val tvShowsRepository: TvShowsRepository) {
    suspend fun execute() : List<TvShow>? = tvShowsRepository.updateTvShows()
}