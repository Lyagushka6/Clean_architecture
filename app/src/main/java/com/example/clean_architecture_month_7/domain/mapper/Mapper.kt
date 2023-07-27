package com.example.clean_architecture_month_7.domain.mapper

import com.example.clean_architecture_month_7.data.models.Song
import com.example.clean_architecture_month_7.domain.models.SongEntity


fun List<Song>.mapToSongEntity() = this.map {
    SongEntity(
        id = it.id,
        name = it.name,
        singer = it.singer,
        timer = it.timer
    )
}