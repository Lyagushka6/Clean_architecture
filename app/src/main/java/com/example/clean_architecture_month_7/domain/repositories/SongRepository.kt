package com.example.clean_architecture_month_7.domain.repositories

import com.example.clean_architecture_month_7.data.models.Song
import com.example.clean_architecture_month_7.domain.models.SongEntity
import kotlinx.coroutines.flow.Flow
import com.example.clean_architecture_month_7.domain.utils.Resource

interface SongRepository {

    fun getSong(): Flow<Resource<List<SongEntity>>>

    fun createSong(song: Song): Flow<Resource<Unit>>

    fun updateSong(song: Song): Flow<Resource<Unit>>

    fun deleteSong(song: Song): Flow<Resource<Unit>>
}