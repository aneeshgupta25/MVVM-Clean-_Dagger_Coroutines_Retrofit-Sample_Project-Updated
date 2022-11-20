package com.example.new_concepts.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.new_concepts.data.model.artist.Artist
import com.example.new_concepts.data.model.movie.Movie
import com.example.new_concepts.data.model.tvshow.TvShow

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
