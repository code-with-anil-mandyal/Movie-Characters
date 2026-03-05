package com.moviecharacters.data.api

import com.moviecharacters.core.utils.ApiRoutes
import com.moviecharacters.data.dto.CharactersDto
import retrofit2.http.GET


interface CharactersApi {
    @GET(ApiRoutes.CHARACTERS)
    suspend fun getAllCharacters(): List<CharactersDto>
}