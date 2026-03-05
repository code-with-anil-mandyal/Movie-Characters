package com.moviecharacters.domain.useCase

import com.moviecharacters.domain.repository.CharactersRepository
import javax.inject.Inject

class GetAllCharactersUseCase @Inject constructor(private val repository: CharactersRepository) {

    operator fun invoke() = repository.getAllCharacters()
}