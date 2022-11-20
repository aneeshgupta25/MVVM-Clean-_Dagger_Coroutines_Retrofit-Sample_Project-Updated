package com.example.mvvm_clean__dagger_coroutines_retrofit_sample_project_updated.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.mvvm_clean__dagger_coroutines_retrofit_sample_project_updated.data.db.ArtistDao
import com.example.mvvm_clean__dagger_coroutines_retrofit_sample_project_updated.data.db.MovieDao
import com.example.mvvm_clean__dagger_coroutines_retrofit_sample_project_updated.data.db.TvShowsDao
import com.example.mvvm_clean__dagger_coroutines_retrofit_sample_project_updated.data.model.artist.Artist
import com.example.mvvm_clean__dagger_coroutines_retrofit_sample_project_updated.data.model.movie.Movie
import com.example.mvvm_clean__dagger_coroutines_retrofit_sample_project_updated.data.model.tvshow.TvShow

@Database(
    entities = [Movie::class, TvShow::class, Artist::class],
    version = 1,
    exportSchema = false
)

abstract class TMDBDatabase : RoomDatabase() {

    abstract fun movieDao(): MovieDao
    abstract fun artistDao(): ArtistDao
    abstract fun tvDao(): TvShowsDao

}
