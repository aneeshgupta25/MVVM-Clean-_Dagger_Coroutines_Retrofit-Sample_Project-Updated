package com.example.mvvm_clean__dagger_coroutines_retrofit_sample_project_updated.domain.usecase

import com.example.mvvm_clean__dagger_coroutines_retrofit_sample_project_updated.data.model.tvshow.TvShow
import com.example.mvvm_clean__dagger_coroutines_retrofit_sample_project_updated.domain.repository.TvShowsRepository

class UpdateTvShowsUseCase(private val tvShowsRepository: TvShowsRepository) {
    suspend fun execute() : List<TvShow>? = tvShowsRepository.updateTvShows()
}