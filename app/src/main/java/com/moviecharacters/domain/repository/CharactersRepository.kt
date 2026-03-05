package com.moviecharacters.domain.repository

import com.moviecharacters.core.common.Resource
import com.moviecharacters.domain.model.Characters
import kotlinx.coroutines.flow.Flow

interface CharactersRepository {
    fun getAllCharacters() : Flow<Resource<List<Characters>>>
}