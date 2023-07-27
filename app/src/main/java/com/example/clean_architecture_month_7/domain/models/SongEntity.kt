package com.example.clean_architecture_month_7.domain.models

data class SongEntity(
    val id: Int,
    val name: String,
    val singer: String,
    val timer: Int
)
