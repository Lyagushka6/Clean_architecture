package com.example.clean_architecture_month_7.presentation

import com.example.clean_architecture_month_7.presentation.base.BaseViewModel
import com.example.clean_architecture_month_7.data.models.Song
import com.example.clean_architecture_month_7.domain.models.SongEntity
import com.example.clean_architecture_month_7.domain.usecases.AddSongUseCase
import com.example.clean_architecture_month_7.domain.usecases.DeleteSongUseCase
import com.example.clean_architecture_month_7.domain.usecases.GetSongUseCase
import com.example.clean_architecture_month_7.domain.usecases.UpdateSongUseCase
import com.example.clean_architecture_month_7.presentation.utils.UiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class SongViewModel @Inject constructor(
    private val getSongUseCase: GetSongUseCase,
    private val updateSongUseCase: UpdateSongUseCase,
    private val addSongUseCase: AddSongUseCase,
    private val deleteSongUseCase: DeleteSongUseCase
) : BaseViewModel() {

    private val mutableStateFlow = MutableStateFlow<UiState<List<SongEntity>>>(UiState.Empty())
    val getAllSongs: StateFlow<UiState<List<SongEntity>>> = mutableStateFlow

    private val mutableFlow = MutableStateFlow<UiState<Unit>>(UiState.Empty())
    val addSong: StateFlow<UiState<Unit>> = mutableFlow
    val updateSong: StateFlow<UiState<Unit>> = mutableFlow
    val deleteSong: StateFlow<UiState<Unit>> = mutableFlow

    fun getAllSong(){
        getSongUseCase.getSong().collectData(mutableStateFlow)
    }

    fun addSong(song: Song){
        addSongUseCase.createSong(song).collectData(mutableFlow)
    }

    fun updateSong(song: Song){
        updateSongUseCase.updateSong(song).collectData(mutableFlow)
    }

    fun deleteSong(song: Song) {
        deleteSongUseCase.deleteSong(song).collectData(mutableFlow)
    }
}