package com.moviecharacters.presentation.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.moviecharacters.core.common.Resource
import com.moviecharacters.domain.useCase.GetAllCharactersUseCase
import com.moviecharacters.presentation.state.CharactersState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.last
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class CharactersViewModel @Inject constructor(private val userCase : GetAllCharactersUseCase) : ViewModel() {

    private val _charactersState = MutableStateFlow(CharactersState()) //MutableStateFlow is hot flow
    val charactersState : StateFlow<CharactersState>
        get() = _charactersState



    init {
        getAllCharacters()
    }

    private fun getAllCharacters(){
        userCase().onEach {
            when(it){
                is Resource.Error ->{
                    _charactersState.value = CharactersState().copy(errorMsg = it.msg.toString())
                }
                is Resource.Loading ->{
                    _charactersState.value = CharactersState().copy(isLoading = true)
                }
                is Resource.Success ->{
                    _charactersState.value = CharactersState().copy(characters = it.data)
                }
            }
        }.launchIn(viewModelScope)
    }
}