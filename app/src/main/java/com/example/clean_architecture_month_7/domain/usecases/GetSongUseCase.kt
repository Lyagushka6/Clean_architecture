package com.example.clean_architecture_month_7.domain.usecases

import com.example.clean_architecture_month_7.domain.utils.mapper.mapToSongEntity
import com.example.clean_architecture_month_7.domain.models.SongEntity
import com.example.clean_architecture_month_7.domain.repositories.SongRepository
import javax.inject.Inject

class GetSongUseCase @Inject constructor(
    private val repository: SongRepository
) {

    fun getSong()= repository.getSong()
}