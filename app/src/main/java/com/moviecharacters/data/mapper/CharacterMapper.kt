package com.moviecharacters.data.mapper

import com.moviecharacters.data.dto.CharactersDto
import com.moviecharacters.domain.model.Characters
import kotlin.String

fun CharactersDto.toDomainCharacter() : Characters{
    return Characters(actor, alive, dateOfBirth, eyeColour,
        gender, hogwartsStaff, hogwartsStudent, id, image, name)
}