package com.example.clean_architecture_month_7.data.repositories

import com.example.clean_architecture_month_7.data.database.dao.SongDao
import com.example.clean_architecture_month_7.data.models.Song
import com.example.clean_architecture_month_7.domain.repositories.SongRepository

class SongRepositoriesImpl(
    private val songDao: SongDao,
) : SongRepository {

    override fun getSong(): List<Song> = songDao//.//getSong()

    override fun createSong(song: Song) = songDao.createSong(song)

    override fun updateSong(song: Song) = songDao.updateSong(song)

    override fun deleteSong(song: Song) = songDao.deleteSong(song)
}