package com.example.clean_architecture_month_7.domain.repositories

import com.example.clean_architecture_month_7.data.models.Song

interface SongRepository {

    fun getSong(): List<Song>

    fun createSong(song: Song)

    fun updateSong(song: Song)

    fun deleteSong(song: Song)
}