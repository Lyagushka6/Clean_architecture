package com.example.clean_architecture_month_7.domain.usecases

import com.example.clean_architecture_month_7.data.models.Song
import com.example.clean_architecture_month_7.domain.repositories.SongRepository
import javax.inject.Inject

class UpdateSongUseCase@Inject constructor(
    private val songRepository: SongRepository
){

    fun updateSong(song: Song) = songRepository.updateSong(song)
}