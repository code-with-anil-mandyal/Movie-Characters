package com.moviecharacters.presentation.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.moviecharacters.domain.model.Characters
import com.moviecharacters.presentation.state.CharactersState

@Composable
fun CharactersScreen(
    modifier : Modifier,
    charactersState: CharactersState,
    onClick : (Characters) -> Unit
){
        if(charactersState.isLoading){
//            Box(modifier = modifier.fillMaxSize()){
//                CircularProgressIndicator(modifier = modifier.align(Alignment.Center))
//            }
            CharacterListShimmer()
        }else if(!charactersState.errorMsg.isNullOrEmpty()){
            Box(modifier = modifier.fillMaxSize()){
                Text(
                    text = charactersState.errorMsg,
                    modifier = modifier.align(Alignment.Center)
                )
            }
        }

    if(charactersState.characters?.isNotEmpty()!!){
        LazyColumn{
            items(charactersState.characters){
                CharacterItem(modifier = modifier, character =  it){
                    onClick(it)
                }
            }
        }

    }
}