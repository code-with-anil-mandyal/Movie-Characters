package com.moviecharacters.domain.model


import com.google.gson.annotations.SerializedName

data class Characters(
    val actor: String?,
    val alive: Boolean?,
    val dateOfBirth: String?,
    val eyeColour: String?,
    val gender: String?,
    val hogwartsStaff: Boolean?,
    val hogwartsStudent: Boolean?,
    val id: String?,
    val image: String?,
    val name: String?
)