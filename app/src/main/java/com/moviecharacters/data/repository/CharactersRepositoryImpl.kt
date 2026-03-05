package com.moviecharacters.data.repository

import androidx.compose.ui.graphics.RectangleShape
import com.moviecharacters.core.common.Resource
import com.moviecharacters.data.api.CharactersApi
import com.moviecharacters.data.mapper.toDomainCharacter
import com.moviecharacters.domain.model.Characters
import com.moviecharacters.domain.repository.CharactersRepository
import dagger.hilt.android.scopes.ViewModelScoped
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import okhttp3.Dispatcher
import javax.inject.Inject

@ViewModelScoped
class CharactersRepositoryImpl @Inject constructor(private val charactersApi: CharactersApi) : CharactersRepository {

    override fun getAllCharacters(): Flow<Resource<List<Characters>>> = flow {
        emit(Resource.Loading())

        val result = charactersApi.getAllCharacters().map {
            it.toDomainCharacter()
        }

        emit(Resource.Success(result))
    }.flowOn(Dispatchers.IO)
        .catch {
            emit(Resource.Error(it.message.toString()))
        }

}