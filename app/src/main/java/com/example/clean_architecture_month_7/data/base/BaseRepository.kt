package com.example.clean_architecture_month_7.data.base

import com.example.clean_architecture_month_7.domain.utils.Resource
import com.example.clean_architecture_month_7.domain.utils.mapper.mapToSongEntity
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

abstract class BaseRepository {

    protected fun <T> makeRequest(coroutineRequest: suspend () -> T): Flow<Resource<T>> {
        return flow {
            emit(Resource.Loading())
            try {
                emit(Resource.Success(coroutineRequest()))
            } catch (e: Exception) {
                emit(Resource.Error(e.localizedMessage))
            }
        }
    }
}