package com.moviecharacters.presentation.navigation

sealed class Screens(val route : String) {
    object CharactersScreen : Screens("characters_screen")
    object CharacterDetailScreen : Screens("character_detail_screen")
}


