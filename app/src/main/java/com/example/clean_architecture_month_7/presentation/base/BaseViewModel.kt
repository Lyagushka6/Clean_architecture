package com.example.clean_architecture_month_7.presentation.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.clean_architecture_month_7.domain.utils.Resource
import com.example.clean_architecture_month_7.presentation.utils.UiState
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch


abstract class BaseViewModel: ViewModel() {

    protected fun <T> Flow<Resource<T>>.collectData(
        state: MutableStateFlow<UiState<T>>
    ) {
        viewModelScope.launch {
            this@collectData.collect{it ->
                when (it){
                    is Resource.Error -> {
                        state.value = UiState.Error(((it.message ?: "Some error").toString()))
                    }
                    is Resource.Loading -> {
                        state.value = UiState.Loading()
                    }
                    is Resource.Success -> {
                        if (it.data != null) {
                            state.value = UiState.Success(it.data)
                        }else{
                            println("You don't have data")
                        }
                    }
                }
            }
        }
    }
}