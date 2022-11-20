package com.example.new_concepts.domain.usecase

import com.example.new_concepts.data.model.tvshow.TvShow
import com.example.new_concepts.domain.repository.TvShowsRepository

class GetTvShowsUseCase(private val tvShowRepository: TvShowsRepository) {
    suspend fun execute() : List<TvShow>? = tvShowRepository.getTvShows()
}