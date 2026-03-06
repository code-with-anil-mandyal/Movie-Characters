package com.moviecharacters.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.moviecharacters.domain.model.Characters
import com.moviecharacters.presentation.components.CharacterDetailsScreen
import com.moviecharacters.presentation.components.CharactersScreen
import com.moviecharacters.presentation.viewModel.CharactersViewModel

@Composable
fun Navigation(){

    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Screens.CharactersScreen.route){

       composable(Screens.CharactersScreen.route){
           val characterViewMode = hiltViewModel<CharactersViewModel>()
           val characterState = characterViewMode.charactersState.collectAsStateWithLifecycle().value
           CharactersScreen(modifier = Modifier, charactersState = characterState, onClick = { character ->

                   navController.currentBackStackEntry
                       ?.savedStateHandle
                       ?.set("character", character)
                   navController.navigate(Screens.CharacterDetailScreen.route)

           })
       }

        composable(Screens.CharacterDetailScreen.route){
            val character = navController.previousBackStackEntry
                ?.savedStateHandle
                ?.get<Characters>("character")

            character?.let {
                CharacterDetailsScreen(
                    characters = it,
                    onBackClick = { navController.popBackStack() }
                )
            }

//            val character = navController.currentBackStackEntry
//                ?.savedStateHandle
//                ?.get<Characters>("character")
//
//            character?.let {
//                CharacterDetailsScreen(
//                    characters = it,
//                    onBackClick = { navController.popBackStack() }
//                )
//            }
        }
    }
}