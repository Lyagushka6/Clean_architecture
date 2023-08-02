package com.example.clean_architecture_month_7.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.example.clean_architecture_month_7.data.models.Song
import com.example.clean_architecture_month_7.presentation.utils.UiState
import com.example.cleanarchitecturemonth7.R
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private val viewModel by viewModels<SongViewModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        getSongs()
    }


    private fun getSongs() {
        viewModel.getAllSong()
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED){
                viewModel.getAllSongs.collect {
                    when(it){
                        is UiState.Loading -> {
                            print("Progress bar")
                        }
                        is UiState.Error ->{
                            Toast.makeText(this@MainActivity, it.message, Toast.LENGTH_SHORT).show()
                        }
                        is UiState.Empty -> {
                            print("empty")
                        }
                        is UiState.Success -> {
                            print("show data")
                        }
                    }
                }
            }
        }
    }
}