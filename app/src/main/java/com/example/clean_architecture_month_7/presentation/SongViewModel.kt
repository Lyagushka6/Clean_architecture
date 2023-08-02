package com.example.clean_architecture_month_7.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.clean_architecture_month_7.data.models.Song
import com.example.clean_architecture_month_7.domain.models.SongEntity
import com.example.clean_architecture_month_7.domain.usecases.AddSongUseCase
import com.example.clean_architecture_month_7.domain.usecases.DeleteSongUseCase
import com.example.clean_architecture_month_7.domain.usecases.GetSongUseCase
import com.example.clean_architecture_month_7.domain.usecases.UpdateSongUseCase
import com.example.clean_architecture_month_7.domain.utils.Resource
import com.example.clean_architecture_month_7.presentation.utils.UiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SongViewModel @Inject constructor(
    private val getSongUseCase: GetSongUseCase,
    private val updateSongUseCase: UpdateSongUseCase,
    private val addSongUseCase: AddSongUseCase,
    private val deleteSongUseCase: DeleteSongUseCase
) : ViewModel() {

    private val mutableStateFlow = MutableStateFlow<UiState<List<SongEntity>>>(UiState.Empty())
    val getAllSongs: StateFlow<UiState<List<SongEntity>>> = mutableStateFlow

    fun getAllSong(){
        viewModelScope.launch {
            getSongUseCase.getSong().collect {
                when(it){
                    is  Resource.Error -> {
                        mutableStateFlow.value = UiState.Error(((it.message ?: "Some error").toString()))
                    }
                    is Resource.Loading -> {
                        mutableStateFlow.value = UiState.Loading()
                    }
                    is Resource.Success -> {
                        if (it.data != null) {
                            mutableStateFlow.value = UiState.Success(it.data)
                        }else{
                            println("You don't have data")
                        }
                    }
                }
            }
        }
    }

    fun addSong(song: Song){
        addSongUseCase.createSong(song)
    }

    fun updateSong(song: Song){
        updateSongUseCase.updateSong(song)
    }

    fun deleteSong(song: Song) {
        deleteSongUseCase.deleteSong(song)
    }
}