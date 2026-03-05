package com.moviecharacters.presentation.state

import com.moviecharacters.domain.model.Characters

data class CharactersState(
    val characters: List<Characters>?= emptyList(),
    val errorMsg: String? = "",
    val isLoading: Boolean = false
)