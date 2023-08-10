package com.example.clean_architecture_month_7.presentation

import android.os.Bundle
import androidx.activity.viewModels
import com.example.clean_architecture_month_7.presentation.base.BaseActivity
import com.example.cleanarchitecturemonth7.R


class MainActivity : BaseActivity() {

    private val viewModel by viewModels<SongViewModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        getSongs()
    }


    private fun getSongs() {
        viewModel.getAllSong()
        viewModel.getAllSongs.collectInfo(
            loadingState = { println("progress bar") },
            errorState = { println("error") },
            emptyState = { println("empty: $it") },
            successState = { println("data: $it") }
        )
    }
}