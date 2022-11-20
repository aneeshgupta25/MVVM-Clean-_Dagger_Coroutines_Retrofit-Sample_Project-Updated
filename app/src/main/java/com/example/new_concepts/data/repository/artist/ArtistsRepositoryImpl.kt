package com.example.new_concepts.data.repository.artist

import android.util.Log
import com.example.new_concepts.data.model.artist.Artist
import com.example.new_concepts.data.repository.artist.datasource.ArtistCacheDataSource
import com.example.new_concepts.data.repository.artist.datasource.ArtistLocalDataSource
import com.example.new_concepts.data.repository.artist.datasource.ArtistRemoteDataSource
import com.example.new_concepts.domain.repository.ArtistsRepository

class ArtistsRepositoryImpl(
    private val artistRemoteDataSource: ArtistRemoteDataSource,
    private val artistLocalDataSource: ArtistLocalDataSource,
    private val artistCacheDataSource: ArtistCacheDataSource
) : ArtistsRepository {

    private val TAG = "ArtistRepositoryImpl"

    override suspend fun getArtists(): List<Artist>? {
        return getArtistsFromCache()
    }

    override suspend fun updateArtists(): List<Artist>? {
        val newListOfArtists = getArtistsFromAPI()
        artistLocalDataSource.clearAll()
        artistLocalDataSource.saveArtistsToDB(newListOfArtists)
        artistCacheDataSource.saveArtistsToCache(newListOfArtists)
        return newListOfArtists
    }

    suspend fun getArtistsFromAPI(): List<Artist> {
        var artistsList = ArrayList<Artist>()
        try {
            val artistsResponse = artistRemoteDataSource.getArtists()
            val artistsBody = artistsResponse.body()
            if (artistsBody != null) {
                artistsList = artistsBody.artists as ArrayList<Artist>
            }
        } catch (e: Exception) {
            Log.v(TAG, "Something went wrong!!!")
        }
        return artistsList
    }

    suspend fun getArtistsFromDB(): List<Artist> {
        var artistsList = ArrayList<Artist>()
        try {
            artistsList = artistLocalDataSource.getArtistsFromDB() as ArrayList<Artist>
        } catch (e: Exception) {
            Log.v(TAG, "Something went wrong!!!")
        }
        return artistsList.ifEmpty {
            val newListOfArtists = getArtistsFromAPI()
            artistLocalDataSource.clearAll()
            artistLocalDataSource.saveArtistsToDB(newListOfArtists)
            newListOfArtists
        }
    }

    suspend fun getArtistsFromCache(): List<Artist> {
        var artistList = ArrayList<Artist>()
        try {
            artistList = artistCacheDataSource.getArtistsFromCache() as ArrayList<Artist>
        } catch (e: Exception) {
            Log.v(TAG, "Something went wrong!!!")
        }
        return artistList.ifEmpty {
            val newListOfArtists = getArtistsFromDB()
            artistCacheDataSource.saveArtistsToCache(newListOfArtists)
            newListOfArtists
        }
    }
}