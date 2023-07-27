package com.example.clean_architecture_month_7.data.database.dao

import androidx.room.*
import com.example.clean_architecture_month_7.data.models.Song

@Dao
interface SongDao {

    @Query("SELECT * FROM songs")
    suspend fun getSong(): List<Song>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun createSong(song: Song)

    @Update
    suspend fun updateSong(song: Song)

    @Delete
    suspend fun deleteSong(song: Song)
}