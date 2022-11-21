package com.example.new_concepts.presentation.movie

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.new_concepts.domain.usecase.GetMoviesUseCase
import com.example.new_concepts.domain.usecase.UpdateArtistsUseCase
import com.example.new_concepts.domain.usecase.UpdateMoviesUseCase

class MovieViewModel(
    private val getMoviesUseCase: GetMoviesUseCase,
    private val updateMoviesUseCase: UpdateMoviesUseCase
) : ViewModel() {

    fun getMovies() = liveData {
        val moviesList = getMoviesUseCase.execute()
        emit(moviesList)
    }

    fun updateMovies() = liveData {
        val updatedList = updateMoviesUseCase.execute()
        emit(updatedList)
    }
}