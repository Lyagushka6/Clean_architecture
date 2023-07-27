package com.example.clean_architecture_month_7.domain.usecases

import com.example.clean_architecture_month_7.domain.mapper.mapToSongEntity
import com.example.clean_architecture_month_7.domain.models.SongEntity
import com.example.clean_architecture_month_7.domain.repositories.SongRepository

class GetSongUseCase(
    private val repository: SongRepository
) {

    fun getSong(): List<SongEntity>{
        return repository.getSong().mapToSongEntity()
    }
}