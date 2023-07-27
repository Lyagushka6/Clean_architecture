package com.example.clean_architecture_month_7.data.database

import androidx.room.Database
import com.example.clean_architecture_month_7.data.database.dao.SongDao
import com.example.clean_architecture_month_7.data.models.Song

@Database(entities = [Song::class], [], 1)
abstract class RoomDatabase {

    abstract fun getSongDao(): SongDao
}