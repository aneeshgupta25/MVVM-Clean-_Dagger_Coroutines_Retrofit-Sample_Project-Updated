package com.example.new_concepts.presentation.artist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.new_concepts.domain.usecase.GetArtistsUseCase
import com.example.new_concepts.domain.usecase.UpdateArtistsUseCase

class ArtistViewModel(
    private val getArtistsUseCase: GetArtistsUseCase,
    private val updateArtistsUseCase: UpdateArtistsUseCase
) : ViewModel() {

    //coroutine will call execute() of useCase from UI thread
    fun getArtists() = liveData {
        val artistList = getArtistsUseCase.execute()
        emit(artistList)
    }

    fun updateArtists() = liveData {
        val updatedList = updateArtistsUseCase.execute()
        emit(updatedList)
    }

}