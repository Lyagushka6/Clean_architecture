package com.example.clean_architecture_month_7.presentation.base

import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.example.clean_architecture_month_7.presentation.utils.UiState
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

abstract class BaseActivity: AppCompatActivity() {

    protected fun<T> StateFlow<UiState<T>>.collectInfo(
        loadingState: (UiState<T>) -> Unit,
        successState: (data: T) -> Unit,
        emptyState: (message: String) -> Unit,
        errorState: (message: String) -> Unit,
    ){

        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED){
                this@collectInfo.collect {
                    when(it){
                        is UiState.Loading -> {
                            loadingState.invoke(UiState.Loading())
                        }
                        is UiState.Error ->{
                            errorState.invoke(it.message)
                        }
                        is UiState.Empty -> {
                            emptyState.invoke("empty")
                        }
                        is UiState.Success -> {
                            successState.invoke(it.data)
                        }
                    }
                }
            }
        }
    }
}