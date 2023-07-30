package com.example.clean_architecture_month_7.data.repositories

import com.example.clean_architecture_month_7.data.database.dao.SongDao
import com.example.clean_architecture_month_7.data.models.Song
import com.example.clean_architecture_month_7.domain.models.SongEntity
import com.example.clean_architecture_month_7.domain.repositories.SongRepository
import com.example.clean_architecture_month_7.domain.utils.Resource
import com.example.clean_architecture_month_7.domain.utils.mapper.mapToSongEntity
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class SongRepositoriesImpl @Inject constructor(
    private val songDao: SongDao,
) : SongRepository {

    override fun getSong(): Flow<Resource<List<SongEntity>>> {
        return flow {
            emit(Resource.Loading())
            try {
                val data = songDao.getSong()
                emit(Resource.Success(data.mapToSongEntity()))
            } catch (e: Exception) {
                emit(Resource.Error(e.localizedMessage))
            }
        }
    }

    override fun createSong(song: Song): Flow<Resource<Unit>> {
        return flow {
            emit(Resource.Loading())
            try {
                Resource.Success(songDao.createSong(song))
            } catch (e: java.lang.Exception) {
                Resource.Error(e.localizedMessage)
            }
        }
    }

    override fun updateSong(song: Song): Flow<Resource<Unit>> {
        return flow {
            emit(Resource.Loading())
            try {
                Resource.Success(songDao.updateSong(song))
            } catch (e: java.lang.Exception) {
                Resource.Error(e.localizedMessage)
            }
        }
    }

    override fun deleteSong(song: Song): Flow<Resource<Unit>> {
        return flow {
            emit(Resource.Loading())
            try {
                Resource.Success(songDao.deleteSong(song))
            } catch (e: java.lang.Exception) {
                Resource.Error(e.localizedMessage)
            }
        }
    }
}