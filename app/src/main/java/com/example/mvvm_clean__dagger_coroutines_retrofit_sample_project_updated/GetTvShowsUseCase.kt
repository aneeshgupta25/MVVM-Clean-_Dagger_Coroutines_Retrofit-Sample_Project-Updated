package com.example.mvvm_clean__dagger_coroutines_retrofit_sample_project_updated

import com.example.mvvm_clean__dagger_coroutines_retrofit_sample_project_updated.data.model.tvshow.TvShow

class GetTvShowsUseCase(private val tvShowRepository: TvShowsRepository) {
    suspend fun execute() : List<TvShow>? = tvShowRepository.getTvShows()
}