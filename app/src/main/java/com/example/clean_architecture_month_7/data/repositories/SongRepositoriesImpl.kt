package com.example.clean_architecture_month_7.data.repositories

import com.example.clean_architecture_month_7.data.base.BaseRepository
import com.example.clean_architecture_month_7.data.database.dao.SongDao
import com.example.clean_architecture_month_7.data.models.Song
import com.example.clean_architecture_month_7.domain.models.SongEntity
import com.example.clean_architecture_month_7.domain.repositories.SongRepository
import com.example.clean_architecture_month_7.domain.utils.Resource
import com.example.clean_architecture_month_7.domain.utils.mapper.mapToSongEntity
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class SongRepositoriesImpl @Inject constructor(private val songDao: SongDao) : SongRepository,
    BaseRepository() {

    override fun getSong(): Flow<Resource<List<SongEntity>>> = makeRequest {
        songDao.getSong().mapToSongEntity()
    }

    override fun createSong(song: Song): Flow<Resource<Unit>> = makeRequest {
        songDao.createSong(song)
    }

    override fun updateSong(song: Song): Flow<Resource<Unit>> = makeRequest {
        songDao.updateSong(song)
    }

    override fun deleteSong(song: Song): Flow<Resource<Unit>> = makeRequest {
        songDao.deleteSong(song)
    }
}