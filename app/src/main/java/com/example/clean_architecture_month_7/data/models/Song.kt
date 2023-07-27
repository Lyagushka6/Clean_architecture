package com.example.clean_architecture_month_7.data.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity("songs")
data class Song(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val name: String,
    val singer: String,
    val timer: Int
)
